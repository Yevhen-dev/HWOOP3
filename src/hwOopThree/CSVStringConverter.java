package hwOopThree;

import java.util.Iterator;

public class CSVStringConverter implements StringConverter {

	@Override
	public String toStringRepresentation(Student student) {
		
		if( student != null ) {
			String studentCSV = student.getName() + ";" + student.getLastName() + ";" + student.getGender() + ";" + student.getId() + ";" + student.getGroupName();
			return studentCSV;
		}
		
		return null;
	}

	@Override
	public Student fromStringRepresentation(String str) {
		
		String[] arr = str.split(";");
		
		if( arr[2].toUpperCase().equals("M") ) {
			Student student = new Student(arr[0], arr[1], Gender.M, Integer.parseInt(arr[3].trim()), arr[4]);
			return student;
		} else {
			Student student = new Student(arr[0], arr[1], Gender.W, Integer.parseInt(arr[3].trim()), arr[4]);
			return student;
		}
		
		
	}

}
