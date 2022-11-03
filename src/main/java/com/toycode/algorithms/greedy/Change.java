package com.toycode.algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Change {
    /**
     * 당신은 음식점의 계산을 도와주는 점원이다.<br>
     * 카운터에는 거스름돈으로 사용할 500원, 100원, 50원, 10원짜리의 동전이 무한히 존재한다고 가정한다.<br>
     * 손님에게 거슬러줘야 할 돈이 N원일 때 거슬러 줘야 할 동전의 최소 개수를 구하라.<br>
     * 단, 거슬러 줘야 할 돈 N은 항상 10의 배수이다.
     */
    public static void main(String[] args) throws IOException {

        // 예상 시나리오.
        // 지불: 5,000원 -> 잔돈(N): 300원 (10의 배수)
        // 최적해: 6개 (500원)

        // 01. 시스템 입력 값(N, 잔돈)
        // 02. N / 10 > 0 return false
        // 03. 500, 100, 50, 10 동전의 최적해를 구하는 알고리즘 구현.
        // 03-1. 동전을 오름차순으로 정렬하여 가장 큰 동전을 기준으로 몫을 구한다. (N / 500)
        // 03-2. 몫의 나머지를 다음 동전의 몫을 구하는 것을 반복하여 나머지가 0일 값을 구한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int change = Integer.parseInt(br.readLine());
        if (change % 10 > 0) {
            System.out.printf("잔돈이 10의 배수가 아닙니다. [%s]%n", change);
            return;
        }
        int[] coins = { 500, 100, 50, 10 };
        int result = 0;
        for (int coin : coins) {
            result += change / coin;
            change = change % coin;
            if (change == 0)
                break;
        }
        System.out.printf("최소 코인 개수: %s%n", result);
    }
}
