package implmentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Bj1913 {
    static int N, M;
    static int[][] arr;

    // 1까지 감소 -> 아래, 오른쪽, 위, 왼쪽으로 탐색
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        int dir = 0;            // 이동 방향 인덱스
        int cx = 0, cy = 0;     // 현재 좌표
        int tx = 0, ty = 0;     // 타겟 좌표

        int num = N * N;

        while (num >= 1) {
            arr[cx][cy] = num;

            // 타겟 숫자면 좌표 저장
            if (num == M) {
                tx = cx + 1;
                ty = cy + 1;
            }

            // 다음 좌표 계산
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];

            // 다음 좌표가 범위 밖이거나 이미 방문한 경우 방향 전환
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] != 0) {
                dir = (dir + 1) % 4;    // 방향 전환 수식
                nx = cx + dx[dir];
                ny = cy + dy[dir];
            }

            cx = nx;
            cy = ny;
            num--;
        }

        // 배열 전체 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(tx + " " + ty);

        System.out.println(sb);
    }
}
