package etc;

import java.util.ArrayDeque;
import java.util.Deque;

class PgDevCourse9 {
    public int solution(String s) {
        int count = 0;
        int n = s.length();

        // 문자열을 회전
        for (int i = 0; i < n; i++) {
            if (isValid(s)) {
                count++;
            }
            s = s.substring(1) + s.charAt(0);
        }

        return count;
    }

    // 문자열을 검증
    private boolean isValid (String s){
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // 여는 괄호는 데크에 추카
            if (c == '(' || c == '{' || c == '[') {
                deque.push(c);
            } else {
                // 닫는 괄호는 데크에서 짝이 맞는지 확인 후 제거
                if (deque.isEmpty()) {
                    return false;
                }
                char top = deque.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
}
