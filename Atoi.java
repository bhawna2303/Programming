/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming;

import java.util.HashMap;

/**
 *
 * @author bhkumari
 */
class Atoi {
    public int myAtoi(String s) {
        HashMap<Integer, HashMap<Character, Integer>> map = new HashMap();
        createAutomata(map); 
        
        StringBuilder validString = extractValidString(map, s);
        int len = validString.length();
        if(len == 0){
            return 0;
        }
        String valid = validString.toString();
        
        int sign = 1;
        int i = 0;
        if(valid.charAt(i)=='+' || valid.charAt(i)=='-')
            sign=valid.charAt(i++)=='+' ? 1:-1;
        
        long result=0;
        while(i<len && Character.isDigit(valid.charAt(i))){
            result=result*10 + (valid.charAt(i++)-'0');
            if(result*sign>Integer.MAX_VALUE || result*sign<Integer.MIN_VALUE)
                return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;   
        }
        return (int)(result*sign);
    }
    
    private StringBuilder extractValidString(HashMap<Integer, HashMap<Character, Integer>> map, String s){
        StringBuilder validString = new StringBuilder();
        int state = 1;
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            HashMap<Character, Integer> tempVal;
            tempVal = map.get(state);
            
            char key = 'n';
            if(temp == ' '){
                key = temp;
            }
            else if(temp >= '0' && temp <= '9'){
                key = 'd';
            }
            else if(temp == '+' || temp == '-'){
                key = 's';
            }
            if(tempVal.containsKey(key)){
                state = tempVal.get(key);
                if(temp == ' '){
                    continue;
                }
                else{
                    validString.append(temp); 
                }
                
            }
            else{
                 break;
            }            
            
        }
        return validString;
    }
    
    private void createAutomata(HashMap<Integer, HashMap<Character, Integer>> map){
        HashMap<Character, Integer> valueOfOneState = new HashMap();
        valueOfOneState.put(' ', 1);
        valueOfOneState.put('d', 2);
        valueOfOneState.put('s', 3);
        map.put(1, valueOfOneState);
        
        HashMap<Character, Integer> valueOfTwoState = new HashMap();
        valueOfTwoState.put('d', 2);        
        map.put(2, valueOfTwoState);
        
        HashMap<Character, Integer> valueOfThreeState = new HashMap();
        valueOfThreeState.put('d', 2);        
        map.put(3, valueOfThreeState);
    }
}
