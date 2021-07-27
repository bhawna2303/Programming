class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len = wage.length;
        Worker[] workers = new Worker[len];
        
        for(int i = 0; i < len; i++){
            workers[i] = new Worker(wage[i], quality[i]);
        }
        
        Arrays.sort(workers);
    
        PriorityQueue<Integer> pool = new PriorityQueue();
        double ans = Double.MAX_VALUE;
        int sumq = 0;
        for(int i = 0; i < len; i++){
            sumq += workers[i].quality;
            pool.offer(-1 *(workers[i].quality));
            if(pool.size() > k){
                sumq += pool.poll();
            }
            if(pool.size() == k){
                ans = Math.min(ans, sumq*workers[i].ratio);
            }
        }
        return ans;
    } 
    
}

class Worker implements Comparable<Worker>{
    int wage;
    int quality;
    double ratio;
    
    public Worker(int w, int q)
    {
        this.wage = w;
        this.quality = q;
        this.ratio = (double)w/q;
    }
    
    public int compareTo(Worker o){
        return Double.compare(this.ratio , o.ratio);
    }
}
