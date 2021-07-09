/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming;

/**
 *
 * @author bhkumari
 */
public class PowFunction {
    
    public static int power(int x, int y){
        if(y == 0){
            return 1;
        }
        if(y % 2 == 0){
            return power(x, y/2) * power(x, y/2);
        }
        else{
            return x * power(x, y/2) * power(x, y/2);
        }
    }
    
    public static void main(String args[]){
        int x = 3;
        int y = 9;
        System.out.println(power(x,y));
    }
    
}
