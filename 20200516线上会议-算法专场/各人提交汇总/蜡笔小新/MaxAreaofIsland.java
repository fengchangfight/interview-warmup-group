import java.util.Arrays;

public class MaxAreaofIsland {
    static class Counter {
        int cnt;

        public Counter() {
            cnt = 0;
        }

        public void increase() {
            this.cnt++;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length < 1) {
            return 0;
        }

        int width = grid[0].length;
        boolean[] accessLog = new boolean[grid.length * width];
        Arrays.fill(accessLog, false);
        int globalMax = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !accessLog[getIndex(i, j, width)]) {
                    Counter counter = new Counter();
                    traverseFrom(grid, i, j, accessLog, counter);
                    globalMax = Math.max(globalMax, counter.cnt);
                }
            }
        }
        return globalMax;
    }

    private void traverseFrom(int[][] grid, int r, int c, boolean[] accessLog, Counter counter) {
        int wid = grid[0].length;
        if (accessLog[getIndex(r, c, wid)]) {
            return;
        }

        counter.increase();
        accessLog[getIndex(r, c, wid)] = true;

        // check up
        if (r > 0 && grid[r - 1][c] == 1) {
            traverseFrom(grid, r - 1, c, accessLog, counter);
        }

        // check bottom
        if (r < grid.length - 1 && grid[r + 1][c] == 1) {
            traverseFrom(grid, r + 1, c, accessLog, counter);
        }

        // check left
        if (c > 0 && grid[r][c - 1] == 1) {
            traverseFrom(grid, r, c - 1, accessLog, counter);
        }

        // right
        if (c < wid - 1 && grid[r][c + 1] == 1) {
            traverseFrom(grid, r, c + 1, accessLog, counter);
        }
    }

    int getIndex(int row, int col, int width) {
        return row * width + col;
    }

}
