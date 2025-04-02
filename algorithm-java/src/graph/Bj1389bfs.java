package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Bj1389bfs {
    static int N, M;    // 유저의 수, 관계의 수
    static List<Integer>[] hi;
    static boolean[] visited;
    static final int INF = 123456789;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 그래프 초기화 (인덱스 1 ~ N)
        hi = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            hi[i] = new ArrayList<>();
        }

        // 관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 양방향 관계
            hi[A].add(B);
            hi[B].add(A);
        }

        int answer = 0;
        int value = INF;

        // 케빈 베이컨 수 계산
        for (int i = 1; i <= N; i++) {
            int sum = bfs(i);

            // 최솟값 갱신
            if (sum < value) {
                value = sum;
                answer = i;
            }
        }

        System.out.println(answer);

    }

    static int bfs(int start) {
        // 방문 배열도 초기화 (인덱스 1 ~ N)
        visited = new boolean[N + 1];
        Deque<int[]> q = new ArrayDeque<>();

        // 시작 노드는 자기 자신, 거리 0
        q.offer(new int[]{start, 0});
        visited[start] = true;

        // 거리 누적 합 (케빈 베이컨 수)
        int total = 0;

        while (!q.isEmpty()) {
            // 현재 노드 꺼내주고
            int[] cur = q.poll();
            int now = cur[0];

            // 현재 노드까지 거리 계산
            int dist = cur[1];

            total += dist;

            for (int next : hi[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, dist + 1});
                }
            }
        }

        return total;
    }
}
