import java.util.Scanner;

public class RationalNumber {
    int x, y;
    String[] num;

    RationalNumber(String s) {
        num = s.split("/");
        if (num[1].equals("0")) { // 분모가 0일 때
            System.out.println("0이상의 분모를 입력하세요.");
        } else {
            x = Integer.parseInt(num[0]);
            y = Integer.parseInt(num[1]);
        }
    }

    /* 더하기 */
    String add(RationalNumber r) {
        int denominator = gcd(y, r.y);
        denominator = (y * r.y) / denominator;
        int x1 = denominator / y;
        int x2 = denominator / r.y;

        int temp = x * x1 + x2 * r.x;
        int[] fraction = reduceFraction(temp, denominator); // 약분한 분수

        if (fraction[0] == fraction[1]) { // 분모, 분자가 같을 때
            return "1";
        } else if (fraction[1] == 1) { // 분모가 1일 때
            return Integer.toString(fraction[0]);
        } else {
            return fraction[0] + "/" + fraction[1];
        }
    }

    /* 빼기 */
    String subtract(RationalNumber r) {
        int denominator = gcd(y, r.y);
        denominator = (y * r.y) / denominator;
        int x1 = denominator / y;
        int x2 = denominator / r.y;

        int temp = x * x1 - x2 * r.x;

        int[] fraction = reduceFraction(temp, denominator); // 약분한 분수

        if (fraction[0] == 0) { // 분모가 0일 때
            return "0";
        } else if (fraction[0] == fraction[1]) { // 분모, 분자가 같을 때
            return "1";
        } else {
            return fraction[0] + "/" + fraction[1];
        }
    }

    /* 곱하기 */
    String muliply(RationalNumber r) {
        int up = x * r.x;
        int down = y * r.y;

        int[] fraction = reduceFraction(up, down); // 약분

        if (fraction[0] == fraction[1]) { // 분모, 분자가 같을 때
            return "1";
        } else if (fraction[1] < 0) {
            fraction[1] *= -1;
            return "-" + fraction[0] + "/" + fraction[1];
        } else {
            return fraction[0] + "/" + fraction[1];
        }

    }

    /* 나누기 */
    String divide(RationalNumber r) {
        int up = x * r.y;
        int down = y * r.x;

        int[] fraction = reduceFraction(up, down); // 약분
        if (fraction[0] == fraction[1]) { // 분모, 분자가 같을 때
            return "1";
        } else {
            return fraction[0] + "/" + fraction[1];
        }

    }

    public int gcd(int a, int b) { // 최대공약수
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public int[] reduceFraction(int up, int down) { // 약분
        int[] frac = new int[2];
        frac[0] = up;
        frac[1] = down;

        int gcdResult = gcd(frac[0], frac[1]);
        frac[0] = frac[0] / gcdResult;
        frac[1] = frac[1] / gcdResult;

        return frac;
    }
}

class RationalNumberTest {
    public static void main(String[] args) {
        String s1 = "", s2 = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("첫번째 분수를 입력하세요. (ex : 1/2) : ");
        s1 = scanner.next();
        System.out.print("두번째 분수를 입력하세요. (ex : 1/2) : ");
        s2 = scanner.next();

        RationalNumber r1 = new RationalNumber(s1);
        RationalNumber r2 = new RationalNumber(s2);

        System.out.println("(" + s1 + ") + (" + s2 + ") = " + r1.add(r2));
        System.out.println("(" + s1 + ") - (" + s2 + ") = " + r1.subtract(r2));
        System.out.println("(" + s1 + ") * (" + s2 + ") = " + r1.muliply(r2));
        System.out.println("(" + s1 + ") / (" + s2 + ") = " + r1.divide(r2));
    }
}
