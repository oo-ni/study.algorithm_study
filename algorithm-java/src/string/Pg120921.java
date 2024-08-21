package string;

public class Pg120921 {
    public int solution(String A, String B) {
        int answer = 0;

        if (A.equals(B)) {
            return answer;
        }

        int len = A.length();

        for (int i = 1; i < len; i++) {
            // substring(startIndex, endIndex)
            // startIndex(포함)부터 endIndex(불포함)까지의 문자열 리턴. endIndex는 포함하지 않는게 중요!!
            A = A.substring(len - 1) + A.substring(0, len - 1);
            if (A.equals(B)) {
                return i;
            }
        }

        return -1;
    }
}
