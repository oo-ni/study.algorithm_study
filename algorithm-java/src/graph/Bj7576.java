package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Bj7576 {
    static int M, N;
    static int[][] tomato;
    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 익은 토마토 넣는 큐
    static Deque<int[]> queue = new ArrayDeque<>();

    // 1 : 익음, 0, : 익지 않음, -1 : 토마토가 X
    // 익은 토마토(1) 기준으로 0을 1로 바꿔나가야함
    // 탐색 끝나고 0이 하나라도 있으면 -1 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // N행 M열
        tomato = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {                // 이미 익은 토마토(1)의 좌표를 먼저 큐에 등록
                    queue.offer(new int[]{i, j});
                }
            }
        }

        bfs();

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                count = Math.max(count, tomato[i][j]);      // 최대 값이 결국 전체가 익을 때까지 걸린 시간
            }
        }

        System.out.println(count - 1);  // 처음 익은 토마토는 1부터 시작했으니까 0으로 카운트
    }

    private static void bfs() {
         while (!queue.isEmpty()) {
            int[] current = queue.poll();   // 익은 토마토의 좌표부터 시작
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {   // 범위 체크
                    if (tomato[nx][ny] == 0) {
                        tomato[nx][ny] = tomato[cx][cy] + 1;    // 익은 날짜 -> +1
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

    }
}
