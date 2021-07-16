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
public class LongestSubStringWORepeatation { 
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap();
        
        int i = 0;
        int start = 0;
        int end = 0;
        int max = 0;
        while(i < s.length()){
            if(map.containsKey(s.charAt(i))){
                start = Math.max((map.get(s.charAt(i)) + 1) , start);                 
            }
            map.put(s.charAt(i), i);
            end = i;
            max = Math.max(max, end-start+1);
            i++;
        }
        return max;
    }
}


    