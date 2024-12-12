package etc;

import java.util.HashMap;
import java.util.Map;

class PgDevCourse8 {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scores = new HashMap<>();

        scores.put('R', 0);
        scores.put('T', 0);
        scores.put('C', 0);
        scores.put('F', 0);
        scores.put('J', 0);
        scores.put('M', 0);
        scores.put('A', 0);
        scores.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            char left = survey[i].charAt(0);
            char right = survey[i].charAt(1);
            if (choices[i] < 4) {
                scores.put(left, scores.get(left) + (4 - choices[i]));
            } else if (choices[i] > 4) {
                scores.put(right, scores.get(right) + (choices[i] - 4));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(scores.get('R') >= scores.get('T') ? 'R' : 'T');
        sb.append(scores.get('C') >= scores.get('F') ? 'C' : 'F');
        sb.append(scores.get('J') >= scores.get('M') ? 'J' : 'M');
        sb.append(scores.get('A') >= scores.get('N') ? 'A' : 'N');

        return sb.toString();
    }
}
