package math;

import java.io.*;
import java.util.StringTokenizer;

/*
1. 전체 점수 입력받기
2. 최댓값 찾기
3. 모든 점수 재계산 후 평균내기
 */

class Bj1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double[] score = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            score[i] = Double.parseDouble(st.nextToken());
        }

        // 최댓값 찾기
        double M = 0;
        for (int i = 0; i < N; i++) {
            if (score[i] > M) {
                M = score[i];
            }
        }

        // 모든 점수 재계산
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += score[i] / M * 100;
        }

        double avg = sum / N;

        System.out.printf(String.valueOf(avg));

        br.close();

    }
}
