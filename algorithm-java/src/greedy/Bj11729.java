package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Bj11729 {
    static class Move {
        int N, start, mid, end;

        Move(int N, int start, int mid, int end) {
            this.N = N;
            this.start = start;
            this.mid = mid;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append((int) (Math.pow(2, N) - 1)).append("\n");

        Deque<Move> stack = new ArrayDeque<>();
        stack.push(new Move(N, 1, 2, 3));

        while (!stack.isEmpty()) {
            Move m = stack.pop();

            if (m.N == 1) {
                sb.append(m.start).append(" ").append(m.end).append("\n");
                continue;
            }

            stack.push(new Move(m.N - 1, m.mid, m.start, m.end));   // 제일 마지막으로 이동
            stack.push(new Move(1, m.start, m.mid, m.end));         // 중간으로 이동
            stack.push(new Move(m.N - 1, m.end, m.start, m.mid));   // 처음으로 이동

        }
        System.out.println(sb);

    }
}
// 재귀
//    static StringBuilder sb = new StringBuilder();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//        sb.append((int) (Math.pow(2, N) - 1)).append("\n");
//
//        hanoi(N, 1, 2, 3);
//        System.out.println(sb);
//    }
//
//    static void hanoi(int N, int start, int mid, int end) {
//        if (N == 1) {
//            sb.append(start).append(" ").append(end).append("\n");
//            return;
//        }
//
//        hanoi(N - 1, start, end, mid);      // n-1개를 mid로 옮김
//        sb.append(start).append(" ").append(end).append("\n");    // 가장 큰 원반을 목적지로
//        hanoi(N - 1, mid, start, end);      // 다시 n-1개를 목적지로
//    }
//}
