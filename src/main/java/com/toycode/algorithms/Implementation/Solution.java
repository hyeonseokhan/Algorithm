package com.toycode.algorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Result {
    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */
    public static void extraLongFactorials(int n) {
        // Write your code here
        int cur = n;
        BigInteger bi = new BigInteger("1");
        while (cur > 0) {
            bi = bi.multiply(BigInteger.valueOf(cur));
            cur--;
        }
        System.out.println(bi);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        Result.extraLongFactorials(n);
        bufferedReader.close();
    }
}
