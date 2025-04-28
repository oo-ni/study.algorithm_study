package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Bj11725 {
    static int N;
    static List<List<Integer>> tree = new ArrayList<>();
    // 부모 노드 배열
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 노드 번호 : 1 ~ N -> N + 1 크기의 배열로 설정
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        // 트리의 노드 초기화 (인덱스때문에 0도 할당은 해야함. 실제로는 1 ~ N까지 사용)
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        // N - 1개 만큼 입력 받기
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dfs(1);

        // 2번 노드부터 순서대로 N - 1개(N번 노드까지) 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int now) {
        visited[now] = true;

        for (int next : tree.get(now)) {
            if (!visited[next]) {
                parent[next] = now;
                dfs(next);
            }
        }
    }
}
