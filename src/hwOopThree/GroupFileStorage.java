package hwOopThree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GroupFileStorage {

	public void saveGroupToCSV(Group gr) {

		try (BufferedWriter groupCSV = new BufferedWriter(new FileWriter("group" + gr.getGroupName() + ".csv"))) {

			for (Student student : gr.getStudens()) {
				if (student != null) {
					String str = student.getName() + ";" + student.getLastName() + ";" + student.getGender() + ";"
							+ student.getId() + ";" + student.getGroupName();
					groupCSV.write(str);
					groupCSV.newLine();
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Group loadGroupFromCSV(File file) {

		Group group = new Group();

		String groupName = file.getName().split("group")[1].replaceAll(".csv", "");
		group.setGroupName(groupName);

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String line;
			while ((line = br.readLine()) != null) {

				String name = line.split(";")[0];
				String lastName = line.split(";")[1];
				String gender = line.split(";")[2];
				String id = line.split(";")[3];
				String gName = line.split(";")[4];

				if (gender.equals("M")) {
					Student student = new Student(name, lastName, Gender.M, Integer.parseInt(id), gName);
					try {
						group.addStudent(student);
					} catch (GroupOverflowException | StudentExistException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					Student student = new Student(name, lastName, Gender.W, Integer.parseInt(id), gName);
					try {
						group.addStudent(student);
					} catch (GroupOverflowException | StudentExistException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return group;

	}

	public File findFileByGroupName(String groupName, File workFolder) throws FileNotFoundException {

		File[] list = workFolder.listFiles();
		for (File groupFile : list) {
			if (groupFile.isFile()) {
				if (groupFile.getName().endsWith(".csv")) {
					if ((groupFile.getName().split("group")[1].replaceAll(".csv", "").toUpperCase())
							.equals(groupName.toUpperCase())) {
						return groupFile;
					} else {
						throw new FileNotFoundException();
					}
				}
			}
		}

		return null;
	}

}
