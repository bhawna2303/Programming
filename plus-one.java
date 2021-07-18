class Solution {
    public int[] plusOne(int[] digits) {
        int[] ans;
        int len = digits.length;
        int i = 0;
        while(i < len){
            if(digits[i] != 9){
                break;
            }
            i++;
        }
        //If all are 9s then create ans array of length len+1  and add first 1 and all 0's
        if(i == len){
            ans = new int[len +1];
            Arrays.fill(ans,0);
            ans[0] = 1;
            return ans;
        }
        else{
            digits[len-1] += 1;         
            for(i = len-1; i > 0; i--){                
                digits[i-1] += digits[i]/10;
                digits[i] = digits[i]%10;
            }
        }
        return digits;
    }
}
