package com.bl.cricketanalysis.dao;

import com.bl.cricketanalysis.model.IPLMostRuns;

public class CricketDAO {
    public String POS;
    public String PLAYER;
    public String Mat;
    public String Inns;
    public String NO;
    public String Runs;
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
        this.POS=iplMostRuns.POS;
        this.PLAYER=iplMostRuns.PLAYER;
        this.Mat=iplMostRuns.Mat;
        this.Inns=iplMostRuns.Inns;
        this.NO=iplMostRuns.NO;
        this.Runs=iplMostRuns.Runs;
        this.HS=iplMostRuns.HS;
        this.Avg=iplMostRuns.Avg;
        this.BF=iplMostRuns.BF;
        this.hundred=iplMostRuns.hundred;
        this.fifty=iplMostRuns.fifty;
        this.fours=iplMostRuns.fours;
        this.sixs=iplMostRuns.sixs;
        this.SR=iplMostRuns.SR;
    }
}
