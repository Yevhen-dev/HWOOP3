package hwOopThree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Group {

	private String groupName;
	private ArrayList<Student> studens = new ArrayList<Student>();

	public Group(String groupName, ArrayList<Student> studens) {
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

	public ArrayList<Student> getStudens() {
		return studens;
	}

	public void setStudens(ArrayList<Student> studens) {
		this.studens = studens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupName, studens);
	}

	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", studens=" + studens + "]";
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
		return Objects.equals(groupName, other.groupName) && Objects.equals(studens, other.studens);
	}

	public void addStudent(Student student) throws GroupOverflowException, StudentExistException {

		if (!isEqualStudentPresent(student)) {

			if (studens.size() < 10) {
				studens.add(student);
			} else {
				throw new GroupOverflowException();
			}

		} else {
			throw new StudentExistException();
		}

	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (Student student : studens) {
			if (student.getLastName().equals(lastName)) {
				return student;
			}
		}

		throw new StudentNotFoundException();
	}

	public boolean removeStudentByID(int id) {

		for (Student student : studens) {
			if (student.getId() == id) {
				studens.remove(student);
				return true;
			}
		}
		return false;
	}

	public boolean isEqualStudentPresent(Student student) {

		return studens.contains(student);

	}

	public void sortStudentsByLastName() {
		studens.sort(new StudentsLastNameComparator());
	}

}
