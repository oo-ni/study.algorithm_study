package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이분 탐색
// 가능한 랜선길이 범위에서 탐색
class Bj1654 {
    static int K, N;
    static long[] cables;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        cables = new long[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            cables[i] = Long.parseLong(br.readLine());
            max = Math.max(max, cables[i]);
        }

        // upper bound를 수행하기 위해 최대 길이 + 1로 잡고 이분 탐색을 수행
        max++;

        long min = 0;
        long mid = 0;

        answer = 0;

        while (min < max) {
            // 중간 값 구하기
            mid = (min + max) / 2;
            answer = 0;

            // 중간 길이로 잘라서 몇개가 만들어지는지 구함
            for (int i = 0; i < cables.length; i++) {
                answer += (cables[i] / mid);
            }

            /*
            [upper bound 형식]

            mid 길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보자 작으면?
            자르려고 하는 길이를 줄여야함 -> 최대 길이를 줄임

            그 외에는 자르려고 하는 길이를 늘려야함 -> 최소 길이를 늘림
             */
            if (answer < N) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }

        System.out.println(min - 1);
    }
}
