/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int count = 0;
        int r;
        int k = 0;
        do{
           r = read4(temp);
           count += r;
           for(int i = 0; i < r; i++){
               if(k >= n){
                   break;
               }
               buf[k++] = temp[i];
           }
        }while(r == 4 && count < n);
        
        return k;
    }
}
