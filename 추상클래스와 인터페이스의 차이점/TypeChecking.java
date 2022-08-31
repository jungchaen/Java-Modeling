public class TypeChecking {
    public static void isFlyable(Animal x) {
        try {
            if (x instanceof Flyable) {
                System.out.println(x.type() + "는(은) 날 수 있어.");
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("날 수 없는 Animal을 입력하였습니다.");
        }

    }

    public static void isSwimable(Animal x) {
        if (x instanceof Swimable) {
            System.out.println(x.type() + "는(은) 헤엄칠 수 있어.");
        } else {
            System.out.println(x.type() + "는(은) 헤엄못쳐.");
        }
    }

    public static void main(String[] args) {
        TypeChecking.isFlyable(new Bat());
        TypeChecking.isFlyable(new Sparraw());
        TypeChecking.isFlyable(new Penguin());

        System.out.println();

        TypeChecking.isSwimable(new Bat());
        TypeChecking.isSwimable(new Penguin());
        TypeChecking.isSwimable(new Sparraw());
    }
}
