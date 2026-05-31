public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numIslands(new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}));
    }

    static class Solution {
        public int numIslands(char[][] grid) {
            int count = 0;

            for (int row = 0; row < grid.length; row++) {
                for (int column = 0; column < grid[0].length; column++) {
                    if (grid[row][column] == '1') {
                        count++;
                        analyzeNeighbours(grid, row, column);
                    }
                }
            }

            return count;
        }

        private void analyzeNeighbours(char[][] grid, int row, int column) {
            if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length || grid[row][column] == '0') {
                return;
            }

            grid[row][column] = '0';

            analyzeNeighbours(grid, row + 1, column);
            analyzeNeighbours(grid, row - 1, column);
            analyzeNeighbours(grid, row, column + 1);
            analyzeNeighbours(grid, row, column - 1);
        }
    }
}
