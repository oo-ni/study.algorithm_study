package graph;

import java.util.*;

public class Bj1916 {
    static int N, M;
    static List<Node>[] list;   // 인접 리스트
    static int[] dist;          // 최단거리 담는 배열
    static boolean[] visited;   // 노드 방문 확인

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        // 초기화
        list = new ArrayList[N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            list[start].add(new Node(end, cost));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        dijkstra(start);
        System.out.println(dist[end]);
    }

    public static void dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);

        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int cur = node.city;

            if (visited[cur]) continue;

            visited[cur] = true;
            for (Node next : list[cur]) {
                if (dist[next.city] > dist[cur] + next.cost) {
                    dist[next.city] = dist[cur] + next.cost;
                    queue.add(new Node(next.city, dist[next.city]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int city;
        int cost;

        public Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
