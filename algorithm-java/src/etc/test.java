package etc;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("이름 > ");
        String name = sc.next();
        System.out.print("나이 > ");
        int age = sc.nextInt();
        System.out.print("번호 > ");
        String phone = sc.next();sc.nextLine();
        System.out.print("주소 > ");
        String addr = sc.nextLine();

        System.out.println("==================================");
        System.out.println("이름\t나이\t번호\t\t주소");
        System.out.printf("%s\t%d\t%s\t\t%s",name,age,phone,addr);
    }
}
