package linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Bj10773 {
    static int K;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            // 문제에서 앞선 숫자 보장해준다고 해서 isEmpty()는 굳이 안써도 되긴 함
            if (!stack.isEmpty() && num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }

        }

        // 순회하면서 합산
        for (int n : stack) {
            answer += n;
        }

        System.out.println(answer);
    }
}
