package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

// 이분 탐색
// 가능한 랜선길이 범위에서 탐색
class Bj1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());       // 가지고 있는 랜선 개수
        int N = Integer.parseInt(st.nextToken());       // 필요한 랜선 개수

        long[] cables = new long[K];                    // 랜선들

        for (int i = 0; i < K; i++) {
            cables[i] = Long.parseLong(br.readLine());
        }

        System.out.println(solution(K, N, cables));
    }

    // 2^31 - 1 보다 작은 자연수 -> long 배열로 받기
    public static long solution(int K, int N, long[] cables) {
        long answer = 0;
        long max = 0;

        for (int i = 0; i < K; i++) {
            max = Math.max(max, cables[i]);     // 가장 긴 랜선 기준으로
        }

        long mid = 0;
        long min = 1;

        while (min <= max) {
            mid = (min + max) / 2;      // 중간값 구하기
            answer = 0;

            for (int i = 0; i < cables.length; i++) {
                answer += (cables[i] / mid);        // 랜선을 중간값으로 자르면 몇개가 나오지?
            }

            // answer이 N보다 작으면? 중간값을 줄여야지 -> max를 줄임
            // answer이 N보다 크면? 중간값을 늘려야지 -> min을 늘림

            if (answer < N) {
                max = mid - 1;
            } else {
                min = mid + 1;      // min 늘려야하니까 +1씩
            }

        }

        return max;
    }

}
