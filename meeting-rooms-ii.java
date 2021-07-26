class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        int[] entry = new int[len];
        int[] exit = new int[len];
        
        for(int i = 0; i < len; i++){
            entry[i] = intervals[i][0];
            exit[i] = intervals[i][1];
        }
        
        Arrays.sort(entry);
        Arrays.sort(exit);
        
        return countInMerge(entry, exit, len);
    }
    
    private int countInMerge(int[] entry, int[] exit, int len){
        int count = 0;
        int i = 0;
        int j = 0;
        int max = 0;
        while(i < len && j < len){
            if(entry[i] < exit[j]){
                count++;                
                i++;
            }
            else{
                count--;
                j++;
            }
            max = Math.max(max, count);
        }
        
        return max;
    }
}
