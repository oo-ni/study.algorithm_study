package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Bj1041 {
    static long N;
    static int[] dice = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        // one : 주사위 6면 중 가장 작은 값
        int one = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            one = Math.min(one, dice[i]);
        }

        // two : 마주보는 두 면은 같이 못 나옴. 이 경우만 제외하자
        // 두 면의 인덱스 합이 5인 경우가 마주보는 경우
        int two = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i + j != 5 && i != j) {
                    two = Math.min(two, dice[i] + dice[j]);
                }
            }
        }

        // three : 마주보는 면은 총 3쌍. 각각의 쌍에서 작은 값들을 더하면 이웃한 세 면의 합의 최솟값
        // 마주보는 두 쌍의 인덱스 합은 5이므로 하나가 i 인덱스이면, 나머지 하나는 5-i번째 인덱스.
        int three = 0;
        for (int i = 0; i < 3; i++) {
            three += Math.min(dice[i], dice[5 - i]);
        }

        long count3 = 4;
        long count2 = 4 * (N - 1) + 4 * (N - 2);
        long count1 = 4 * (N - 2) * (N - 1) + (N - 2) * (N - 2);

        long total = count3 * three + count2 * two + count1 * one;

        // N이 1일 경우, 6면 중 제일 큰 면을 제외하고 다 더한 값
        if (N == 1) {
            int sum = Arrays.stream(dice).sum();
            int max = Arrays.stream(dice).max().getAsInt();
            System.out.println(sum - max);
            return;
        }

        System.out.println(total);
    }
}
