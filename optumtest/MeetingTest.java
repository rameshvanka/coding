package optumtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MeetingTest {
	
	public static void main(String[] args) {
		
		MeetingTest mtest =new MeetingTest();
		String S = "Sun 10:00-20:00\nFri 05:00-10:00\nFri 16:30-23:50\nSat 10:00-24:00\nSun 01:00-04:00\nSat 02:00-06:00\nTue 03:30-18:15\nTue 19:00-20:00\nWed 04:25-15:14\nWed 15:14-22:40\nThu 00:00-23:59\nMon 05:00-13:00\nMon 15:00-21:00" ;
				
		String s1 = "Mon 01:00-23:00\nTue 01:00-23:00\nWed 01:00-23:00\nThu 01:00-23:00\nFri 01:00-23:00\nSat 01:00-23:00\nSun 01:00-21:00";		
				
				
				
				
				
				
				
				
				
		mtest.solution(S);
		
	}
	
	
	 public int solution(String S) {
	     Map<String,ArrayList<Meeting>> meetingMap = new HashMap<String,ArrayList<Meeting>>();  
		 Scanner scanner = new Scanner(S);
		 while (scanner.hasNextLine()) {
		  String line = scanner.nextLine();
		  System.out.println("line -->"+line);
		  String[] dayTemp = line.split(" ");
		 
		  Meeting tempMeeting = new Meeting(dayTemp[1]);
		  System.out.println(dayTemp[0] + "  " + tempMeeting);
		  if(meetingMap.containsKey(dayTemp[0])) {
			  meetingMap.get(dayTemp[0]).add(tempMeeting);
		  } else {
			  ArrayList<Meeting> meeting = new ArrayList<Meeting>();
			  meeting.add(tempMeeting);
			  meetingMap.put(dayTemp[0], meeting);
		  }
		 
		 }
		 System.out.println(meetingMap);
		 
		 //sort the map array list
		 Iterator<String> iter = meetingMap.keySet().iterator();
		 while(iter.hasNext()) {
			 String key = iter.next();
			// Collections.sort(meetingMap.get(key),new MeetingComparator());
			 Collections.sort(meetingMap.get(key), new Comparator(){
			       public int compare(Object o1, Object o2) {
			    	Meeting m1 = (Meeting) o1;
			   		Meeting m2 = (Meeting) o2;
			   		if (m1.startTime == m2.startTime) {
			   			return 0;
			   		} else if (m1.startTime > m2.startTime) {
			   			return 1;
			   		} else {
			   			return -1;
			   		}
			        }
			    });
		 }


		 System.out.println("After Sorting");
		 System.out.println(meetingMap);
		 scanner.close();
		 String[] weeks = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
		 int prevTime = 0;
		 int maxTime = 0;
		 int maxDayMin = 1440;
		 
		 for(int i=0; i < weeks.length; i++) {
			 ArrayList<Meeting> dayMeetings = meetingMap.get(weeks[i]);
			// for(Meeting meeting : dayMeetings) {
			   for(int j=0 ; j < dayMeetings.size(); j++) {
				 Meeting meeting = dayMeetings.get(j);
				 int duration = 0;
				 if(prevTime > meeting.startTime) {
					 duration = maxDayMin - prevTime + meeting.startTime;
					 prevTime = meeting.endTime;
				 } else {
					 duration = meeting.startTime - prevTime;
					 prevTime = meeting.endTime;
				 }
				 
				
				 
				 System.out.println("Duration :" + duration);
				 
				 if(duration > maxTime) {
					 maxTime = duration;
					 
					 if(i > 0)
					 System.out.println(weeks[i-1] + ":" + weeks[i]);
				 }
				 
				 //last endTime
				 if(i==weeks.length-1 && j == dayMeetings.size()-1) {
					 int temp = maxDayMin - meeting.endTime;
					 if(temp > maxTime) {
						 maxTime = temp;
					 }
				 }
				 
				 
			 }
		 }
		 
		 System.out.println("MaxTime is"+maxTime);
		 
		 return maxTime;
	 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 
	 

}
