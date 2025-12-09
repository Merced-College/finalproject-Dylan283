//Dylan Hamilton
//12-4-25

public class MapTile {
    
    private boolean hidden = true;
    private boolean dangerous = false;  // optional for later combat
    private int nearbyDangerCount = 0;

    public boolean isHidden() { return hidden; }
    public boolean isDangerous() { return dangerous; }
    public int getNearbyDangerCount() { return nearbyDangerCount; }

    public void setDangerous(boolean dangerous) { this.dangerous = dangerous; }
    public void setNearbyDangerCount(int count) { this.nearbyDangerCount = count; }

    public void reveal() { hidden = false; }
}
