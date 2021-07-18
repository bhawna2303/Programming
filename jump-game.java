class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int dis = 0;        
        for(int i = 0; i < nums.length; i++){            
            dis = Math.max(nums[i], dis);
            if(dis == 0 && i != nums.length-1){
                return false;
            }
            dis--;
        }        
        return true;
    }
}
