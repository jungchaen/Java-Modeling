import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String b = scanner.next();

        int n3 = a * (b.charAt(2) - '0');
        int n4 = a * (b.charAt(1) - '0');
        int n5 = a * (b.charAt(0) - '0');
        int n6 = n3 + n4 * 10 + n5 * 100;

        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);
        System.out.println(n6);
    }
}
