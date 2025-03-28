package greedy;

import java.util.Scanner;

public class Bj2798 {
    static int N, M;
    static int[] cards;
    static int maxSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        cards = new int[N];

        for (int i = 0; i < N; i++) {
            cards[i] = sc.nextInt();
        }

        System.out.println(comb());
    }

    static int comb() {
        maxSum = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int temp = cards[i] + cards[j] + cards[k];

                    if (M == temp) {
                        return temp;
                    }

                    if (maxSum < temp && temp < M) {
                        maxSum = temp;
                    }
                }
            }
        }
        return maxSum;
    }
}
