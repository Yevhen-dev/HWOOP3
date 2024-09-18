package hwOopThree;

public class Main {


	public static void main(String[] args) {
		
		Student ivan = new Student("Ivan", "Dub", Gender.M, 2, "ATC");
		Student mark = new Student("Mark", "Lub", Gender.M, 3, "ATC");
		Student ira = new Student("Ira", "Koi", Gender.W, 6, "ATC");
		Student katia = new Student("Katia", "Malo", Gender.W, 8, "ATC");
		Student liam = new Student("Liam", "Bur", Gender.M, 12, "ATC");
		Student tito = new Student("Tito", "Som", Gender.M, 32, "ATC");
		Student nastia = new Student("Nastia", "Cat", Gender.W, 25, "UPP");
		Student kate = new Student("Kate", "Dog", Gender.W, 277, "ATC");
		Student craig = new Student("Craig", "Fox", Gender.M, 221, "UPP");
		Student luci = new Student("Luci", "Turner", Gender.W, 257, "ATC");
		Student nata = new Student("Nata", "Tui", Gender.W, 35, "ATC");
		Student yura = new Student("Yura", "Nam", Gender.M, 78, "ATC");
		
		
		Student domin = new Student("Domin", "Pop", Gender.M, 56, "UPP");
		Student ryan = new Student("Ryan", "Quenn", Gender.M, 41, "ATC");
		Student cortnie = new Student("Cortnie", "Lilo", Gender.W, 21, "UPP");
		Student lilia = new Student("Lilia", "Vac", Gender.W, 792, "UPP");
		Student vadim = new Student("Vadim", "Dert", Gender.M, 52, "ATC");
		Student simon = new Student("simon", "Yello", Gender.M, 92, "UPP");
		
		Group atc = new Group();
		atc.setGroupName("ATC");
		try {
			atc.addStudent(ivan);
			atc.addStudent(mark);
			atc.addStudent(ira);
			atc.addStudent(katia);
			atc.addStudent(liam);
			atc.addStudent(tito);
			atc.addStudent(kate);
			atc.addStudent(luci);
			atc.addStudent(nata);
			atc.addStudent(yura);
//			atc.addStudent(ryan);
//			atc.addStudent(vadim);
		} catch (GroupOverflowException e) {
			e.printStackTrace();
		}
		System.out.println(atc);
		
		System.out.println(atc.removeStudentByID(12));
		
		System.out.println(atc);
		
		System.out.println();
		
		try {
			System.out.println( atc.searchStudentByLastName("Mala") );
		} catch (StudentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		
		System.out.println(ivan);

	}

}
