package com.dao;

import java.util.Date;

public class DeathData {

    private Date deathDate;

    private Integer deaths;
    private Integer deathsSum;
    private Integer probableDeaths;
    private Integer probableDeathsSum;
    private Integer deathsSevenDayAvg;

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getDeathsSum() {
        return deathsSum;
    }

    public void setDeathsSum(Integer deathsSum) {
        this.deathsSum = deathsSum;
    }

    public Integer getProbableDeaths() {
        return probableDeaths;
    }

    public void setProbableDeaths(Integer probableDeaths) {
        this.probableDeaths = probableDeaths;
    }

    public Integer getProbableDeathsSum() {
        return probableDeathsSum;
    }

    public void setProbableDeathsSum(Integer probableDeathsSum) {
        this.probableDeathsSum = probableDeathsSum;
    }

    public Integer getDeathsSevenDayAvg() {
        return deathsSevenDayAvg;
    }

    public void setDeathsSevenDayAvg(Integer deathsSevenDayAvg) {
        this.deathsSevenDayAvg = deathsSevenDayAvg;
    }
}
