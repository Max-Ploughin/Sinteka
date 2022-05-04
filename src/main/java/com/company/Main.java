package com.company;

import java.io.*;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {
        try {

            String path = new File("input.txt").getAbsolutePath();
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            ArrayList listForValues = new ArrayList();

            while (line != null) {

                listForValues.add(line);
                line = reader.readLine();
            }

            int firstRange = Integer.parseInt(String.valueOf(listForValues.get(0)));
            int size = listForValues.size();
            int secondRange = Integer.parseInt(String.valueOf(listForValues.get(size-1)));

            ArrayList arrayOfFirstRange = new ArrayList();
            ArrayList arrayOfSecondRange = new ArrayList();

            System.out.println(firstRange);
            for (int i=1; i <= firstRange; i++){
                System.out.println(listForValues.get(i));
                arrayOfFirstRange.add(String.valueOf(listForValues.get(i)));
            }

            System.out.println();
            System.out.println(secondRange);

            for (int i=firstRange+1; i <= firstRange + secondRange; i++){
                System.out.println(listForValues.get(i));
                arrayOfSecondRange.add(String.valueOf(listForValues.get(i)));
            }

            SimilarWords test = new SimilarWords();

            System.out.println();

            ArrayList pairs = test.pairOfWords(arrayOfFirstRange, arrayOfSecondRange);
            for (int i=0; i< pairs.size(); i++){
                System.out.println(pairs.get(i));
            }

            String outputFileName = "output.txt";
            try (BufferedWriter writter = new BufferedWriter(new FileWriter(outputFileName))) {
                for (Object value : pairs) {
                    writter.write(value + "\n");
                }
            }

        }
        catch (FileNotFoundException exp) {
            exp.printStackTrace();
        }
        catch (IOException exp) {
            exp.printStackTrace();
        }


    }
}
