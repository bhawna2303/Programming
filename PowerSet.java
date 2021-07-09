/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bhkumari
 */
public class PowerSet {
    
    public List<List<Integer>> subsetsIterative(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        for(int item : nums){
            int n = result.size();
            for(int i = 0; i < n; i++){
                ArrayList<Integer> r = new ArrayList<>(result.get(i));
                r.add(item);
                result.add(r);
            }
        }
        
        return result;
        
    }
    
     public List<List<Integer>> subsetsRec(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());        
        helper(0, nums, result);       
        return result;
    }
    
    private void helper(int i, int[] nums, List<List<Integer>> result){
        if(i == nums.length){
            return;
        }
        int n = result.size();
        for(int j = 0; j < n; j++){
            ArrayList<Integer> r = new ArrayList<>(result.get(j));
            r.add(nums[i]);
            result.add(r);
        }
        helper(i+1, nums, result);
    }
    
    public List<List<Integer>> subsetsBit(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();        
        
        int n = (int)Math.pow(2, nums.length);
        for(int i = 0; i < n; i++){
            ArrayList<Integer> r = new ArrayList<>();
            for(int j = 0; j < nums.length; j++){
                if(((1<<j) & i) > 0){
                    r.add(nums[j]);
                }
            }
            result.add(r);
        }
        return result;
       
    } 
    
}
