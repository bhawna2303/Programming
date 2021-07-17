class Solution {
	public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        
        int ans[] = new int[num1.length() + num2.length() -1];
        for(int i = 0; i < num1.length(); i++){
            for(int j = 0; j < num2.length(); j++){
                ans[i+j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        
        for(int j = ans.length-1; j > 0; j--){
            ans[j-1] += ans[j]/10;
            ans[j] = ans[j] % 10;
        } 
        
        StringBuilder s = new StringBuilder();
        for(int j = 0; j < ans.length; j++){
            s.append(ans[j]);
        } 
        return s.toString();
    }
		
}
