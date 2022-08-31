public abstract class Animal {
    public String type() { // 클래스의 이름을 반환
        return this.getClass().getSimpleName();
    }

}

class Bat extends Animal implements Flyable, Swimable {
    public boolean isFlyable() {
        return true;
    }

    public boolean isSwimable() {
        return true;
    }
}

class Penguin extends Animal implements Swimable {
    public boolean isSwimable() {
        return true;
    }
}

class Sparraw extends Animal implements Flyable, Swimable {
    public boolean isFlyable() {
        return true;
    }

    public boolean isSwimable() {
        return true;
    }
}
