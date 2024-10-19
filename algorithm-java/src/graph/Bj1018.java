package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Bj1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int minRepaint = Integer.MAX_VALUE;

        // 가능한 모든 8x8 체스판을 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minRepaint = Math.min(minRepaint, repaintCount(board, i, j));
            }
        }

        System.out.println(minRepaint);
    }

    // 8x8에서 다시 칠해야 할 부분을 계산
    public static int repaintCount(char[][] board, int x, int y) {
        int repaintCount1 = 0;
        int repaintCount2 = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char expectedColor1 = ((i + j) % 2 == 0) ? 'W' : 'B';
                char expectedColor2 = ((i + j) % 2 == 0) ? 'B' : 'W';

                // 실제 색깔과 비교하여 칠해야 하는 칸을 카운트
                if (board[x + i][y + j] != expectedColor1) {
                    repaintCount1++;
                }
                if (board[x + i][y + j] != expectedColor2) {
                    repaintCount2++;
                }
            }
        }

        return Math.min(repaintCount1, repaintCount2);
    }
}
