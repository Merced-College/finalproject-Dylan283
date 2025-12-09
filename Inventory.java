//Dylan Hamilton
//12-4-25

import java.util.HashMap;

public class Inventory {

    // HashTable for storing items
    private HashMap<String, Integer> items;

    public Inventory() {
        items = new HashMap<>();
    }

    // Add item (auto counts)
    public void addItem(String itemName) {
        int current = items.getOrDefault(itemName, 0);
        items.put(itemName, current + 1);
    }

    // Remove item (auto handles zero)
    public void removeItem(String itemName) {
        if(items.containsKey(itemName)) {
            int current = items.get(itemName);
            if(current > 1) {
                items.put(itemName, current - 1);
            } else {
                items.remove(itemName);
            }
        }
    }

    // Check if player has item
    public boolean hasItem(String itemName) {
        return items.containsKey(itemName);
    }

    // Print everything
    public void showInventory() {
        System.out.println("Inventory:");
        for(String key : items.keySet()) {
            System.out.println(key + " x" + items.get(key));
        }
    }
}
