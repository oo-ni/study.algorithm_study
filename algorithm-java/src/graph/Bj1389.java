package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 친구가 한 명도 없는 사람 X
// 양방향 관계 A -> B, B -> A는 하나의 관계
// 시작 지점 X, 모두 방문 O -> 플로이드 워셜
// 번호는 1부터 N까지

class Bj1389 {
    static int N, M;    // 유저의 수, 관계의 수
    static int[][] hi;
    static final int INF = 123456789;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 초기 테이블 초기화 (인덱스 1 ~ N)
        hi = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    hi[i][j] = 0;   // 자신과의 관계는 가중치 0
                } else {
                    hi[i][j] = INF;
                }
            }
        }

        // 관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 양방향 관계
            hi[A][B] = 1;
            hi[B][A] = 1;
        }

        // 플로이드 워셜
        for (int k = 1; k <= N; k++) {              // 경유 노드
            for (int i = 1; i <= N; i++) {          // 출발 노드
                for (int j = 1; j <= N; j++) {      // 도착 노드
                    hi[i][j] = Math.min(hi[i][j], hi[i][k] + hi[k][j]);     // 비교해서 더 짧은 경로로 갱신
                }
            }
        }

        int answer = 0;
        int value = INF;

        // 케빈 베이컨 수 계산
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += hi[i][j];
            }

            // 최솟값 갱신
            if (sum < value) {
                value = sum;
                answer = i;
            }
        }

        System.out.println(answer);
    }
}
