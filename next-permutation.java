class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int j = findDip(nums);
        
        if(j < 0){
             reverseArray(nums, 0, len-1);
        }
        else{       
            findNextGreaterIndexAndSwap(nums, j, len-1);            
            reverseArray(nums, j+1, len-1);        
        }       
        
    }
    
    private int findDip(int[] nums){
        // find the decreasing element from right to left
        int j = nums.length -1;
        while(j > 0){
            if(nums[j] > nums[j-1]){
                break;
            }
            j--;
        }
        j--;
        return j;
    }
    
    private void reverseArray(int[] nums, int l, int r){
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    
    private void findNextGreaterIndexAndSwap(int[] nums, int j, int k){
        while(k > j && nums[k] <= nums[j]){
              k--;
             }
            // swap k & j elements
            int temp = nums[j];
            nums[j] = nums[k];
            nums[k] = temp;
    }
}
