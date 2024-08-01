package string;

import java.util.Scanner;

public class Bj2754 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String grade = sc.next();

        /*
        자바에서 문자열을 비교할 때는, ==이 아니라 equals()를 통해 비교해야 함.
        ==는 주소값을 비교, equals()는 값을 비교하는 것.
        String은 int, char같은 타입이 아니라 클래스. 클래스는 기본적으로 Call by Reference형태로 객체 생성 시 주소값이 부여됨.
        그렇기에 String 타입을 선언했을때는 같은 값을 부여하더라도 서로의 주소값이 다름.
         */
        if (grade.equals("A+")) {
            System.out.println(4.3);
        } else if (grade.equals("A0")) {
            System.out.println(4.0);
        } else if (grade.equals("A-")) {
            System.out.println(3.7);
        } else if (grade.equals("B+")) {
            System.out.println(3.3);
        } else if (grade.equals("B0")) {
            System.out.println(3.0);
        } else if (grade.equals("B-")) {
            System.out.println(2.7);
        } else if (grade.equals("C+")) {
            System.out.println(2.3);
        } else if (grade.equals("C0")) {
            System.out.println(2.0);
        } else if (grade.equals("C-")) {
            System.out.println(1.7);
        } else if (grade.equals("D+")) {
            System.out.println(1.3);
        } else if (grade.equals("D0")) {
            System.out.println(1.0);
        } else if (grade.equals("D-")) {
            System.out.println(0.7);
        } else {
            System.out.println(0.0);
        }
    }
}
