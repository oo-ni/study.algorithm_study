package graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Bj2468 {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[] di = {0, 0, -1, 1};
    static int[] dj = {-1, 1, 0, 0};
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }   // end input

        ans = 0;
        while (true) {  // increase water level (물 높이 변수를 만들어서 그보다 높은 영역이 땅이라고 체크해도 됨! 나는 그냥 땅을 물에 잠긴만크 깎아버리고 남은 땅으로 갯수 체크할 예정)
            print(map);
            visit = new boolean[N][N];
            int cnt = 0;    // 현재 수위에서 안전영역의 갯수

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > 0 && !visit[i][j]) { // 오 물에 안잠긴 땅이네?! 처음 방문이다!
                        dfs(i, j);  // 이 땅 주변에 붙은 땅 탐색을 시작하자!
//                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            ans = Math.max(ans, cnt);

            boolean isGo = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
//                    map[i][j]--;    // 전체 map(땅)의 높이를 내리면서
                    map[i][j] = map[i][j] - 1 >= 0 ? map[i][j] - 1 : 0;
                    if (map[i][j] > 0) {
                        isGo = true;
                    }
                }
            }
            System.out.println(cnt);
            if (!isGo) break;   // while 탈출. 땅이 더 이상 없음.
        }
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.println(arr[i][j] == 0 ? "X " : "O ");
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }

    static class Point {
        int i, j;
        Point (int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void dfs(int nowi, int nowj) {
        visit[nowi][nowj] = true;

        for (int d = 0; d < 4; d++) {
            int nexti = nowi + di[d];
            int nextj = nowj + di[d];
            if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && map[nexti][nextj] > 0 && !visit[nexti][nextj]) {  // 배열 내부이고, 물에 안잠긴 땅이고, 미방문이면
                dfs(nexti, nextj);
                // 재귀가 헷갈릴 땐, 일단 나는 기다리고 있고 여러개 행동을 하고 싶을때, 저 행동 다 하고와, 다 하고왔으면 이 행동도 하자.
            }
        }
    }

    public static void bfs(int starti, int startj) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(starti, startj));
        visit[starti][startj] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nexti = now.i + di[d];
                int nextj = now.j + di[d];
                if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && map[nexti][nextj] > 0 && !visit[nexti][nextj]) {  // 배열 내부이고, 물에 안잠긴 땅이고, 미방문이면
                    queue.add(new Point(nexti, nextj));

                }
            }
        }
    }
}
