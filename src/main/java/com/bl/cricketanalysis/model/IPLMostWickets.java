package com.bl.cricketanalysis.model;

import com.opencsv.bean.CsvBindByName;

public class IPLMostWickets {
    @CsvBindByName(column = "POS")
    public String POS;
    @CsvBindByName(column = "PLAYER")
    public String PLAYER;
    @CsvBindByName(column = "Mat")
    public String Mat;
    @CsvBindByName(column = "Inns")
    public String Inns;
    @CsvBindByName(column = "Ov")
    public double Ov;
    @CsvBindByName(column = "Runs")
    public double Runs;
    @CsvBindByName(column = "Wkts")
    public double Wkts;
    @CsvBindByName(column = "BBI")
    public String BBI;
    @CsvBindByName(column = "Avg")
    public double Avg;
    @CsvBindByName(column = "Econ")
    public double Econ;
    @CsvBindByName(column = "SR")
    public double SR;
    @CsvBindByName(column = "4w")
    public double FourWickets;
    @CsvBindByName(column = "5w")
    public double FiveWickets;
    public IPLMostWickets (){
    }
    public String getPLAYER() {
        return PLAYER;
    }

   @ Override
    public String toString() {
        return "IplMostWickets{" +
                "POS='" + POS + '\'' +
                ", PLAYER='" + PLAYER + '\'' +
                ", Mat='" + Mat + '\'' +
                ", Inns='" + Inns + '\'' +
                ", Ov='" + Ov + '\'' +
                ", Runs='" + Runs + '\'' +
                ", Wkts='" + Wkts + '\'' +
                ", BBI='" + BBI + '\'' +
                ", Avg='" + Avg + '\'' +
                ", Econ='" + Econ + '\'' +
                ", SR='" + SR + '\'' +
                ", FourWickets='" + FourWickets + '\'' +
                ", FiveWickets='" + FiveWickets + '\'' +
                '}';
    }
}
