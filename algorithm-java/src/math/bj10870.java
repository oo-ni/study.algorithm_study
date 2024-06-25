package math;

import java.util.Scanner;

public class bj10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int[] fibonacci = new int[N +1];

        for (int i = 0; i < fibonacci.length; i++) {
            if (i == 0) fibonacci[0] = 0;
            else if (i == 1) fibonacci[1] = 1;
            else fibonacci[i] = fibonacci[i -1] + fibonacci[i -2];
        }

        System.out.println(fibonacci[N]);
    }
}

//public class bj10870 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//
//        System.out.println(fibonacci(N));
//    }
//
//    static int fibonacci(int N) {
//        if (N == 0) return 0;
//        if (N == 1) return 1;
//        return fibonacci(N -1) + fibonacci(N -2);
//    }
//}