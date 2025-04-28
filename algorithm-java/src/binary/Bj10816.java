package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이분 탐색
// 상한선 - 하한선으로
public class Bj10816 {
    static int N, M;
    static int[] cards;
    static int key;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬해주기!!
        Arrays.sort(cards);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            key = Integer.parseInt(st.nextToken());

            // upperBound와 lowerBound의 차이 값 = 중복된 key의 개수
            sb.append(upperBound(cards, key) - lowerBound(cards, key)).append(" ");
        }

        System.out.println(sb);
    }

    // key 이상 첫 위치
    static int lowerBound(int[] arr, int key) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            // key 값이 피벗보다 작거나 같으면 상계를 하향
            if (key <= arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // key 초과 첫 위치
    static int upperBound(int[] arr, int key) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            // key 값이 피벗보다 작으면 상계를 하향
            if (key < arr[mid]) {
                right = mid;
                // 중복 원소는 else에서 처리
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
