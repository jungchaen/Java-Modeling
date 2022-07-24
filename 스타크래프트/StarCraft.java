import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.InputMismatchException;

public class StarCraft {
    static Unit[] myUnit;
    static Unit[] enemyUnit;

    /* 유닛 무작위 생성 */
    public static Unit[] createUnit(int choiceBrood) {
        int randomNum = 0;

        if (choiceBrood == 0) { // Terran
            Unit[] randomUnit = new Unit[5];
            Unit[] terran = { new Grounder("Marine", 3, 10), new Grounder("Tank", 7, 15),
                    new HybridGrounder("Goliath", 5, 15), new Flyer("Wraith", 3, 10),
                    new Flyer("Valkyrie", 4, 12), new Flyer("BattleCruzer", 20, 30)
            };

            for (int i = 0; i < 5; i++) {
                randomNum = (int) (Math.random() * 6);
                randomUnit[i] = terran[randomNum];
                randomUnit[i].setBrood(Brood.Terran);
            }
            return randomUnit;

        } else if (choiceBrood == 1) { // Protos
            Unit[] randomUnit = new Unit[4];
            Unit[] protos = { new Grounder("Zealot", 5, 20), new HybridGrounder("Dragon", 3, 15),
                    new Grounder("HighTempler", 10, 2), new Flyer("Scout", 5, 10),
                    new Flyer("Corsair", 4, 12), new Flyer("Carrier", 25, 40) };

            for (int i = 0; i < 4; i++) {
                randomNum = (int) (Math.random() * 6);
                randomUnit[i] = protos[randomNum];
                randomUnit[i].setBrood(Brood.Protos);
            }
            return randomUnit;

        } else { // Zerg
            Unit[] randomUnit = new Unit[8];
            Unit[] zerg = { new Grounder("Zergling", 2, 2), new HybridGrounder("Hydralisk", 3,
                    7), new Grounder("Ultralisk", 5, 15), new Flyer("Mutalisk", 2, 8),
                    new Flyer("Guardian", 3, 6), new Flyer("Queen", 15, 20) };

            for (int i = 0; i < 8; i++) {
                randomNum = (int) (Math.random() * 6);
                randomUnit[i] = zerg[randomNum];
                randomUnit[i].setBrood(Brood.Zerg);
            }
            return randomUnit;
        }
    }

    /* 유닛 방어력 출력 */
    public static void printUnit(Unit[] myUnit, Unit[] enemyUnit) {
        System.out.println("\n적군: " + enemyUnit[0].getBrood());
        for (int i = 0; i < enemyUnit.length; i++) {
            System.out.print(i + ". ");
            System.out.print(enemyUnit[i].getName());
            System.out.println("(현재 방어력: " + enemyUnit[i].getHp() + ")");
        }

        System.out.println("\n아군: " + myUnit[0].getBrood());
        for (int i = 0; i < myUnit.length; i++) {
            System.out.print(i + ". ");
            System.out.print(myUnit[i].getName());
            System.out.println("(현재 방어력: " + myUnit[i].getHp() + ")");
        }
        System.out.println("--------------------------");
    }

    /* 특정 유닛 소멸 */
    public static Unit[] removeUnit(Unit[] removeUnit, Unit remove) {
        List<Unit> list = new ArrayList<>(Arrays.asList(removeUnit));
        list.remove(remove);
        return list.toArray(Unit[]::new);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("0. Terran");
        System.out.println("1. Protos");
        System.out.println("2. Zerg");
        System.out.print("종족을 선택하세요: ");
        try {
            int choiceBrood = Integer.parseInt(scanner.next());
            if (choiceBrood != 0 && choiceBrood != 1 && choiceBrood != 2) {
                throw new InputMismatchException();
            }

            int randomEnemy = (int) (Math.random() * 3);
            enemyUnit = createUnit(randomEnemy);

            if (choiceBrood == 0) {
                myUnit = createUnit(0);
                printUnit(myUnit, enemyUnit);
            } else if (choiceBrood == 1) {
                myUnit = createUnit(1);
                printUnit(myUnit, enemyUnit);
            } else {
                myUnit = createUnit(2);
                printUnit(myUnit, enemyUnit);
            }

            int attack = 0;
            int beAttacked = 0;
            while ((myUnit.length != 0) || (enemyUnit.length != 0)) {
                // 아군 -> 적군 공격
                System.out.println("");
                System.out.print("공격을 실행할 아군 유닛과 공격할 적군 유닛을 선택하세요: ");
                attack = Integer.parseInt(scanner.next());
                beAttacked = Integer.parseInt(scanner.next());

                if (!Attackable.attacked(myUnit[attack], enemyUnit[beAttacked])) {
                    System.out.println("해당 유닛을 공격할 수 없습니다.");
                    continue;
                } else {
                    Attackable.attacked(myUnit[attack], enemyUnit[beAttacked]);
                    if (enemyUnit[beAttacked].getHp() <= 0) {
                        enemyUnit = removeUnit(enemyUnit, enemyUnit[beAttacked]);
                        printUnit(myUnit, enemyUnit);
                    } else {
                        printUnit(myUnit, enemyUnit);
                    }
                }

                // 적군 -> 아군 공격
                attack = (int) (Math.random() * enemyUnit.length);
                beAttacked = (int) (Math.random() * myUnit.length);
                if (!Attackable.attacked(enemyUnit[attack], myUnit[beAttacked])) {
                    System.out.println("해당 유닛을 공격할 수 없습니다.");
                    continue;
                } else {
                    Attackable.attacked(enemyUnit[attack], myUnit[beAttacked]);
                    if (myUnit[beAttacked].getHp() <= 0) {
                        myUnit = removeUnit(myUnit, myUnit[beAttacked]);
                        printUnit(myUnit, enemyUnit);
                    } else {
                        printUnit(myUnit, enemyUnit);
                    }
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다.");
            e.printStackTrace();
        }
    }

}
