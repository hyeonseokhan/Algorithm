package algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Camping_Fail {
    /**
     * 등산가 김강산은 가족들과 함께 캠핑을 떠났다. 하지만, 캠핑장에는 다음과 같은 경고문이 쓰여 있었다.<br>
     * 캠핑장은 연속하는 20일 중 10일동안만 사용할 수 있습니다.<br>
     * 강산이는 이제 막 28일 휴가를 시작했다. 이번 휴가 기간 동안 강산이는 캠핑장을 며칠동안 사용할 수 있을까?<br>
     * 강산이는 조금 더 일반화해서 문제를 풀려고 한다.<br>
     * 캠핑장을 연속하는 P일 중, L일동안만 사용할 수 있다. 강산이는 이제 막 V일짜리 휴가를 시작했다. 강산이가 캠핑장을 최대 며칠동안 사용할 수 있을까? (1 < L < P < V)
     */
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
