package optumtest;

import java.util.ArrayList;

public class DuplicateTest {
	
	public static void main(String[] args) {
		//String[] a = {"co","dil","ity" };
		//String[] a= {"abc","yyy","def","csv"};
		//String[] a= {"potato","kayak","banana","racecar"};
		String[] a= {"eva","jqw","tyn","jan"};
		DuplicateTest test = new DuplicateTest() ;
		test.solution(a);
	}
	
	 public int solution(String[] A) {
	        // write your code in Java SE 8
		 ArrayList<String> strList = new ArrayList<String>();
		 for(String str : A) {
			 if(checkUnique(str)) {
				 strList.add(str);
			 }
		 }
		 
		 //System.out.println("Unique List:"+strList);
		 int max= 0;
		 
		 for(int i=0; i < strList.size(); i++) {
			 for(int j=i+1; j < strList.size(); j++) {
				 System.out.println("["+i+" "+j+"]");
				 String concatStr = strList.get(i) + strList.get(j);
				 if(checkUnique(concatStr)) {
					 max = concatStr.length();
					 strList.add(concatStr);
				 }
			 }
		 }
		 
		 //System.out.println("Maximum value :" + max);
		 
		 
		 return max;
	    }
	 
	 public boolean checkUnique(String str) {
		  boolean[] charSet = new boolean[256];
		  boolean status = true;
		  for(int i=0; i < str.length(); i++) {
			 int val = str.charAt(i);
			 if(charSet[val]) {
			     System.out.println("Dupicate Element :" + str.charAt(i));
			     status = false;
			     break;
			 }
			 charSet[val] = true;
		  }
		  
		  return status;
	 }
	 

}
