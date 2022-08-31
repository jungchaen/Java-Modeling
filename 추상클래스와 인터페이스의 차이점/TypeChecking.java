public class TypeChecking {
    public static void isFlyable(Animal x) {
        try {
            if (x instanceof Flyable) {
                System.out.println(x.type() + "is can fly.");
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("You have entered an Animal that cannot fly.");
        }

    }

    public static void isSwimable(Animal x) {
        if (x instanceof Swimable) {
            System.out.println(x.type() + "is can swim.");
        } else {
            System.out.println(x.type() + "is can't swim.");
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
