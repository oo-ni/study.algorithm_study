package implmentation;

import java.io.*;

class Bj8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            String result = br.readLine();
            int score = 0;
            int countO = 0;

            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == 'O') {
                    countO++;
                    score += countO;
                } else {
                    countO = 0;
                }
            }
            bw.write(String.valueOf(score));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
