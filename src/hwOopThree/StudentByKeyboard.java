package hwOopThree;

import java.util.Scanner;

public class StudentByKeyboard {
		
	
	private String name;
	private String lastName;
	private Gender gender;
	private int id;
	private String groupName;
	
	public StudentByKeyboard( Gender gender ) {
		super();
		this.gender = gender;
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert student name: ");
		this.name = sc.next();
		System.out.println("Insert student last name: ");
		this.lastName = sc.next();
		System.out.println("Insert student id: ");
		this.id = sc.nextInt();
		System.out.println("Insert student group name: ");
		this.groupName = sc.next();
		
		System.out.println(this.toString());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "StudentByKeyboard [name=" + name + ", lastName=" + lastName + ", gender=" + gender + ", id=" + id
				+ ", groupName=" + groupName + "]";
	}

	public void addStudentToGroup( Group group ) {
		Student student  = new Student(this.name, this.lastName, this.gender, this.id, this.groupName);
		try {
			group.addStudent( student );
		} catch (GroupOverflowException | StudentExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
