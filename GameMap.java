public class GameMap {
    private final int width;
    private final int height;
    private final MapTile[][] grid;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new MapTile[height][width];

        // create tiles
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                grid[r][c] = new MapTile();
            }
        }
    }

    // Randomly place danger spots (you can replace with guaranteed placement)
    public void generateRandomDangers(int count) {
        int placed = 0;
        while (placed < count) {
            int r = (int)(Math.random()*height);
            int c = (int)(Math.random()*width);
            if(!grid[r][c].isDangerous()) {
                grid[r][c].setDangerous(true);
                placed++;
            }
        }
        computeNearbyCounts();
    }

    private void computeNearbyCounts() {
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                grid[r][c].setNearbyDangerCount(countAdjacentDangers(r,c));
            }
        }
    }

    private int countAdjacentDangers(int r, int c) {
        int total = 0;
        for (int rr = -1; rr <= 1; rr++) {
            for (int cc = -1; cc <= 1; cc++) {
                int nr = r + rr;
                int nc = c + cc;
                if (inBounds(nr, nc) && !(rr == 0 && cc == 0)) {
                    if(grid[nr][nc].isDangerous()) total++;
                }
            }
        }
        return total;
    }

    private boolean inBounds(int r, int c) {
        return r >= 0 && r < height && c >= 0 && c < width;
    }

    // ---- 🔁 RECURSIVE REVEAL ----
    public void revealRecursive(int r, int c) {
        if (!inBounds(r, c)) return;

        MapTile t = grid[r][c];

        // Already revealed? stop.
        if (!t.isHidden()) return;

        // Reveal tile
        t.reveal();

        // If this tile has nearby dangers, stop here (base case)
        if (t.getNearbyDangerCount() > 0) return;

        // OTHERWISE, reveal all neighbors recursively (flood fill)
        for (int rr = -1; rr <= 1; rr++) {
            for (int cc = -1; cc <= 1; cc++) {
                if (!(rr == 0 && cc == 0)) {
                    revealRecursive(r + rr, c + cc);
                }
            }
        }
    }

    public void printMap() {
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {

                MapTile t = grid[r][c];
                if (t.isHidden()) {
                    System.out.print("■ ");
                }
                else {
                    if (t.isDangerous()) System.out.print("X ");
                    else System.out.print(t.getNearbyDangerCount()+" ");
                }
            }
            System.out.println();
        }
    }
}
