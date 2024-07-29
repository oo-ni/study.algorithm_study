package greedy;

import java.util.Scanner;

public class Bj2961 {
    static int N;
    static int[][] sb;
    static int minDiff;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sb = new int[N][2];     // N행 2열짜리

        for (int i = 0; i < N; i++) {
            sb[i][0] = sc.nextInt();    // sour
            sb[i][1] = sc.nextInt();    // bitter
        }

        comb(0, 1,0,0);

        System.out.println(minDiff);
    }

    static void comb(int idx, int s, int b, int cnt) {
        if (idx == N) {
            if (cnt > 0) {
                int diff = Math.abs(s - b);
                if (diff < minDiff) {
                    minDiff = diff;
                }
            }
        return;
        }

        // 현재 재료를 선택하는 경우
        comb(idx + 1, s * sb[idx][0], b + sb[idx][1], cnt + 1);

        // 현재 재료를 선택하지 않는 경우
        comb(idx + 1, s, b, cnt);
    }
}
