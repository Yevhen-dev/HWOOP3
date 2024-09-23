package hwOopThree;

import java.util.Comparator;

public class StudentsLastNameComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		
		Student studentOne = ( Student ) o1;
		Student studentTwo = ( Student ) o2;
		
		String studentLastNameOne = studentOne.getLastName();
		String studentLastNameTwo = studentTwo.getLastName();
		
		if( studentLastNameOne.compareTo(studentLastNameTwo) > 0 ) {
			return 1;
		} else if( studentLastNameOne.compareTo(studentLastNameTwo) < 0 ) {
			return -1;
		} else {
			return 0;
		}
	}

	
	
}
