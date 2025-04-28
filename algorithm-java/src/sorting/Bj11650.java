package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Bj11650 {
    static int N;
    static int[][] coor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());

        coor = new int[N][2];
        for (int i = 0; i < N; i++) {
            coor[i][0] = Integer.parseInt(st.nextToken());
            coor[i][1] = Integer.parseInt(st.nextToken());
        }

        int temp = 0;
        for (int i = 0; i < N; i++) {
            if (coor[i][0] == coor[i + 1][0]) {
                if (coor[i][1] > coor[i + 1][1]) {
                    temp = coor[i][1];
                    coor[i][1] = coor[i + 1][1];
                    coor[i + 1][1] = temp;
                }
            }
        }
    }
}
