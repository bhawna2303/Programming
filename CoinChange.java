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
public class CoinChange {
    
    public static int countRec(int[] S, int m, int sum){        
        if(sum == 0){
            return 1;
        }
        if(sum < 0 ){
            return 0;
        }
        if(m <= 0 && sum >=1){
            return 0;
        }
        return countRec(S, m-1, sum) + countRec(S, m, sum-S[m-1]);
        
    }
      
    
    public static int countDP(int[] S, int m, int sum){
        int[] table = new int[sum+1];
        table[0] = 1;
        
        for(int i = 0; i < m; i++){
            for(int j = S[i]; j <= sum; j++){
                table[j] += table[j- S[i]];
            }
        }
        return table[sum];
    }
    
    public static void main(String args[]){
        int[] S = {1,2,3};
        System.out.println(countRec(S, S.length, 5));
        System.out.println(countDP(S, S.length, 5));
                
    }
}
