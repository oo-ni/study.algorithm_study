package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bj1012 {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 입력
        int T = sc.nextInt();

        while (T-- > 0) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            // 초기화
            map = new int[N][M];
            visited = new boolean[N][M];
            count = 0;

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1;      // 배추가 심어진 위치를 1로 설정
            }

//            // dfs 호출
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    // 1. 배추가 심어졌고, 2. 방문하지 않은 곳이라면? -> dfs 수행 후 지렁이 수 추가.
//                    if (map[i][j] == 1 && !visited[i][j]) {
//                        dfs(i, j);
//                        count++;
//                    }
//                }
//            }

            // bfs 호출
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 1. 배추가 심어졌고, 2. 방문하지 않은 곳이라면? -> dfs 수행 후 지렁이 수 추가.
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
        sc.close();
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        // 큐 초기화
        queue.add(new int[]{x, y});
        // 방문 갱신
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            // 현재 노드 좌표 하나씩 꺼내
            int[] now = queue.poll();
            int px = now[0];
            int py = now[1];

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                // 밭의 범위 내에서 방문여부 확인, 1인 값이 방문 배열에 없으면 방문 배열 업데이트
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    static void dfs(int x, int y) {
        // 방문 갱신
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            // 상하좌우 탐색
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 밭의 범위 내에서 방문여부 확인, 1인 값이 방문 배열에 없으면, 재귀 수행.
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
