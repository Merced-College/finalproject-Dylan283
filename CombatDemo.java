//Dylan Hamilton
//12-4-25

public class CombatDemo {
    public static void main(String[] args) {
        Player p = new Player("Dylan", 80, 18, 6, 75, 12, 12); // custom player stats
        Enemy goblin = new Enemy("Goblin", 40, 12, 3, 60, 5, 8);

        CombatManager cm = new CombatManager();
        cm.resolveCombat(p, goblin);

        // After combat: show inventory or healing etc.
        System.out.println("Post-combat player: " + p);
    }
}
