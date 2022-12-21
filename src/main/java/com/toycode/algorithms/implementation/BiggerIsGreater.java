package com.toycode.algorithms.implementation;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

class Result1 {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */
    public static String biggerIsGreater(String w) throws IOException {
        // Write your code here
        int lastIndex = w.length() - 1;
        for (int index = lastIndex - 1; index >= 0; index--) {
            char lChar = w.charAt(index);
            char[] subStrA = w.substring(index + 1).toCharArray();
            Arrays.sort(subStrA);
            for (int j = 0; j < subStrA.length; j++) {
                char eChar = subStrA[j];
                if (lChar < eChar) {
                    StringBuilder begining = new StringBuilder(w.substring(0, index + 1));
                    begining.replace(index, index + 1, String.valueOf(eChar));
                    subStrA[j] = lChar;
                    Arrays.sort(subStrA);
                    return begining + String.valueOf(subStrA);
                }
            }
        }
        return "no answer";
    }
}

public class BiggerIsGreater {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./tmp.txt"));


        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result1.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
