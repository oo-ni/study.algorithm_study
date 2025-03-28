package math;

import java.util.HashSet;
import java.util.Scanner;

class Bj3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int[] num = new int[10];
//        int[] ans = new int[10];
//
//        for (int i = 0; i < 10; i++) {
//            num[i] = sc.nextInt();
//            ans[i] = num[i] % 42;
//        }
//
//        int temp = 0;
//
//        for (int i = 0; i < 42; i++) {
//            boolean check = false;
//            for (int j = 0; j < 10; j++) {
//                if (ans[j] == i) {
//                    check = true;
//                    break;
//                }
//            }
//            if (check) {
//                temp++;
//            }
//        }
//
//        System.out.println(temp);

        HashSet<Integer> nums = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            nums.add(sc.nextInt() % 42);
        }

        System.out.println(nums.size());
        sc.close();
    }
}
