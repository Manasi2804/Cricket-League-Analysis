package com.bl.cricketanalysis;

import com.bl.cricketanalysis.exception.CSVBuilderException;
import com.bl.cricketanalysis.model.IPLMostRuns;
import com.bl.cricketanalysis.model.IPLMostWickets;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

public class CricketAnalysisTest {
    CricketAnalysis cricketAnalysis = new CricketAnalysis();

    public static final String PATH_OF_CSV_FILE = "./src/test/resources/MostRunsData.csv";
    public static final String PATH_OF_MOST_WICKET_CSV_FILE = "./src/test/resources/MostWicketData.csv";

    @Test
    public void givenTheCSVFile_WhenNoOfRecordMatch_ShouldReturnTrue() throws IOException {
            int noOfRecords = cricketAnalysis.loadDataForRuns(PATH_OF_CSV_FILE);
            Assert.assertEquals(100, noOfRecords);
    }
    //1
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnBestBattingAverage() throws IOException {
        cricketAnalysis.loadDataForRuns(PATH_OF_CSV_FILE);
        String sortedCensusData = cricketAnalysis.getAverageWiseSorted();
        IPLMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData, IPLMostRuns[].class);
        String name = censusCsv[0].getPLAYER();
        Assert.assertEquals("MS Dhoni", name);
    }
    //2
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnSortedStrikeRate() throws IOException {
            cricketAnalysis.loadDataForRuns(PATH_OF_CSV_FILE);
            String sortedCensusData = cricketAnalysis.getStrikerateWiseSorted();
            IPLMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData, IPLMostRuns[].class);
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("Ishant Sharma", name);
    }
    //3
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnSortedFours() throws IOException {
            cricketAnalysis.loadDataForRuns(PATH_OF_CSV_FILE);
            String sortedCensusData = cricketAnalysis.getFoursWiseSorted();
            IPLMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData, IPLMostRuns[].class);
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("Shikhar Dhawan", name);

    }
    //3
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnSortedSixes() throws IOException {
            cricketAnalysis.loadDataForRuns(PATH_OF_CSV_FILE);
            String sortedCensusData = cricketAnalysis.getSixesWiseSorted();
            IPLMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData, IPLMostRuns[].class);
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("Andre Russell", name);
    }
    //3.1
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnMaximum6sn4s() throws IOException {
        cricketAnalysis.loadDataForRuns(PATH_OF_CSV_FILE);
        String sortedCensusData = cricketAnalysis.getmaximum6sn4sWiseSorted();
        IPLMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData, IPLMostRuns[].class);
        String name = censusCsv[0].getPLAYER();
        Assert.assertEquals("Andre Russell", name);
    }
    //4
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnSortedStrikeRateWithFoursAndSixes() throws IOException {
            cricketAnalysis.loadDataForRuns(PATH_OF_CSV_FILE);
            String sortedCensusData = cricketAnalysis.get4sn6sWiseSorted();
            IPLMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData, IPLMostRuns[].class);
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("Ishant Sharma", name);
    }
    //5
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnSortedAverageWithBestSR() throws IOException {
            cricketAnalysis.loadDataForRuns(PATH_OF_CSV_FILE);
            String sortedCensusData = cricketAnalysis.getAverageWithBestSRWiseSorted();
            IPLMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData, IPLMostRuns[].class);
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("David Warner", name);

    }
    //6
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnSortedRunsWithBestAvg() throws IOException {
            cricketAnalysis.loadDataForRuns(PATH_OF_CSV_FILE);
            String sortedCensusData = cricketAnalysis.getBestAverageWithRunsWiseSorted();
            IPLMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData, IPLMostRuns[].class);
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("David Warner", name);
    }

    @Test
    public void givenFilePathGForWickets_WhenNoOfRecordMatches_ThenReturnTrue() {
            int noOfRecords = cricketAnalysis.loadDataForWickets(PATH_OF_MOST_WICKET_CSV_FILE);
            Assert.assertEquals(99, noOfRecords);
    }
    //7
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnSortedWithTopBowlingAvg() {
            cricketAnalysis.loadDataForWickets(PATH_OF_MOST_WICKET_CSV_FILE);
            String sortedCensusData = cricketAnalysis.getWicketsWithBestBowlingAverageWiseSorted();
            IPLMostWickets[] censusCsv = new Gson().fromJson(sortedCensusData, IPLMostWickets[].class);
            String name = censusCsv[98].getPLAYER();
            Assert.assertEquals("Anukul Roy", name);
    }
    //8
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnSortedWithStrikeRate() {
            cricketAnalysis.loadDataForWickets(PATH_OF_MOST_WICKET_CSV_FILE);
            String sortedCensusData = cricketAnalysis.getBestStrikingRateWiseSorted();
            IPLMostWickets[] censusCsv = new Gson().fromJson(sortedCensusData, IPLMostWickets[].class);
            String name = censusCsv[98].getPLAYER();
            Assert.assertEquals("Alzarri Joseph", name);

    }
    //9
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnSortedWithBestEconomy() {
            cricketAnalysis.loadDataForWickets(PATH_OF_MOST_WICKET_CSV_FILE);
            String sortedCensusData = cricketAnalysis.getBestEconomyWiseSorted();
            IPLMostWickets[] censusCsv = new Gson().fromJson(sortedCensusData, IPLMostWickets[].class);
            String name = censusCsv[98].getPLAYER();
            Assert.assertEquals("Shivam Dube", name);

    }
    //10
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnSortedWithStrikeRate4w() {
            cricketAnalysis.loadDataForWickets(PATH_OF_MOST_WICKET_CSV_FILE);
            String sortedCensusData = cricketAnalysis.getWicketsWithBestStrikingRate4wWiseSorted();
            IPLMostWickets[] censusCsv = new Gson().fromJson(sortedCensusData, IPLMostWickets[].class);
            double runs = censusCsv[0].FourWickets;
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("Imran Tahir", name);

    }
    //10
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnSortedWithStrikeRate5w() {
            cricketAnalysis.loadDataForWickets(PATH_OF_MOST_WICKET_CSV_FILE);
            String sortedCensusData = cricketAnalysis.getWicketsWithBestStrikingRate5wWiseSorted();
            IPLMostWickets[] censusCsv = new Gson().fromJson(sortedCensusData, IPLMostWickets[].class);
            double runs = censusCsv[0].FiveWickets;
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("Alzarri Joseph", name);
    }
    //11
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnSortedWithTopStrikingRateAndAvg() {
            cricketAnalysis.loadDataForWickets(PATH_OF_MOST_WICKET_CSV_FILE);
            String sortedCensusData = cricketAnalysis.getWicketsWithBestWicketsWiseSorted();
            IPLMostWickets[] censusCsv = new Gson().fromJson(sortedCensusData, IPLMostWickets[].class);
            double runs = censusCsv[0].Avg;
            String name = censusCsv[98].getPLAYER();
            Assert.assertEquals("Anukul Roy", name);
    }
    //12
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnSortedWithTopWickets() {
            cricketAnalysis.loadDataForWickets(PATH_OF_MOST_WICKET_CSV_FILE);
            String sortedCensusData = cricketAnalysis.getWicketsWithBestWicketsWiseSorted();
            IPLMostWickets[] censusCsv = new Gson().fromJson(sortedCensusData, IPLMostWickets[].class);
            double runs = censusCsv[0].Avg;
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("Krishnappa Gowtham", name);

    }
    //13
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnBestBowlingAndBattingAvg() {
        cricketAnalysis.loadDataForWickets(PATH_OF_MOST_WICKET_CSV_FILE);
        String sortedCensusData = cricketAnalysis.getWicketsWithBestBowlingAverageWiseSorted();
        IPLMostWickets[] censusCsv = new Gson().fromJson(sortedCensusData, IPLMostWickets[].class);
        double runs = censusCsv[0].Avg;
        String name = censusCsv[98].getPLAYER();
        Assert.assertEquals("Anukul Roy", name);
    }
    //14
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnAllRounder() {
            cricketAnalysis.loadDataForWickets(PATH_OF_MOST_WICKET_CSV_FILE);
            String sortedData = cricketAnalysis.getWicketsWithBestAllRounderWiseSorted();
            IPLMostRuns[] censusCsv = new Gson().fromJson(sortedData, IPLMostRuns[].class);
            String names = censusCsv[0].getPLAYER();
            Assert.assertEquals("Deepak Chahar", names);
    }
}
