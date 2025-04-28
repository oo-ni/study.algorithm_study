package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Bj2468 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    // 위, 아래, 오른쪽, 왼쪽
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int safeArea;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);     // 최고 높이 갱신
            }
        }

        safeArea = 0;
        // 0(비가 안옴) 부터, 최고 높이까지 빗물 채우면서 시뮬레이션 -> 물에 안잠긴 땅 찾기
        for (int rain = 0; rain <= maxHeight; rain++) {
            visited = new boolean[N][N];
            int cntArea = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 방문한적 없고, 빗물보다 높아서 물에 안잠겼다면? -> 탐색 시작
                    if (!visited[i][j] && map[i][j] > rain) {
                        bfs(rain, i, j);
                        cntArea++;
                    }
                }
            }
            // 빗물 높이별로 최대 safeArea 개수 갱신
            safeArea = Math.max(safeArea, cntArea);
        }

        System.out.println(safeArea);
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

//    static void dfs(int height, int x, int y) {
//        visited[x][y] = true;
//
//        // 시작점(x, y)부터 4방향 탐색
//        for (int i = 0; i < 4; i++) {
//            int nx = x + dx[i];     // nx = nextX
//            int ny = y + dy[i];
//
//            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {   // 그래프 범위 내에서
//                if (!visited[nx][ny]) {                     // 방문하지 않은 영역이고
//                    if (map[nx][ny] > height) {             // 그 영역이 물에 잠기지 않았다면
//                        dfs(height, nx, ny);                // 재귀적으로 탐색 수행
//                    }
//                }
//            }
//        }
//    }

    static void bfs(int height, int x, int y) {
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y));            // 시작 좌표 큐에 추가하고 방문처리
        visited[x][y] = true;

        while (!queue.isEmpty()) {              // 연결된 안전지역 다 순회할 때까지
            Point current = queue.poll();       // 큐에서 현재 위치 꺼내서 cx, cy 저장
            int cx = current.x;
            int cy = current.y;

            // 현재 위치(cx, cy)부터 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {   // 그래프 범위 내에서
                    if (!visited[nx][ny]) {                     // 방문하지 않은 영역이고
                        if (map[nx][ny] > height) {             // 그 영역이 물에 잠기지 않았다면
                            visited[nx][ny] = true;             // 방문 표시하고, 다음에 탐색할 후보로 추가
                            queue.add(new Point(nx, ny));
                        }
                    }
                }
            }
        }
    }
}
