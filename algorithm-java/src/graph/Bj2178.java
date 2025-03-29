package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Bj2178 {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        // 0과 1사이 공백이 없음. string으로 받아서 처리
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));

    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (maze[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }

                // 방문 처리
                visited[nx][ny] = true;
                // 거리 증가하며 이동 -> 큐에 다음 좌표 갱신
                maze[nx][ny] = maze[cx][cy] + 1;
                q.add(new int[]{nx, ny});
            }
        }

        return maze[N - 1][M - 1];
    }
}
