package ConnectFour;

public class Board {
    private final int rows;
    private final int cols;
    private DiskColor[][] grid;

    public Board(){
        this.rows = 6;
        this.cols = 7;
        this.grid = new DiskColor[rows][cols];
    }

    public boolean canPlace(int col){
        return grid[0][col] == null;
    }

    public int placeDisk(int col, DiskColor color){
        if (col < 0 || col >= cols){
            return -1;
        }

        if (!this.canPlace(col)){
            return -1;
        }

         for (int row = rows-1; row >= 0; row--){
             if(grid[row][col] == null){
                 grid[row][col] = color;
                 return row;
             }
         }

         return -1;
    }

    public boolean isFull(){
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if(grid[i][j] == null){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkWin(int row, int col, DiskColor color){
        if (row < 0 && row >= rows && col < 0 && col >= cols) {
            return false;
        }
        if (grid[row][col] != color) {
            return false;
        }

        int[][] directions = new int[][]{{0,1}, {1,0}, {1,1}, {-1,1}};

        for (int[] dir : directions){
            int dr = dir[0];
            int dc = dir[1];
            int count = 1;

            count += countInDirection(row, col, dr, dc, color);
            count += countInDirection(row, col, -dr, -dc, color);

            if (count >= 4){
                return true;
            }
        }

        return false;
    }

    private int countInDirection(int row, int col, int dr, int dc, DiskColor color) {
        int count = 0;
        int r = row + dr;
        int c = col + dc;

        while (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == color) {
            count++;
            r += dr;
            c += dc;
        }

        return count;
    }
}
