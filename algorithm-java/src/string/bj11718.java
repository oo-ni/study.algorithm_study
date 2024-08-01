package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//// hasNextLine() -> 다음 줄에 입력값이 있는지를 체크한다.
//public class bj11718 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String S = sc.nextLine();
//            System.out.println(S);
//        }
//        sc.close();
//    }
//}

public class Bj11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String S = br.readLine();
            if (S == null || S.isEmpty()) {
                break;
            }
            sb.append(S).append("\n");
        }
        br.close();

        System.out.println(sb);
    }
}