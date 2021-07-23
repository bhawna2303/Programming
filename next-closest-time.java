class Solution {
    public String nextClosestTime(String time) {
        char[] digits = new char[4];
        int k = 0;
        for(int i = 0; i < time.length(); i++){
            if(time.charAt(i) == ':'){
                continue;
            }
            digits[k++] = time.charAt(i);
        }
        Arrays.sort(digits);
            
        String[] splitTime = time.split(":");
        String h = splitTime[0];
        String m = splitTime[1];
            
        String r = findJustGreater(digits, m);
        
        if(Integer.parseInt(r) > Integer.parseInt(m) && Integer.parseInt(r) < 60){
             return h + ":" + r;
        }
            
        r = findJustGreater(digits, h);
        if(Integer.parseInt(r) > Integer.parseInt(h) && Integer.parseInt(r) < 24){
           return r + ":" + digits[0] + digits[0];
        }
            
        String tt = "" + digits[0] + digits[0] + ":" + digits[0] + digits[0];
        return tt;
               
        
    }
    
    private String findJustGreater(char[] digits, String x){
        
        for(int i = 0; i < digits.length; i++){
            if(digits[i] > x.charAt(1)){
                return "" + x.charAt(0) + digits[i];
            }
        }
        
        for(int i = 0; i < digits.length; i++){
            if(digits[i] > x.charAt(0)){
                return "" + digits[i] + digits[0];
            }
        }
        return x;
    }
}
