package aggregators;

import fileprocessors.StockFileReader;

import java.io.IOException;
import java.util.List;

public class AggregatorProcessor<T extends Aggregator> {
    private T aggregator;
    private String fileName;

    // Constructor to initialize aggregator and file name
    public AggregatorProcessor(T aggregator, String fileName) {
        super();
        this.aggregator = aggregator;
        this.fileName = fileName;
    }

    // Method to run the aggregator and return the processed value
    public double runAggregator(int columnIndex) throws IOException {
        StockFileReader fileReader = new StockFileReader(fileName);
        List<String> lines = fileReader.readFileData();

        for (String line : lines){
            String [] numbers = line.split(",");
            Double value = Double.parseDouble(numbers[columnIndex]);
            aggregator.add(value);
        }
        double number = aggregator.calculate();
        return number;
    }
}