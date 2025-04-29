package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Bj10026 {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        // StringTokenizer? 문자열로 받아서 분리? -> 문자열이 맞는듯
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 일반인 개수
        visited = new boolean[N][N];
        int normalCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {               // 방문 안한 구역이면
                    bfs(i, j, false);       // 적록색약 아니니까 false
                    normalCount++;
                }
            }
        }

        // 적록색약 개수
        visited = new boolean[N][N];
        int errorCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {               // 방문 안한 구역이면
                    bfs(i, j, true);       // 적록색약 이니까 true
                    errorCount++;
                }
            }
        }

        System.out.println(normalCount + " " + errorCount);
    }

    private static boolean isSameColorRG(char a, char b) {
        if (a == b) {
            return true;
        }
        // 적록색약일때 R == G
        if ((a == 'R' && b == 'G') || (a == 'G' && b == 'R')) {
            return true;
        }
        return false;
    }

    private static void bfs(int x, int y, boolean colorError) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        char color = map[x][y];

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {   // 범위 체크
                    if (!visited[nx][ny]) {                     // 방문 여부 체크
                        // 색깔 비교
                        if (colorError) {                       // 적록색약일때
                            if (isSameColorRG(color, map[nx][ny])) {
                                q.offer(new int[]{nx, ny});     // 같은 구역이면 큐에 등록
                                visited[nx][ny] = true;
                            }
                        } else {                                // 일반인일때
                            if (color == map[nx][ny]) {
                                q.offer(new int[]{nx, ny});     // 같은 색이면 큐에 등록
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }

    }

}
