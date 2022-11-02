package com.toycode.algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Camping_Fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if (L == 0 && P == 0 && V == 0)
                break;

            int _L = L;
            int _P = P;
            int _V = V;

            int days = 0;
            for (int i = 0; i < _V; i++) {
                if (_P > 0) {
                    if (_L > 0) {
                        _L--;
                        days++;
                    }
                    _P--;
                }
                if (_P == 0 && _L == 0) {
                    _P = P;
                    _L = L;
                }
            }
            System.out.printf("Case %s: %s%n", cases, days);
            cases++;
        }
    }
}
