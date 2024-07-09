package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.util.Scanner;

public class bj10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        String S = br.readLine();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            // 중복 숫자일 경우, 첫 순서만 리턴.
            if (arr[ch - 'a'] == -1) {
                arr[ch - 'a'] = i;
            }
        }

        for (int val : arr) {
            System.out.print(val + " ");
        }
    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int[] arr = new int[26];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = -1;
//        }
//
//        String S = sc.next();
//        for (int i = 0; i < S.length(); i++) {
//            char ch = S.charAt(i);
//
//            // 중복 숫자일 경우, 첫 순서만 리턴.
//            if (arr[ch - 'a'] == -1) {
//                arr[ch - 'a'] = i;
//            }
//        }
//
//        for (int val : arr) {
//            System.out.print(val + " ");
//        }
//    }
}
