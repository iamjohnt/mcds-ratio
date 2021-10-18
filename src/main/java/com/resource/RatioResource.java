package com.resource;

import com.dao.CaseData;
import com.dao.HospData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class RatioResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/ratio/case-hosp")
    public List<Double> getCaseHospitalizationRatio() {

        // handle the generic parameters
        ParameterizedTypeReference<List<CaseData>> caseDataClass = new ParameterizedTypeReference<List<CaseData>>(){};
        ParameterizedTypeReference<List<HospData>> hospDataClass = new ParameterizedTypeReference<List<HospData>>(){};

        // get all the case data
        List<CaseData> caseData = webClientBuilder.build()
                .get()
                .uri("https://mcds-database.herokuapp.com/database/cases")
                .retrieve()
                .bodyToMono(caseDataClass)
                .block();

        // get all the hospitalization data
        List<HospData> hospData = webClientBuilder.build()
                .get()
                .uri("https://mcds-database.herokuapp.com/database/hospitalizations")
                .retrieve()
                .bodyToMono(hospDataClass)
                .block();

        return calculateRatio(caseData, hospData);
    }

    private List<Double> calculateRatio(List<CaseData> c, List<HospData> h) {

        // loop and incremenet c's pointer or h's pointer, until their contents equal
        // then loop and get the ratio of the contents, and add it to the list. do this until the end
        // then return the list of ratios
        List<Double> rtn = new ArrayList<>();
        int i = 0;
        int k = 0;
        while (i < c.size() && k < c.size()) {
            Date first = c.get(i).getInfectionDate();
            Date second = h.get(k).getHospDate();
            int compare = first.compareTo(second);
            System.out.println(first.toString() + " " + second.toString() + " " + compare);
            if (compare > 0) {
                k++;
            } else if (compare < 0) {
                i++;
            } else {
                if (h.get(k).getNewHosp() != null && c.get(i).getCasesNew() != null) {
                    Double d1 = Double.valueOf(h.get(k).getNewHosp());
                    Double d2 = Double.valueOf(c.get(i).getCasesNew());
                    rtn.add(d1 / d2);
                }
                i++;
                k++;
            }
        }
        return rtn;
    }


}
