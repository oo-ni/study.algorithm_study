package linear;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class bj9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            Deque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;

            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        isValid = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                isValid = false;
            }

            if (isValid) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}