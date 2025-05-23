package tree;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최소 스패닝 트리
// 크루스칼로 풀이
// 1. 간선 오름차순 정렬
// 2. 배열에 최소 비용의 간선을 삽입
// 3. 사이클 여부 확인
class Bj1197 {
    static int V, E;
    static int[] parent;    // 사이클 검사용 부모 배열

    //
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(@NotNull Edge o) {
            return this.weight - o.weight;      // 가중치 오름차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());



        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
    }
}
