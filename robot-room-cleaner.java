// https://leetcode.com/problems/robot-room-cleaner/
/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    
    Set<Pair<Integer, Integer>> visited = new HashSet();
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    //directions: 0:U, 1:R, 2:D, 3:L
    
    private void moveBack(Robot robot){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    
    public void cleanRoom(Robot robot) {               
        dfs(robot, 0, 0, 0);
    }
    
    private void dfs(Robot robot, int r, int c, int d){
        Pair<Integer, Integer> obj = new Pair<>(r, c);
        
        robot.clean();
        visited.add(obj);
        
        for(int i = 0; i < 4; i++){
            int newD = (d+i)% 4;
            int newRow = r + directions[newD][0];
            int newCol = c + directions[newD][1];
            
            if(!visited.contains(new Pair(newRow, newCol)) && robot.move()){
                dfs(robot, newRow, newCol, newD);
                moveBack(robot); 
            }
            
            robot.turnRight();          
        }       
        
        
    }   
    
}
