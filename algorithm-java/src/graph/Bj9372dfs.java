package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 비행기를 가장 적게 타고 모든 국가를 순회 -> 그래프 순회하면서 visited count
class Bj9372dfs {
    static int T;
    static int N, M;
    static int a, b;

    static List<Integer>[] graph;
    static boolean[] visited;
    static int count;       // 비행기 수 = 방문한 국가 수 - 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 인덱스 1부터 시작하니까 1부터 N + 1까지 초기화
            graph = new ArrayList[N + 1];
            visited = new boolean[N + 1];

            for (int j = 1; j <= N; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int k = 0; k < M; k++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                // 양방향
                graph[a].add(b);
                graph[b].add(a);
            }

            count = 0;
            // 1번 인덱스부터
            dfs(1);

            System.out.println(count);
        }
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int next : graph[node]) {
            // 방문 안한 나라 기준
            if (!visited[next]) {
                count++;    // 방문할때마다 비행기 한 번 탄거
                dfs(next);
            }
        }
    }
}
