package optumtest;

public class Meeting {
	 int startTime;
	 int endTime;
	 
	 Meeting(String timeslots) {
		String[] temp = timeslots.split("-");		
		startTime = getMinutes(temp[0]);
		endTime = getMinutes(temp[1]);
	 }
	 
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
	public int getMinutes(String time) {
		String[] temp = time.split(":");
		int minutes = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
		return minutes;
	}
	
    public String toString() {
    	return startTime + "-" + endTime;
    }
	 
	 

}
