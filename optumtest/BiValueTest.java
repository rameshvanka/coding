package optumtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BiValueTest {

	public static void main(String... args) {
		int A[] = {4,2,2,4,2};
		int A1[] = { 1,2,3,2};
		int A2[] = { 0,5,4,4,5,12};
		int A3[] = { 4,4};
		BiValueTest test = new BiValueTest();
		int maxValue = test.solution(A3);
		System.out.println("maxValue:"+maxValue);

	}


	
	public int solution(int[] A) {
		// write your code in Java SE 8
		Set<Integer> targetSet = new HashSet<Integer>();
		int maxlength = 0;
		int start = 0;
		int end = 0;
		HashMap<Integer,Integer> loopMax = new HashMap<Integer,Integer>();
		for (int i = 0; i < A.length; i++) {
			start = i;
			end = i;
			targetSet.clear();
			System.out.println("    ");
			for (int j = i; j < A.length; j++) {
				targetSet.add(A[j]);
				System.out.print(A[j]);
				if (targetSet.size() <= 2) {
					end = j;
					maxlength = end - start;
					loopMax.put(i, maxlength);
					//System.out.println(targetSet);
				} else {
					break;
				}
			}
		}
		
		
		System.out.println("loopMax:"+loopMax);
		
		int maxValue = 0;
		Iterator<Integer> iter = loopMax.values().iterator();
		while(iter.hasNext()) {
			Integer temp = iter.next();
			if(temp.intValue() > maxValue) {
				maxValue = temp.intValue();
			}
		}
		
		System.out.println("MaxValue:"+maxValue);
		
		return maxValue > 0 ? maxValue+1:0;
	}
	

	


}
