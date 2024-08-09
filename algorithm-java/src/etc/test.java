package etc;

class Test {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int x = -r2; x <= r2; x++) {
            for (int y = -r2; y <= r2; y++) {
                int points = x * x + y * y;
                if (points >= r1 * r1 && points <= r2 * r2) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
