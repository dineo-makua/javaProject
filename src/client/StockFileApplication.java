package client;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StockFileApplication {

    public static void main(String args[]) throws IOException {
        StockFileReader fr = new StockFileReader("table.csv");

        List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
        StockFileData fileData = new StockFileData();
        fileData.addData(dataResult);
        fileData.printData();
        System.out.println(dataResult.size());
    }
    /**
     * Complete the method body so that it returns the given structure needed to
     * populate the data field in the StockFileData class.
     * @param headers
     * @param lines
     * @return List
     */
    public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines) {
        List<HashMap<String, Double>> dataResult = new ArrayList<>();

        for (String line : lines) {
            String[] values = line.split(","); // Split each row by comma
            int cout = 0;
            HashMap<String, Double> headerRowMap = new HashMap<>();

            for (String value: values) {

                    double dval = Double.parseDouble(value);
                    headerRowMap.put(headers.get(cout), dval);
                    cout++;

            }
            dataResult.add(headerRowMap);
        }

        return dataResult;
    }



}

