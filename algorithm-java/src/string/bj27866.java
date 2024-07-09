package string;

import java.util.Scanner;

public class bj27866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int i = sc.nextInt();

        char ans = S.charAt(i - 1);

        System.out.println(ans);
    }
}
