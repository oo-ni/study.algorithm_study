package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BJ11729 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        sb.append((1 << N) - 1 + "\n");

        hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }

    static void hanoi(int N, int start, int mid, int end) {
        if (N == 1) {
            sb.append(start + " " + end + "\n");
            return;
        }

        hanoi(N - 1, start, end, mid);      // n-1개를 mid로 옮김
        sb.append(start + " " + end + "\n");
        hanoi(N - 1, mid, start, end);
    }
}
