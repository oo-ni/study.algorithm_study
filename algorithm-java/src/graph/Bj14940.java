package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Bj14940 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] distance;
    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        distance = new int[N][M];

        int[] goal = new int[2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }

        bfs(goal[0], goal[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    sb.append(0).append(' ');
                } else if (!visited[i][j]) {
                    sb.append(-1).append(' ');
                } else {
                    sb.append(distance[i][j]).append(' ');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;
        distance[x][y] = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny]) {
                        if (map[nx][ny] != 0) {
                            q.offer(new int[] {nx, ny});
                            visited[nx][ny] = true;
                            distance[nx][ny] = distance[cx][cy] + 1;
                        }
                    }
                }
            }
        }
    }
}
