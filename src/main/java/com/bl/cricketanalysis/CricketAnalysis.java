package com.bl.cricketanalysis;

import com.bl.cricketanalysis.builder.CSVBuilderFactory;
import com.bl.cricketanalysis.builder.ICSVBuilder;
import com.bl.cricketanalysis.exception.CSVBuilderException;
import com.bl.cricketanalysis.model.IPLMostRuns;
import com.bl.cricketanalysis.model.IPLMostWickets;
import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CricketAnalysis {
    List<IPLMostRuns> censusCSVList= null;
    List<IPLMostWickets> WicketsList = null;

    public int loadDataForRuns(String filePath)throws IOException,CSVBuilderException {
        try{
            BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            censusCSVList = csvBuilder.getCSVFileList(reader, IPLMostRuns.class);
            System.out.println(censusCSVList);
            return censusCSVList.size();
            } catch(IOException e){
                throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.FILE_NOT_FOUND);
            } catch(RuntimeException e){
                throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.INCORRECT_FILE);
            }
        }
    public int loadDataForWickets(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            WicketsList = csvBuilder.getCSVFileList(reader, IPLMostWickets.class);
            System.out.println(WicketsList);
            return WicketsList.size();
        } catch (IOException e) {
            throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.INCORRECT_FILE);
        }
    }

    public String getAverageWiseSorted() {
        if (censusCSVList.size() == 0 || censusCSVList == null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLMostRuns> iplMostRunsComparator = Comparator.comparing(census -> census.Avg);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }
    public String getStrikerateWiseSorted()  {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLMostRuns> iplMostRunsComparator = Comparator.comparing(census -> census.SR);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }
    public String getFoursWiseSorted()  {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLMostRuns> iplMostRunsComparator = Comparator.comparing(census -> census.fours);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }
    public String getSixesWiseSorted()  {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLMostRuns> iplMostRunsComparator = Comparator.comparing(census -> census.sixs);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }
    public String getmaximum6sn4sWiseSorted()  {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLMostRuns> iplMostRunsComparator = Comparator.comparing(census -> census.sixs+census.fours);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }
    public String get4sn6sWiseSorted()  {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLMostRuns> iplMostRunsComparator = Comparator.comparing(census -> census.SR);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }
    public String getAverageWithBestSRWiseSorted(){
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLMostRuns> iplMostRunsComparator = Comparator.comparing(census -> (census.Avg+census.SR)>100);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }
    public String getBestAverageWithRunsWiseSorted(){
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLMostRuns> iplMostRunsComparator = Comparator.comparing(census -> (census.Runs+ census.Avg)/2);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }
    public String getBestStrikingRateWiseSorted(){
        if(WicketsList.size()==0 || WicketsList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLMostWickets> iplMostWicketsComparator = Comparator.comparing(census -> ((census.Ov)*6)/census.Wkts);
        this.sortForWickets(iplMostWicketsComparator);
        String sortedCensusJson = new Gson().toJson(WicketsList);
        return sortedCensusJson;
    }
    public String getBestEconomyWiseSorted(){
        if(WicketsList.size()==0 || WicketsList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLMostWickets> iplMostWicketsComparator = Comparator.comparing(census -> census.Econ);
        this.sortForWickets(iplMostWicketsComparator);
        String sortedCensusJson = new Gson().toJson(WicketsList);
        return sortedCensusJson;
    }
    public String getWicketsWithBestStrikingRate4wWiseSorted(){
        if(WicketsList.size()==0 || WicketsList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLMostWickets> iplMostWicketsComparator = Comparator.comparing(census -> census.FourWickets);
        this.sortForWickets(iplMostWicketsComparator);
        String sortedCensusJson = new Gson().toJson(WicketsList);
        return sortedCensusJson;
    }
    public String getWicketsWithBestStrikingRate5wWiseSorted(){
        if(WicketsList.size()==0 || WicketsList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLMostWickets> iplMostWicketsComparator = Comparator.comparing(census ->census.FiveWickets);
        this.sortForWickets(iplMostWicketsComparator);
        String sortedCensusJson = new Gson().toJson(WicketsList);
        return sortedCensusJson;
    }
    public String getWicketsWithBestWicketsWiseSorted(){
        if(WicketsList.size()==0 || WicketsList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLMostWickets> iplMostWicketsComparator = Comparator.comparing(census -> ((census.Runs/census.Wkts)+census.SR)/2);
        this.sortForWickets(iplMostWicketsComparator);
        String sortedCensusJson = new Gson().toJson(WicketsList);
        return sortedCensusJson;
    }
    public String getWicketsWithBestBowlingAverageWiseSorted() {
        if (WicketsList.size() == 0 || WicketsList == null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLMostWickets> iplMostWicketsComparator = Comparator.comparing(census -> (census.Runs / census.Wkts));
        this.sortForWickets(iplMostWicketsComparator);
        String sortedCensusJson = new Gson().toJson(WicketsList);
        return sortedCensusJson;
    }
    public String getWicketsWithBestAllRounderWiseSorted(){
        if(WicketsList.size()==0 || WicketsList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLMostWickets> iplMostWicketsComparator = Comparator.comparing(census -> census.Runs+census.Wkts);
        this.sortForWickets(iplMostWicketsComparator);
        String sortedCensusJson = new Gson().toJson(WicketsList);
        return sortedCensusJson;
    }
    private void sort(Comparator<IPLMostRuns> iplMostRunsComparator) {
        for (int i = 0; i < censusCSVList.size() - 1; i++) {
            for (int j = 0; j < censusCSVList.size() - i - 1; j++) {
                IPLMostRuns census1 = censusCSVList.get(j);
                IPLMostRuns census2 = censusCSVList.get(j + 1);
                if (iplMostRunsComparator.compare(census1, census2) < 0) {
                    censusCSVList.set(j, census2);
                    censusCSVList.set(j + 1, census1);
                }
            }
        }
    }
    private void sortForWickets(Comparator<IPLMostWickets> iplMostWicketsComparator) {
        for (int i = 0; i < WicketsList.size()-1; i++){
            for (int j=0; j < WicketsList.size()-i-1; j++){
                IPLMostWickets census1 = WicketsList.get(j);
                IPLMostWickets census2 = WicketsList.get(j+1);
                if (iplMostWicketsComparator.compare(census1,census2)<0){
                    WicketsList.set(j,census2);
                    WicketsList.set(j+1,census1);
                }
            }
        }
    }
}