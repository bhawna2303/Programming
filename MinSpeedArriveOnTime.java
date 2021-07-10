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
public class MinSpeedArriveOnTime {
    public int minSpeedOnTime(int[] dist, double hour) {
	int len = dist.length;
	int min = 1;
	int max = 10000000;
	int ans = -1;
	while(min <= max){
		int mid = (min+max)/2;
		double sum = 0;
		for(int i = 0; i < len-1; i++){
			sum += Math.ceil(((double)dist[i])/mid);
		}
		sum += ((double)dist[len-1])/mid;
		if(sum > hour){
			min = mid+1;
		}
		else{
			ans = mid;
			max = mid-1;
		}
		
	}
	return ans;
    }
    
}
