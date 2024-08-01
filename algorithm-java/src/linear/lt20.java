package linear;

import java.util.ArrayDeque;
import java.util.Deque;

class Lt20 {
    // 열림 괄호와 닫힘 괄호를 비교하는 로직을 잘 만들어야 함.
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            // 열림 괄호는 push
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                // 1. 스택이 비어있을 경우, 2. 열림과 닫힘 괄호가 다를 경우
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        // 스택 비어있으면 모두 올바르게 짝지어진 것 -> true
        return stack.isEmpty();
    }
}
