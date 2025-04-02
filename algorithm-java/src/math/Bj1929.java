package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Bj1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[N + 1];

        // 초기화 - 0, 1은 소수 X. 지우기
        isPrime[0] = true;
        isPrime[1] = true;

        // i의 배수를 모두 판별함
        for (int i = 2; i * i <= N; i++) {
            // 아직 안지워진 수에 대해
            if (!isPrime[i]) {
                // i의 배수라면 모두 지우기
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!isPrime[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);

    }
}
