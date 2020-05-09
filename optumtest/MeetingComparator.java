package optumtest;

import java.util.Comparator;

public class MeetingComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
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

}
