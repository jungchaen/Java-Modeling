import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Attacking { // 공격에 관한 타입
    public static Boolean attackingUnit(Unit attackUnit, Unit beAttackUnit) {
        beAttackUnit.setHp(beAttackUnit.getHp() - attackUnit.getDamage());
        if (beAttackUnit.getHp() <= 0) {
            System.out.println(beAttackUnit.getName() + "가 소멸되었습니다.");
            beAttackUnit = null;
            return true;
        } else {
            return false;
        }
    }

    public static Unit[] removeUnit(Unit[] removeUnit, int removeIndex) {
        List<Unit> list = new ArrayList<Unit>(Arrays.asList(removeUnit));
        list.remove(removeIndex);
        return list.toArray(Unit[]::new);
    }

    public static void turnAttack(Unit[] attackUnit, Unit[] beAttackedUnit, int attack, int beAttacked) {
        if (!Attackable.checkAttackable(attackUnit[attack], beAttackedUnit[beAttacked])) {
            System.out.println(
                    attackUnit[attack].getName() + "가" + beAttackedUnit[beAttacked].getName() + "을(를) 공격할 수 없습니다.");
        } else {
            System.out.println(
                    attackUnit[attack].getName() + "가" + beAttackedUnit[beAttacked].getName() + "을(를) 공격하였습니다.");
            Boolean isRemove = Attacking.attackingUnit(attackUnit[attack], beAttackedUnit[beAttacked]);
            if (isRemove == true) {
                beAttackedUnit = Attacking.removeUnit(beAttackedUnit, beAttacked);
            }
        }
    }
}
