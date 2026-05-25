import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesReader {
    //atributer
    String filePath;
    File file;
    ArrayList<Integer> salesList = new ArrayList<>();

    //constructor

    public SalesReader (String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);
    }


    //scanner
    Scanner scan;

    //methods

    //"readFile"
    public void readFileAndParse() {
        try {
            scan = new Scanner(file);
            scan.nextLine();
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] values = line.split(",");
                String month = values[0].trim();
                //System.out.println(line);
                int salesNumbers = Integer.parseInt(values[1].trim());
                salesList.add(salesNumbers);
                System.out.println("i månede " + month + " solgte i for " + salesNumbers);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Filen eksistere ikke");
        }
    }

    public int calculateTotal() {
        int total = 0;
        for (int number : salesList)
            total = total + number;
        return total;
    }

    public double average() {
        double average = (double) calculateTotal() / 12;
        return average;
    }

    // max salg i guess?
    public int max() {
        int max = 0;
        for (int number : salesList)
            if (number > max) {
                max = number;
            }
        return max;
    }
}



