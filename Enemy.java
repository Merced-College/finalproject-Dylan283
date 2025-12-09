//Dylan Hamilton
//12-4-25

public class Enemy {
    private final String type;
    private int hp;
    private final int maxHp;
    private final int attack;
    private final int defense;
    private final int accuracy;
    private final int evasion;
    private final int speed;

    public Enemy(String type, int maxHp, int attack, int defense, int accuracy, int evasion, int speed) {
        this.type = type;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.accuracy = accuracy;
        this.evasion = evasion;
        this.speed = speed;
    }

    public String getType() { return type; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getAccuracy() { return accuracy; }
    public int getEvasion() { return evasion; }
    public int getSpeed() { return speed; }

    public boolean isAlive() { return hp > 0; }

    public void takeDamage(int amount) {
        hp = Math.max(0, hp - amount);
    }

    @Override
    public String toString() {
        return String.format("%s (HP: %d/%d, ATK: %d, DEF: %d, SPD: %d)", type, hp, maxHp, attack, defense, speed);
    }
}
