package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Bj1074 {
    static int N, r, c;

    // Z 모양 탐색을 어떻게 구현할 것인가
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(zet(N, r, c));
    }

    static int zet(int N, int r, int c) {
        if (N == 0) {
            return 0;
        }

        int half = (int) Math.pow(2, N - 1);
        int size = half * half;

        // 2사분면
        if (r < half && c < half) {
            return zet(N - 1, r, c);
        }

        // 1사분면
        else if (r < half && c >= half) {
            return size + zet(N - 1, r, c - half);
        }

        // 3사분면
        else if (r >= half && c < half) {
            return size * 2 + zet(N - 1, r - half, c);
        }

        // 4사분면
        else {
            return size * 3 + zet(N - 1, r - half, c - half);
        }

    }
}
