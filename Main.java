//Dylan Hamilton
////12-4-25

public class Main {
    public static void main(String[] args) {

        Player p = new Player("Dylan");

        p.getInventory().addItem("Sword");
        p.getInventory().addItem("Sword");
        p.getInventory().addItem("Shield");

        p.getInventory().showInventory();

        p.getInventory().removeItem("Sword");

        p.getInventory().showInventory();
    }
}

