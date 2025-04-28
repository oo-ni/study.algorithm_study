package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연결된 그래프에서 모든 정점을 방문하기 위한 최소 간선의 수 = N - 1
class Bj9372 {
    static int T;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 비행기 정보는 입력만 받고 무시해도 됨
            for (int k = 0; k < M; k++) {
                st = new StringTokenizer(br.readLine());
            }

            System.out.println(N - 1);
        }
    }
}
