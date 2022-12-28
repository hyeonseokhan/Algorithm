/*
 * Copyright (c) 2022 DreamSecurity Corporation. All rights reserved.
 * DreamSecurity Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.toycode.algorithms.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DFS {
    static ArrayList<Integer>[] lists;
    static boolean[] visit;                     // 방문여부 확인목록.
    /**
     * 그래프 저장방법 중 인접리스트 기반으로 작성된 예제
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();               // 모든 노드의 수
        int lines = sc.nextInt();               // 모든 간선의 수
        int root  = sc.nextInt();               // 시작할 노드

        lists = new ArrayList[nodes + 1];       // 인덱스 편의상 '0' 번째 인덱스를 사용하지 않기위해 'nodes + 1' 을 한다.
        visit = new boolean[nodes + 1];         // 인덱스 편의상 '0' 번째 인덱스를 사용하지 않기위해 'nodes + 1' 을 한다.

        for (int i = 1; i <= nodes; i++)
            lists[i] = new ArrayList<>();

        for (int i = 0; i < lines; i++) {       // 노드관계 리스트 그리기
            int from    = sc.nextInt();         // 'A to B' 노드연결 구조에서 '기준노드'는 (A) 이다. 즉, 'from' == 'A' 이다.
            int to      = sc.nextInt();         // 'A to B' 노드연결 구조에서 '대상노드'는 (B) 이다. 즉, 'to' == 'B' 이다.

            lists[from].add(to);                // 'lists[from]' 인덱스에 기준노드를 등록해준다. '.add(to)' 값에는 대상노드를 등록해준다.
            lists[to].add(from);                // Tip) 문제의 조건이 양방향일 경우 반대의 수도 등록해 준다.
        }

        dfs(root);                              // 루트노드 부터 탐색을 진행할 수 있도록 지정해준다.

        System.out.println("\nlists : "+ Arrays.toString(lists));
        System.out.println("visit : "+Arrays.toString(visit));

        sc.close();
    }

    /**
     *
     * @param node 시작할 노드
     */
    static void dfs(int node) {
        System.out.printf("visited %s%n", node);
        visit[node] = true;                     // 탐색을 시작한 노드의 방문여부를 채크한다.
        for (int to : lists[node])              // 노드관계 리스트에서 '기준노드'의 '대상노드'를 찾는다.
            if (!visit[to])                     // '대상노드'의 방문여부 확인.
                dfs(to);                        // 방문여부가 'false' 일경우 '대상노드'부터 다시 탐색한다.
    }
}













