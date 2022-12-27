/*
 * Copyright (c) 2022 DreamSecurity Corporation. All rights reserved.
 * DreamSecurity Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.toycode.algorithms.dfs;

import java.util.Scanner;

public class Virus {
    static int[][]      map;
    static boolean[]    visit;
    static int          n, m, v;
    static int          count = 0;

    public static int dfs(int i) {
        visit[i] = true;
        for (int j = 1; j <= n; j++) {
            if (map[i][j] == 1 && !visit[j]) {
                count++;
                dfs(j);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();             // 컴퓨터 수(정점)
        m = scan.nextInt();             // 연결된 컴퓨터 쌍의 수(간선)
        v = 1;                          // 탐색 시장할 정점의 번호
        map = new int[n + 1][n + 1];    // 각 정점간 탐색 경로를 저장할 배열
        visit = new boolean[n + 1];     // 정점의 탐색 여부 체크

        for (int i = 0; i < m; i++) {   // 간선의 수 반복문
            int sNode = scan.nextInt();
            int eNode = scan.nextInt();
            map[sNode][eNode] = map[eNode][sNode] = 1;
        }

        System.out.println(dfs(v));
        scan.close();
    }
}
