package linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Bj11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deq.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!deq.isEmpty()) {
            // K번 숫자가 가장 왼쪽으로 올때까지 숫자 뒤로 옮기기
            for (int i = 0; i < K - 1; i++) {
                deq.offer(deq.poll());
            }

            // 데크에서 제거하고 sb에 추가
            sb.append(deq.poll());

            // 데크가 비기 전까지, 붙여서 sb에 추가
            if (!deq.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}