import java.util.Scanner;

public class Main {
    static int max(int a, int b, int c) {
        int temp = Integer.max(a, b);
        return Integer.max(temp, c);
    }

    static int compare(int a, int b, int c) {
        int s = 0;
        if ((a == b) && (b == c)) {
            s += a * 1000 + 10000;
        } else if ((a == c) && (b != c)) {
            s += a * 100 + 1000;
        } else if ((a == b) && (b != c)) {
            s += a * 100 + 1000;
        } else if ((b == c) && (a != c)) {
            s += b * 100 + 1000;
        } else {
            int r = max(a, b, c);
            s += r * 100;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(compare(a, b, c));

        scanner.close();
    }
}
