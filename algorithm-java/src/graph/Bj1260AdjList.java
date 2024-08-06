package graph;

import java.util.*;

public class Bj1260AdjList {
    static int N, M, V;
    // 인접 리스트
    static LinkedList<Integer>[] adj;
    // 방문 체크
    static boolean[] visited;
    // DFS 탐색 시 재귀 함수에서 방문처리 해야해서 스트링 이어붙일 때 메소드 밖에 있어야 편할 수 있음.
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        // LinkedList가 모든 정점마다 각각 가지도록!!
        adj = new LinkedList[N + 1];

        // 모든 정점들에 대한 초기화 -> 일단 비어있는 리스트 객체를 하나씩 가지도록
        for (int i = 1; i <= N; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        // 모든 정점들이 자기 친구 찾을 때 숫자 작은 친구부터 찾아야 하는데 입력순서는 보장되지 않음;;
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);   // 모든 애들이 자기 친구 정보를 오름차순 정렬해서 유지하도록!!
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

    public static void dfs(int now) {
        visited[now] = true;    // now 칸 방문했다!!
        sb.append(now + " ");

        for (int next : adj[now]) {
            if (!visited[next]){
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

            for (int next : adj[now]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
