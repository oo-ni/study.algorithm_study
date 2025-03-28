package math;

class Pg120808 {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {

        int lcm = lcm(denom1, denom2);
        int numer = (numer1 * (lcm / denom1)) + (numer2 * (lcm / denom2));
        int denom = lcm;

        int gcd = gcd(numer, denom);
        numer = numer/gcd;
        denom = denom/gcd;

        return new int[] {numer, denom};
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
