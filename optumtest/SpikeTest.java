package optumtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SpikeTest {
	
	public static void main(String[] args) {
		SpikeTest test = new SpikeTest();
		//int[] spike = {4,5,7,6,3,2};
		//int[] spike = {1,1,5,4,3};
		//int[] spike = {1,4,3,5};
		//boolean status = test.checkSpike(spike);
		//System.out.println("Status::"+status);
		//int[] spike = {1,2};
		int[] spike = {2,5,3,2,4,1};
		//int max = test.solution(spike);
		//System.out.println("solution max:"+max);
		
		
		PermutationTest permTest = new PermutationTest();
		HashMap<Integer, ArrayList<ArrayList<Integer>>> permMap = permTest.permutation(spike);
		ArrayList<ArrayList<Integer>> permListOfList = permMap.get(spike.length-1);
		//int max = 0;
		Set<ArrayList<Integer>> spikeSet = new HashSet<ArrayList<Integer>>();
		for(ArrayList<Integer> tempList : permListOfList) {
			int[] tempSpike = tempList.stream().mapToInt(Integer::intValue).toArray();
			if(test.checkSpike(tempSpike)) {
				//max = tempSpike.length; 
				System.out.println("Spike:"+tempList);
				spikeSet.add(tempList);
			 }
		}
		
		System.out.println("Number of spikes in permutations:"+spikeSet.size());
		
	}
	
	 public int solution(int[] A) {
	        // write your code in Java SE 8
		 ArrayList<Integer> temp = new ArrayList<Integer>();
		 int max = 0;
		 for(int i=0; i < A.length; i++) {
			 temp.clear();
			 temp.add(A[i]);
			 for (int j=i+1; j < A.length; j++) {
				 temp.add(A[j]);
				 int[] tempSpike = temp.stream().mapToInt(Integer::intValue).toArray();
				 System.out.println("tempSpike:"+temp);
				 if(checkSpike(tempSpike)) {
					max = tempSpike.length; 
				 }
				 
			 }
		 }
		 
		 System.out.println("Max Value:" +max);
		 
		 return max;
	    }
	 
	 
	 public boolean checkSpike(int[] spikeArry) {
		 
		 int mid = ( spikeArry.length/2 + spikeArry.length%2 ) - 1;
		 
		 //System.out.println("Mid Value:"+mid);
		 
		 int min = 0; 
		 boolean minStatus = true;
		 boolean maxStatus = true;
		 for(int i=0; i <= mid; i++) {
			if(i==0) {
				min = spikeArry[i];
			} else {
				if(min >= spikeArry[i]) {
					minStatus = false;
				    break;	
				} else {
					min = spikeArry[i];
				}
			}
		 }
		 
		 if(minStatus) {
			 int max = 0;
			 for(int j= (spikeArry.length-1); j > mid ; j--) {
				 if(j==spikeArry.length-1) {
						max = spikeArry[j];
					} else {
						if(spikeArry[j] <= max) {
							maxStatus = false;
						    break;	
						} else {
							max = spikeArry[j];
						}
					}
			 }
		 }
		 
		// System.out.println("minStatus"+minStatus+": maxStatus:"+maxStatus);
		 
		 return minStatus && maxStatus;
		 
	 }

}
