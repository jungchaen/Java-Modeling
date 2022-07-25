public class Attackable { // 공격을 할 수 있는지 없는지를 판단하는 타입
    public static Boolean checkAttackable(Unit attackUnit, Unit beAttackedUnit) {
        if (attackUnit instanceof Ground && beAttackedUnit instanceof Fly) {
            return false;
        } else {
            return true;
        }
    }
}
