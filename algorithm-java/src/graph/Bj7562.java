package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Bj7562 {
    static int I;
    static boolean[][] visited;
    static int[] start;
    static int[] end;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            I = Integer.parseInt(br.readLine());

            start = new int[2];
            end = new int[2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            System.out.println(solution(I, start, end));
        }
    }

    public static int solution(int I, int[] start, int[] end) {
        return bfs(I, start, end);
    }

    private static int bfs(int I, int[] start, int[] end) {
        boolean[][] visited = new boolean[I][I];
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int moves = current[2];

            if (cx == end[0] && cy == end[1]) {
                return moves;
            }

            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < I && ny < I) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, moves + 1});
                    }
                }
            }
        }

        return -1;
    }

}
