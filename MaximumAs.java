/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming;

/**
 *
 * @author bhkumari
 */
public class MaximumAs {
    
    public static int getMaxAs(int n){
        int[] dptable = new int[n+6];
        dptable[0] = 0;
        dptable[1] = 1;
        dptable[2] = 2;
        dptable[3] = 3;
        dptable[4] = 4;
        dptable[5] = 5;
        if(n < 6){
            return dptable[n];
        }
        int res = 0;
        int tmp = 0;
        int j,k;
        for(int i = 6; i <= n; i++){
            res = tmp = 0;
            j = i-3;
            k =2;
            while(tmp >= res){
                res = tmp;
                tmp = dptable[j] * k;
                j--;
                k++;
            }
            dptable[i] = res;
        }
        return dptable[n];         
                              
    }
    
    public static void main(String args[]){
        for(int i = 1; i <= 30; i++)
        System.out.println(MaximumAs.getMaxAs(i));
    }
    
}
