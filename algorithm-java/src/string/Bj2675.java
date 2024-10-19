package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Bj2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String text = st.nextToken();

            StringBuilder sb = new StringBuilder();

            if (text != null) {
                for (int j = 0; j < text.length(); j++) {
                    char ch = text.charAt(j);

                    for (int k = 0; k < n; k++) {
                        sb.append(ch);
                    }
                }

                System.out.println(sb.toString());
            }
        }
        br.close();

    }
}
