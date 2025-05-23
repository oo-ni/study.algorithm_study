package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Bj11651 {
    static int N;
    static int[][] coor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        coor = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coor[i][0] = Integer.parseInt(st.nextToken());      // 간선
            coor[i][1] = Integer.parseInt(st.nextToken());
        }

        // y 오름차순 -> y가 같으면 x 오름차순
        Arrays.sort(coor, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        StringBuilder sb = new StringBuilder();
        for (int[] c : coor) {
            sb.append(c[0]).append(" ").append(c[1]).append("\n");
        }

        System.out.println(sb);
    }
}