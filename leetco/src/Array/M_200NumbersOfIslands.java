package Array;

public class M_200NumbersOfIslands {
    //solution1 dfs
    public int numIslands1(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '0'){
                    continue;
                }else if(grid[i][j] == '1'){
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int x, int y){
        int row = grid.length;
        int column = grid[0].length;
        if(x  < 0 || y < 0 || x >= row || y >= column || grid[x][y] == '0'){
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
