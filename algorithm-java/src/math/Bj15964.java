package math;

import java.util.Scanner;

public class Bj15964 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        sc.close();

        System.out.println((A + B) * (A - B));
    }
}
