package com.dao;

import java.util.Date;

public class CaseData {

    private Date infectionDate;

    private Integer casesRunningSum;
    private Integer casesNew;
    private Double casesSevenDayAverage;

    public Date getInfectionDate() {
        return infectionDate;
    }

    public void setInfectionDate(Date infectionDate) {
        this.infectionDate = infectionDate;
    }

    public Integer getCasesRunningSum() {
        return casesRunningSum;
    }

    public void setCasesRunningSum(Integer casesRunningSum) {
        this.casesRunningSum = casesRunningSum;
    }

    public Integer getCasesNew() {
        return casesNew;
    }

    public void setCasesNew(Integer casesNew) {
        this.casesNew = casesNew;
    }

    public Double getCasesSevenDayAverage() {
        return casesSevenDayAverage;
    }

    public void setCasesSevenDayAverage(Double casesSevenDayAverage) {
        this.casesSevenDayAverage = casesSevenDayAverage;
    }
}
