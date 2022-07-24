public abstract class Unit {
    private String name; // 이름
    private int damage; // 공격력
    private int hp; // 방어력
    private Brood brood; // 종족

    public Unit(String name, int damage, int hp) {
        this.name = name;
        this.damage = damage;
        this.hp = hp;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getHp() {
        return this.hp;
    }

    public String getName() {
        return this.name;
    }

    public Brood getBrood() {
        return this.brood;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setBrood(Brood brood) {
        this.brood = brood;
    }
}
