package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// LIS 문제
class Bj1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] box = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        int maxBox = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                // 이전 인덱스 모든 상자와 비교, 최댓값 저장
                if (box[j] < box[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // 최대값 갱신
            maxBox = Math.max(maxBox, dp[i]);
        }

        System.out.println(maxBox);
    }
}
