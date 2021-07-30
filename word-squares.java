//https://leetcode.com/problems/word-squares/
class Solution {
    Map<String, ArrayList<String>> map = new HashMap();
    
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList();
        
        //Create Prefix map
        createPrefixMap(words);
        
        //Backtracking
        for(String word : words){
            ArrayList<String> list = new ArrayList();
            list.add(word);
            backTrack(1, list, result, word.length());
        }
        return result;
    }
    
    private void backTrack(int step, ArrayList<String> list, List<List<String>> result, int n){
        if(list.size() == n){
            result.add(new ArrayList<>(list));
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for(String word : list){
            sb.append(word.charAt(step));
        }
        
        String prefix = sb.toString();
        List<String> wordList = map.getOrDefault(prefix, new ArrayList());
        for(String word : wordList){
            list.add(word);
            backTrack(step+1, list, result, n);
            list.remove(list.size() -1);
        }
        
        
    }
    
    private void createPrefixMap(String[] words){
        for(String word : words){
            for(int i = 0; i < word.length(); i++){
                String prefix = word.substring(0, i);
                map.putIfAbsent(prefix, new ArrayList<String>());
                ArrayList<String> list = map.get(prefix);
                list.add(word);
            }
        }
    }
}
