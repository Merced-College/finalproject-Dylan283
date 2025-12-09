//Dylan Hamilton
//12-4-25

import java.util.Objects;

public class Player {
    private final String name;
    private int hp;
    private final int maxHp;
    private int attack;
    private int defense;
    private int accuracy; // 0-100 base hit chance modifier
    private int evasion;  // 0-100 evasion modifier
    private int speed;    // initiative
    private Inventory inventory;

    public Player(String name, int maxHp, int attack, int defense, int accuracy, int evasion, int speed) {
        this.name = Objects.requireNonNull(name);
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.accuracy = accuracy;
        this.evasion = evasion;
        this.speed = speed;
        this.inventory = new Inventory();
    }

    // convenience constructor with default stats
    public Player(String name) {
        this(name, 100, 15, 5, 70, 10, 10);
    }

    // getters & setters
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getAccuracy() { return accuracy; }
    public int getEvasion() { return evasion; }
    public int getSpeed() { return speed; }
    public Inventory getInventory() { return inventory; }

    public boolean isAlive() { return hp > 0; }

    public void heal(int amount) {
        hp = Math.min(maxHp, hp + amount);
    }

    public void takeDamage(int amount) {
        hp = Math.max(0, hp - amount);
    }

    public void modifyAttack(int delta) { attack += delta; }
    public void modifyDefense(int delta) { defense += delta; }

    @Override
    public String toString() {
        return String.format("%s (HP: %d/%d, ATK: %d, DEF: %d, SPD: %d)", name, hp, maxHp, attack, defense, speed);
    }
}
