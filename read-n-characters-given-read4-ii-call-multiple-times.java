/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    
    Queue<Character> queue = new LinkedList<>();
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
   
    public int read(char[] buf, int n) {
        
        int total = 0;
        int i;
        int r;
        while(total < n){
            char[] buf4 = new char[4];
            r = read4(buf4);
            if(r == 0){
                break;
            }
            total += r;
            i = 0;
            while(i < r){
                queue.add(buf4[i]);
                buf4[i++] = '\0';
            }
        }
        int j;
        for(j = 0; j < n && !queue.isEmpty(); j++){
            buf[j] = queue.poll();
        }
        return j;
        
    }    
    
}
