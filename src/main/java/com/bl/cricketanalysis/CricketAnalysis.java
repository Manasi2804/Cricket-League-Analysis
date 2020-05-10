package com.bl.cricketanalysis;

import com.bl.cricketanalysis.builder.CSVBuilderFactory;
import com.bl.cricketanalysis.builder.ICSVBuilder;
import com.bl.cricketanalysis.exception.CSVBuilderException;
import com.bl.cricketanalysis.model.IPLMostRuns;
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

    public int loadData(String filePath) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            censusCSVList = csvBuilder.getCSVFileList(reader, IPLMostRuns.class);
            System.out.println(censusCSVList);
            return censusCSVList.size();
        } catch (IOException e) {
            throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.INCORRECT_FILE);
        }
    }
    private <E> int getCount(Iterator<E> iterator) {
        Iterable<E> csvIterable = () -> iterator;
        int numberOfEnteries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
        return numberOfEnteries;
    }
    public String getAverageWiseSorted() {
        if (censusCSVList.size() == 0 || censusCSVList == null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLMostRuns> iplMostRunsComparator = Comparator.comparing(census -> census.Avg);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
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
}