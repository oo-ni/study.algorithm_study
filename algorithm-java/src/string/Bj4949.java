package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
1. 문자열을 입력받는다. 종료조건 "."
2. 문자열이 균형잡힌지 판단
3. 맞으면 yes, 아니면 no
 */

class Bj4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (!(input = br.readLine()).equals(".")) {
            if (isBalanced(input)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                // 닫는 소괄호가 나왔을 때, 스택이 비어있거나 짝이 맞지 않으면 false
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();    // 짝이 맞는 '(' 제거
            } else if (ch == ']') {
                // 닫는 대괄호가 나왔을 때, 스택이 비어있거나 짝이 맞지 않으면 false
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();    // 짝이 맞는 '[' 제거
            }
        }

        // 모든 처리가 끝났을 때, 스택이 비어있어야 균형이 맞음. -> true
        return stack.isEmpty();
    }
}
