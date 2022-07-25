import java.util.Scanner;
import java.util.InputMismatchException;

public class StarCraft {
    static Unit[] myUnit; // 내 유닛을 담을 배열
    static Unit[] enemyUnit; // 적의 유닛을 담을 배열

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("0. Terran");
        System.out.println("1. Protos");
        System.out.println("2. Zerg");
        System.out.print("종족을 선택하세요: ");
        try {
            int selectBrood = Integer.parseInt(scanner.next());
            if (selectBrood != 0 && selectBrood != 1 && selectBrood != 2) {
                throw new InputMismatchException();
            }

            /* 적 팀의 유닛 생성 */
            int randomEnemy = (int) (Math.random() * 3);
            enemyUnit = CreateUnit.createUnit(randomEnemy);

            /* 내 팀의 유닛 생성 */
            if (selectBrood == 0) { // Terran
                myUnit = CreateUnit.createUnit(0);
                PrintUnit.printUnit(myUnit, enemyUnit);
            } else if (selectBrood == 1) { // Protos
                myUnit = CreateUnit.createUnit(1);
                PrintUnit.printUnit(myUnit, enemyUnit);
            } else { // Zerg
                myUnit = CreateUnit.createUnit(2);
                PrintUnit.printUnit(myUnit, enemyUnit);
            }

            int attackNumber = 0;
            int beAttackedNumber = 0;
            while ((myUnit.length != 0) || (enemyUnit.length != 0)) {
                // 아군 -> 적군 공격
                System.out.print("\n공격을 실행할 아군 유닛과 공격할 적군 유닛을 선택하세요: ");
                attackNumber = Integer.parseInt(scanner.next());
                beAttackedNumber = Integer.parseInt(scanner.next());

                Attacking.turnAttack(myUnit, enemyUnit, attackNumber, beAttackedNumber);
                PrintUnit.printUnit(myUnit, enemyUnit);

                // 적군 -> 아군 공격
                attackNumber = (int) (Math.random() * enemyUnit.length);
                beAttackedNumber = (int) (Math.random() * myUnit.length);
                System.out.print("컴퓨터 차례입니다. ");

                Attacking.turnAttack(enemyUnit, myUnit, attackNumber, beAttackedNumber);
                PrintUnit.printUnit(myUnit, enemyUnit);
            }

        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다.");
            e.printStackTrace();
        }
    }
}
