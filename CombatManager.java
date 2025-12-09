//Dylan Hamilton
//12-4-25

import java.util.Random;

public class CombatManager {

    private final Random rng = new Random();

    // Top-level combat routine: returns true if player won, false if player lost or fled
    public boolean resolveCombat(Player player, Enemy enemy) {
        System.out.println("Combat start!");
        System.out.println(player);
        System.out.println(enemy);
        System.out.println();

        // Continue until someone dies or player flees
        while (player.isAlive() && enemy.isAlive()) {

            // Determine initiative each round (simple: higher speed acts first; tie -> player first)
            boolean playerFirst = player.getSpeed() >= enemy.getSpeed();

            if (playerFirst) {
                if (playerTurn(player, enemy)) { // player action ended combat (fleed or won)
                    break;
                }
                if (enemy.isAlive()) enemyTurn(enemy, player);
            } else {
                if (enemyTurn(enemy, player)) { // enemy action ended combat (rare; placeholder)
                    break;
                }
                if (player.isAlive()) playerTurn(player, enemy);
            }

            System.out.println(); // round spacer
        }

        boolean playerAlive = player.isAlive();
        if (playerAlive) {
            System.out.println(player.getName() + " won the fight!");
        } else {
            System.out.println(player.getName() + " was defeated...");
        }
        System.out.println("Combat end.");
        return playerAlive;
    }

    // Player's turn: returns true if this turn ended combat (win or flee)
    private boolean playerTurn(Player player, Enemy enemy) {
        System.out.println(player.getName() + " attacks " + enemy.getType() + "!");
        boolean hit = attackHits(player.getAccuracy(), enemy.getEvasion());
        if (!hit) {
            System.out.println(" -> Attack missed!");
            return false;
        }
        int damage = computeDamage(player.getAttack(), enemy.getDefense());
        System.out.println(" -> Hit for " + damage + " damage.");
        enemy.takeDamage(damage);
        System.out.println(" -> Enemy HP: " + enemy.getHp() + "/" + enemy.getMaxHp());

        // Check for enemy defeat
        if (!enemy.isAlive()) {
            System.out.println(" -> " + enemy.getType() + " defeated!");
            return true;
        }

        // Optional: allow simple flee attempt (example small chance)
        if (tryFlee(player, enemy)) {
            System.out.println(player.getName() + " successfully fled the battle!");
            return true; // combat ended by fleeing
        }

        return false;
    }

    // Enemy's turn: returns true if combat ended (not used here)
    private boolean enemyTurn(Enemy enemy, Player player) {
        System.out.println(enemy.getType() + " attacks " + player.getName() + "!");
        boolean hit = attackHits(enemy.getAccuracy(), player.getEvasion());
        if (!hit) {
            System.out.println(" -> Enemy attack missed!");
            return false;
        }
        int damage = computeDamage(enemy.getAttack(), player.getDefense());
        System.out.println(" -> Hit for " + damage + " damage.");
        player.takeDamage(damage);
        System.out.println(" -> Player HP: " + player.getHp() + "/" + player.getMaxHp());

        if (!player.isAlive()) {
            System.out.println(" -> " + player.getName() + " has been defeated!");
            return true;
        }
        return false;
    }

    // Compute whether an attack hits: hitChance = base(50) + accuracy - evasion clipped to [5,95]
    private boolean attackHits(int attackerAccuracy, int defenderEvasion) {
        int base = 50;
        int chance = base + attackerAccuracy - defenderEvasion;
        chance = Math.max(5, Math.min(95, chance)); // ensure minimum/maximum probabilities
        int roll = rng.nextInt(100); // 0..99
        return roll < chance;
    }

    // Damage formula: at least 1 damage
    private int computeDamage(int atk, int def) {
        int raw = atk - def;
        return Math.max(1, raw + rng.nextInt(3) - 1); // small random ±1
    }

    // Simple flee mechanic: chance based on speed difference
    private boolean tryFlee(Player player, Enemy enemy) {
        int speedDiff = player.getSpeed() - enemy.getSpeed();
        int baseChance = 20; // base 20% to flee
        int chance = Math.max(5, Math.min(90, baseChance + speedDiff * 5));
        int roll = rng.nextInt(100);
        return roll < chance;
    }
}
