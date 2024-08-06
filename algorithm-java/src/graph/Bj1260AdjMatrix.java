package graph;

import java.util.*;

public class Bj1260AdjMatrix {
    static int N, M, V;
    // 인접 행렬
    static boolean[][] adj;
    // 방문 체크
    static boolean[] visited;
    // DFS 탐색 시 재귀 함수에서 방문처리 해야해서 스트링 이어붙일 때 메소드 밖에 있어야 편할 수 있음.
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        // 인접 행렬 초기화 (정점이 1부터 시작하니까 + 1)
        adj = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adj[v1][v2] = true;
            adj[v2][v1] = true;
        }

        // 1~N번까지의 정점이 방문했는지 아닌지
        visited = new boolean[N + 1];
        sb = new StringBuilder();
        dfs(V);
        System.out.println(sb.toString());

        // BFS 탐색 출발을 위해 리셋!
        visited = new boolean[N + 1];
        sb = new StringBuilder();
        bfs(V);
        System.out.println(sb.toString());
    }

    // 재귀함수는 최대한 flat하게 만들어라.
    public static void dfs(int now) {
        visited[now] = true;    // now 칸 방문했다!!
        sb.append(now + " ");    // 결과에 보여줄 방문처리 스트링 만들고!!

        for (int next = 1; next <= N; next++) {
            if (adj[now][next] && !visited[next]) {  // 현재 정점에서 인접한 다른 정점이 있어? 그럼 일단 여기서 난 기다려!!
                dfs(next);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);       // queue가 곧 방문 스케줄
        visited[start] = true;  // BFS는 일단 스케줄 순서대로 무조건 방문하니까, 스케줄 잡은 정점은 이미 큐에 먼저 들어갔다고 표시하기

        while (!queue.isEmpty()) {
            int now = queue.poll(); // 현재 방문처리하는 정점
            sb.append(now + " ");

            for (int next = 1; next <= N; next++) {
                if (adj[now][next] && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
