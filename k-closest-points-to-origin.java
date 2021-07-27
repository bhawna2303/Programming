class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int len = points.length;
        PriorityQueue<Point> pool = new PriorityQueue(new Comparator<Point>(){
            public int compare(Point a, Point b){
                return b.squareDis - a.squareDis;
            }
        });
        
        Point[] objects = new Point[len];
        
        for(int i = 0; i < len; i++){
            objects[i] = new Point(points[i][0], points[i][1]);
            pool.offer(objects[i]);
            
            if(pool.size() > k){
                pool.poll();
            }
        }        
        
        int[][] res = new int[k][2];
        int i = 0;
        while(i < k){
            Point temp = pool.poll();
            res[i][0] = temp.x;
            res[i][1] = temp.y;
            i++;
        }
        
        return res;
        
    }
}

class Point{
    int x;
    int y;
    int squareDis;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
        this.squareDis = x*x + y*y;
    }
}
