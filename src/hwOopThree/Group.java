package hwOopThree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Group {

	private String groupName;
	private Student[] studens = new Student[10];

	public Group(String groupName, Student[] studens) {
		super();
		this.groupName = groupName;
		this.studens = studens;
	}

	public Group() {
		super();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getStudens() {
		return studens;
	}

	public void setStudens(Student[] studens) {
		this.studens = studens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(studens);
		result = prime * result + Objects.hash(groupName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(groupName, other.groupName) && Arrays.equals(studens, other.studens);
	}

	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", studens=" + Arrays.toString(studens) + "]";
	}

	public void addStudent(Student student) throws GroupOverflowException, StudentExistException {
		
		if( !isEqualStudentPresent(student) ) {
		
			for (int i = 0; i < studens.length; i++) {
				if (studens[i] == null) {
					studens[i] = student;
					return;
				}
			}
			throw new GroupOverflowException();

		} else {
			throw new StudentExistException();
		}
		
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (int i = 0; i < studens.length; i++) {
			if (studens[i] != null) {
				if (studens[i].getLastName().equals(lastName)) {
					return studens[i];
				}
			}
		}
		throw new StudentNotFoundException();
	}

	public boolean removeStudentByID(int id) {

		for (int i = 0; i < studens.length; i++) {
			if (studens[i] != null) {
				if (studens[i].getId() == id) {
					studens[i] = null;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isEqualStudentPresent( Student student ) {
		
		Boolean res = false;
		
		for( Student st : getStudens() ) {
			if( st != null ) {
				if( st.equals(student) ) {
					res = true;
					break;
				}
			}
		}
		
		return res;	
	}
	

	public void sortStudentsByLastName() {
		Arrays.sort(this.studens, Comparator.nullsLast(new StudentsLastNameComparator()));
	}

}
