class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];
        higher[n-1] = lower[n-1] = true;
        int res = 1;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n-1], n-1);
        
        for(int i = n-2; i >= 0; i--){
            Map.Entry hi = map.ceilingEntry(arr[i]);
            Map.Entry lo = map.floorEntry(arr[i]);
            if(hi != null){
                higher[i] = lower[(int)hi.getValue()];
            }
            if(lo != null){
                lower[i] = higher[(int)lo.getValue()];
            }
            if(higher[i])
                res++;
            map.put(arr[i], i);
        }
        
        return res;
        
    }
    
    
}
