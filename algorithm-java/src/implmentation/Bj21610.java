package implmentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Bj21610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int[][] move = new int[M][2];

        for (int i = 0; i < N; i++) {
            new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                move[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int[] dx = {};
    static int[] dy = {};

}
