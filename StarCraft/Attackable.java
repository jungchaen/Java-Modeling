public class Attackable {
    public static Boolean attacked(Unit attack, Unit beAttacked) {
        if (attack instanceof Ground && (beAttacked instanceof Fly || beAttacked instanceof HybridGround)) {
            return false;
        } else {
            beAttacked.setHp(beAttacked.getDamage() - attack.getDamage());
            if (beAttacked.getHp() <= 0) {
                System.out.println(beAttacked.getName() + "가 소멸되었습니다.");
                return true;
            } else {
                return true;
            }

        }
    }
}
