package com.bl.cricketanalysis.dao;

import com.bl.cricketanalysis.model.IPLMostRuns;

public class CricketDAO {
    public String POS;
    public String PLAYER;
    public String Mat;
    public String Inns;
    public String NO;
    public double Runs;
    public String HS;
    public double Avg;
    public String BF;
    public double SR;
    public String hundred;
    public String fifty;
    public double fours;
    public double sixs;

    public CricketDAO(IPLMostRuns iplMostRuns)
    {
        POS=iplMostRuns.POS;
        PLAYER=iplMostRuns.PLAYER;
        Mat=iplMostRuns.Mat;
        Inns=iplMostRuns.Inns;
        NO=iplMostRuns.NO;
        Runs=iplMostRuns.Runs;
        HS=iplMostRuns.HS;
        Avg=iplMostRuns.Avg;
        BF=iplMostRuns.BF;
        hundred=iplMostRuns.hundred;
        fifty=iplMostRuns.fifty;
        fours=iplMostRuns.fours;
        sixs=iplMostRuns.sixs;
        SR=iplMostRuns.SR;
    }
}
