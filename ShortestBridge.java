
//https://leetcode.com/problems/shortest-bridge/
class Solution {     
    int firstIslandI;
    int firstIslandJ;
    
    
    public int shortestBridge(int[][] grid) {         
        int r = grid.length;
        int c = grid[0].length;
        int[][] disMat =  new int[r][c];
        int numOfIsland = 0;
        List<int[]> islandEdges  = new ArrayList();
        boolean[][] visited = new boolean[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    if(numOfIsland == 0){
                        firstIslandI =i;
                        firstIslandJ = j;
                        dfs(i,j,grid, visited, 2, islandEdges);
                        numOfIsland++;
                    }                    
                }
            }
        }
        
        return bfs(grid, disMat, islandEdges);    
        
        
    } 
    
    private void dfs(int i, int j, int[][] grid, boolean[][] visited, int val, List<int[]> islandEdges){
        int r = grid.length;
        int c = grid[0].length;
        
        if(i < 0 || i > r-1 || j < 0 || j > c-1 || grid[i][j] == 0 || visited[i][j]){
            return;
        }
        
        visited[i][j] = true;
        grid[i][j] = val; 
        if(checkEdge(grid, i, j)){
            int[] temp = {i,j};
            islandEdges.add(temp);
        }
        
        
        
        dfs(i+1,j,grid, visited, val,islandEdges);
        dfs(i-1,j,grid, visited, val, islandEdges);
        dfs(i,j+1,grid, visited, val,islandEdges);
        dfs(i,j-1,grid, visited, val,islandEdges);
    } 
    
    private int bfs(int[][] grid, int[][] disMat, List<int[]> islandEdges){
        int shortestDis = Integer.MAX_VALUE;        
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int r = grid.length;
        int c = grid[0].length;
        LinkedList<int[]> queue = new LinkedList();
        boolean[][] visited = new boolean[r][c];
        
        for(int m = 0; m < islandEdges.size(); m++){
            int[] temp = {islandEdges.get(m)[0],islandEdges.get(m)[1]};
            queue.add(temp);
            visited[islandEdges.get(m)[0]][islandEdges.get(m)[1]] = true;
        }       
        
        while(!queue.isEmpty()){
            int[] tempInQueue = queue.poll();
            for(int d = 0; d < 4; d++){
                int ni = tempInQueue[0] + dir[d][0];
                int nj = tempInQueue[1] + dir[d][1];
                
                if(ni < 0 || ni >= r || nj < 0 || nj >= c){
                    continue;
                }
                if(grid[ni][nj] == 1){ 
                    shortestDis = Math.min(shortestDis , disMat[tempInQueue[0]][tempInQueue[1]]);  
                    visited[ni][nj] = true;
                    continue;
                }
                
                
                int x = disMat[tempInQueue[0]][tempInQueue[1]]+1;
                
                if(grid[ni][nj] == 0){
                    if(disMat[ni][nj] != 0 && x >= disMat[ni][nj]){
                        continue;
                    }
                    disMat[ni][nj] = x;
                    visited[ni][nj] = false;
                }                
                
                if(visited[ni][nj]){
                    continue;
                }
                if(!visited[ni][nj]){
                    visited[ni][nj] = true;
                    int[] nextele = {ni,nj};
                    queue.add(nextele);
                }
            }
            
        }
        return shortestDis;
    }
    
    private boolean checkEdge(int[][] grid, int i , int j){
        int r = grid.length;
        int c = grid[0].length;
        
        if(i-1 >= 0 && grid[i-1][j] == 0){
            return true;
        }
        
        if(i+1 < r && grid[i+1][j] == 0){
            return true;
        }
        
        if(j-1 >= 0 && grid[i][j-1] == 0){
            return true;
        }
        
        if(j+1 < c && grid[i][j+1] == 0){
            return true;
        }
        return false;
    }
    
}
