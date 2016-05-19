package BetygReg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Grade {

	public Grade(){

	}

	public void saveGrade(ArrayList<String> list){
		try {
			File file = new File("studentList.txt");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(list.toString());
			bw.close();

			System.out.println("Grades registered.");

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
}
