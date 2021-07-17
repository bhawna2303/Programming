class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);       
        int j = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < j; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }                     
            findTuples(nums, nums[i], i, result);                
            
        }
        return result;
    }
    
    private void findTuples(int[] nums, int sum, int index, List<List<Integer>> result){
        int req = -1 * sum;
        int j = nums.length -1;
        int i = index+1;
        while(i < j){
            if(i > index+1 && nums[i] == nums[i-1]){
                i++;
                continue;
            }
            if(nums[i] + nums[j] > req){
                j--;
            }
            else if(nums[i] + nums[j] < req){
                i++;
            }
            else{
                List<Integer> temp = new ArrayList<>();
                temp.add(sum);
                temp.add(nums[i]);
                temp.add(nums[j]);
                result.add(temp);
                i++;
                j--;
            }
        }
        
    }
}
