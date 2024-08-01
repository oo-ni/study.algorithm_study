package etc;
class PgDevCourse2 {

    public int solution(int k, int[] limits, int[][] sockets) {
        int n = limits.length;
        boolean[] visited = new boolean[n];
        multitab(k, limits, sockets, visited, 0);
        return temp;
    }

    private static int temp;                    // 전체 결과값 담을 static 변수 선언

    private static int multitab(int k, int[] limits, int[][] sockets, boolean[] visited, int t) {
        if (visited[t]) {
            return 0;
        }
        visited[t] = true;                      // 방문 체크

        int consumePower = 0;                                       // 소비 전력 계산
        for (int i = 0; i < sockets[t].length; i++) {
            int plug = sockets[t][i];
            if (plug == 0) {
                continue;
            } else if (plug == -1) {
                consumePower += k;
            } else {
                consumePower += multitab(k, limits, sockets, visited, plug - 1);      // 재귀 활용
            }
        }

        int allowPower = consumePower - limits[t];             // 허용 전력 계산
        if (allowPower > 0) {                                  // 허용 전력이 초과되었을 경우
            int unplug = (allowPower + k - 1) / k;             // 올림 계산
            temp += unplug;                                    // 뽑아야 할 전자제품 플러그 계산
            return consumePower - unplug * k;                  // 전체 전력 계산
        }

        return consumePower;
    }
}