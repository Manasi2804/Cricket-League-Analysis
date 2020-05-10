package com.bl.cricketanalysis;

import com.bl.cricketanalysis.exception.CSVBuilderException;
import com.bl.cricketanalysis.model.IPLMostRuns;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;


public class CricketAnalysisTest {
    CricketAnalysis cricketAnalysis;
    public static String PATH_OF_CSV_FILE = "./src/test/resources/MostRunsData.csv";

    @Test
    public void givenTheCSVFile_WhenNoOfRecordMatch_ShouldReturnTrue() {
        try {
            int noOfRecords = cricketAnalysis.loadData(PATH_OF_CSV_FILE);
            Assert.assertEquals(100, noOfRecords);
        } catch (Exception e) {
        }
    }
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnBestBattingAverage(){
       try {
            cricketAnalysis.loadData(PATH_OF_CSV_FILE);
            String sortedCensusData = cricketAnalysis.getAverageWiseSorted();
            IPLMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData, IPLMostRuns[].class);
            double runs = censusCsv[0].Avg;
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("MS Dhoni", name);
        } catch (Exception e) {
        }
    }
}