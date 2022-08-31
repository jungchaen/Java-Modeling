/* 추상클래스와 인터페이스의 차이점
 * 추상클래스 : 상속의 관점, 서브 클래스에서 1개의 클래스만 상속 가능 
 * 인터페이스 : 기능부여의 관점, 구현 클래스에서 여러 개의 인터페이스 implements 가능
 */
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
