package implmentation;

public class Pg250137 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];     // 시전 시간
        int x = bandage[1];     // 초당 회복량
        int y = bandage[2];     // 연속 회복

        int maxHealth = health;     // 최대 체력
        int successTime = 0;        // 연속 성공 시간
        int fightTime = attacks[attacks.length - 1][0];     // 총 싸움 시간

        int idx = 0;

        for (int i = 0; i <= fightTime; i++) {
            // 몬스터별 공격 시간과 현재 시간이 같으면
            if (attacks[idx][0] == i) {
                health -= attacks[idx][1];
                successTime = 0;
                idx++;
                if (health <= 0) {
                    return -1;
                }

            // 공격 시간이 아니라면?
            } else {
                health += x;
                successTime++;

                if (successTime == t) {
                    health += y;
                    successTime = 0;
                }

                health = Math.min(health, maxHealth);
            }
        }

        return health;
    }
}
