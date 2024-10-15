package etc;

import java.util.LinkedList;
import java.util.Queue;

public class PgDevCourse4 {
    // 상, 하, 좌, 우
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();

        // 시작 위치, 목표 위치 찾기
        int startX = -1, startY = -1, goalX = -1, goalY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                }
                if (board[i].charAt(j) == 'G') {
                    goalX = i;
                    goalY = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n][m];

        // 시작점 추가
        queue.add(new int[] {startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moves = current[2];

            // 목표 지점에 도달했으면 이동 횟수를 리턴
            if (x == goalX && y == goalY) {
                return moves;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                // 부딪힐 때까지 계속 이동
                while (nx + dx[i] >= 0 && nx + dx[i] < n && ny + dy[i] >= 0 && ny + dy[i] < m
                        && board[nx + dx[i]].charAt(ny + dy[i]) != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }

                // 아직 방문하지 않은 위치라면 큐에 추가하고 방문 표시
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, moves + 1});
                }
            }
        }

        return -1;
    }
}
