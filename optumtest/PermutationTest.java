package optumtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Basic Concept
 * 1st element 4
 * 2nd element 3,4
 *             4,3
 * 3rd element previous set 2,(3,4) and 2 (4,3) combination like this way            
 *             
 * @author rames
 *
 */
public class PermutationTest {
	
	HashMap<Integer, ArrayList<ArrayList<Integer>>> tempListOfListMap = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();

	public static void main(String[] args) {
		// int[] num = {1,2,3,4};
		int[] num = { 4, 3, 2, 1 };

		// int[] num = {1,3,2,4 }
		// int[] num = {4,2,3,1}
		// int[] num = {2,,3};
		PermutationTest test = new PermutationTest();
		// test.permutations(num);
		test.permutation(num);
		// test.cyclicPermutation(num);
	}
	
    /**
     * [4,3,2,1]
     * Here Base Concept 
     * 0 = [4]
     * 1 = [3, 4],[4, 3] 
     * 2 - [[2, 3, 4], [3, 4, 2], [4, 2, 3]] means 2,[3,4]
     * 2 - [[2, 4, 3], [4, 3, 2], [3, 2, 4]] means 2,[4,3]
     * like this
     * 
     * Here main tricky part is ArrayList.add(index, elmenet) here I am adding the next element 
     * i=2 means arr[2] = 2, then in the map how many previous sets are there map(1) = [3,4] [4,3]
     * now I am adding the arraylist.add(0,arr[2]) then [2,3,4] and [2,4,3]
     * for [2,3,4] --> [[2, 3, 4], [3, 4, 2], [4, 2, 3]]
     * for [2,4,3] --> [[2, 4, 3], [4, 3, 2], [3, 2, 4]]
     *     
     *     
     * @param num
     */
	public HashMap<Integer, ArrayList<ArrayList<Integer>>> permutation(int[] num) {
		for (int i = 0; i < num.length; i++) {
			if (i == 0) {
				int[] tempArray = Arrays.copyOf(num, i + 1);
				permutationSetMap(tempArray);
			} else {
				ArrayList<ArrayList<Integer>> prevList = tempListOfListMap.get(i - 1);
				for (ArrayList<Integer> prevIterList : prevList) {
					ArrayList<Integer> tempList = new ArrayList<Integer>(prevIterList);
					tempList.add(0, num[i]);
					int[] tempNums = tempList.stream().mapToInt(Integer::intValue).toArray();
					permutationSetMap(tempNums);
				}
			}
		}
		System.out.println("map:"+tempListOfListMap);
		return tempListOfListMap;
	}
    
	/**
	 * Using cycleSetIteration will get one CycleSet, we need to put them according key order
	 * Means int[] num = {2,3,4}
	 * num.length = 3, Key = 2 (num.length-1)
	 * Map.put(2,[[2, 3, 4], [3, 4, 2], [4, 2, 3]]
	 * 
	 * Next [2,4,3] using cyclicFunction set we will get [[2, 4, 3], [4, 3, 2], [3, 2, 4]]
	 * num.length = 3, Key = 2 (num.length-1)
	 * Map.put(2,[[2, 3, 4], [3, 4, 2], [4, 2, 3] [2, 4, 3], [4, 3, 2], [3, 2, 4]]
	 * 
	 * Map will key level - set of elements
	 * @param num
	 */
	public void permutationSetMap(int[] num) {
        int keyLevel = num.length - 1;
		ArrayList<ArrayList<Integer>> numList = cycleSetIteration(num);
		
		System.out.println("cyclic arraylist:" + numList);
		if (tempListOfListMap.containsKey(keyLevel)) {
			tempListOfListMap.get(keyLevel).addAll(numList);
		} else {
			tempListOfListMap.put(keyLevel, numList);
		}
	}

	/**
	 * It will do cyclic movement: 
	 * first [2,3,4] next movement 3,4,2 next 4,2,3
	 * 
	 * @param num [2,3,4]
	 * @return [[2, 3, 4], [3, 4, 2], [4, 2,3]]
	 */
	public ArrayList<ArrayList<Integer>> cycleSetIteration(int[] num) {
		// One combination
		ArrayList<ArrayList<Integer>> numList = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < num.length; i++) {
			int modlength = i % (num.length);
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			for (int j = i; j < (num.length + modlength); j++) {
				int modIndex = j % num.length;
				tempList.add(num[modIndex]);
			}
			numList.add(tempList);
		}
		return numList;
	}

}
