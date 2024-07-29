package greedy;

import java.util.Scanner;

public class Bj2798 {
    static int N, M;
    static int[] cards;
    static int maxSum;
    static int[] result = new int[3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        cards = new int[N];

        for (int i = 0; i < N; i++) {
            cards[i] = sc.nextInt();
        }

        maxSum = 0;
        comb(0,0);

        System.out.println(maxSum);
    }

    static void comb(int cnt, int start) {
        if (cnt == 3) {
            int sum = result[0] + result[1] + result[2];
            if (sum <= M && sum > maxSum) {
                maxSum = sum;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            result[cnt] = cards[i];
            comb(cnt + 1, i + 1);
        }
    }
}
