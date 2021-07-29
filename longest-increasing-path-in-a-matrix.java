class Solution {
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int nr = matrix.length;
        int nc = matrix[0].length; 
        int[][] grid = new int[nr][nc];
        
        int maxSize = 0;
        
        for(int i = 0; i < nr; i++){
            for(int j = 0; j < nc; j++){ 
                maxSize = Math.max(maxSize, dfs(matrix, i, j, -1, grid));
            }
        }
        return maxSize;
    }
    
    private int dfs(int[][] matrix, int i, int j, int prev, int[][]grid){
        int nr = matrix.length;
        int nc = matrix[0].length;
        
        if(i < 0 || j < 0 || i >= nr || j >= nc  || prev >= matrix[i][j]){
            return 0;
        }
        
        if(grid[i][j] != 0) return grid[i][j];
                
        int s1 = dfs(matrix, i-1, j, matrix[i][j], grid);
        
        int s2 = dfs(matrix, i+1, j, matrix[i][j], grid);
        
        int s3 = dfs(matrix, i, j-1, matrix[i][j], grid);
        
        int s4 = dfs(matrix, i, j+1, matrix[i][j], grid);
        
        grid[i][j] = 1+ Math.max(Math.max(s1, s2), Math.max(s3,s4));
        return grid[i][j];
    }
}
