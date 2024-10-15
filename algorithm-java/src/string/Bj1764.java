package string;

import java.io.*;
import java.util.*;

class Bj1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> dj = new HashSet<>();
        for (int i = 0; i < N; i++) {
            dj.add(br.readLine());
        }

        List<String> dbj = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (dj.contains(name)) {
                dbj.add(name);
            }
        }

        Collections.sort(dbj);

        bw.write(dbj.size() + "\n");

        for (String name : dbj) {
            bw.write(name + "\n");
        }

        bw.flush();
        br.close();
        bw.close();

    }
}
