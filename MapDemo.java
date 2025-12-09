public class MapDemo {
    public static void main(String[] args) {
        GameMap map = new GameMap(8, 8);
        map.generateRandomDangers(10);

        // Start reveal at player location (example: 4,4)
        map.revealRecursive(4, 4);

        map.printMap();
    }
}
