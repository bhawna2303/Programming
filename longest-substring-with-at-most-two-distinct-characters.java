class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap();
        int len = s.length();
        int i = 0;
        int j = 1;
        int max = 1;
        map.put(s.charAt(i), 1);
        while(j < len){
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), map.get(s.charAt(j))+1);
            }
            else{
                map.put(s.charAt(j), 1);
            }            
            while(map.size() > 2){
               if(map.get(s.charAt(i)) == 1){
                    map.remove(s.charAt(i));
                }
                else{
                    map.put(s.charAt(i), map.get(s.charAt(i))-1);
                }
                i++;
            }
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}
