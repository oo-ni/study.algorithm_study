package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentence = br.readLine().trim();

        if (sentence.isEmpty()) {
            // 아예 공백만 입력으로 주는 경우도 가정해야함
            System.out.println(0);
        } else {
            String[] words = sentence.split(" ");
            System.out.println(words.length);
        }
    }
}
