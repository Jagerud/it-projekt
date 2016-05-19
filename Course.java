package BetygReg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Course {

	private static String findFile;
	private static ArrayList<String> list; 

	public static void getCourseList() throws FileNotFoundException{
		Scanner sc = new Scanner(System.in);
		//Hämtar listan över kurser
		findFile = "courseID.txt";
		String content = new Scanner(new File(findFile)).useDelimiter("\\Z").next();
		//Filens innehåll --> array
		list = new ArrayList<String>(Arrays.asList(content.split("\n")));
		while(true){
			System.out.println(list);
			System.out.println("Which course would ou like to view?\nIf you would like to end the session write \"end\".");
			//Välj relevant kurs
			String cID = sc.nextLine();
			cID = cID.toUpperCase();
			if(cID.toUpperCase().equals("END")){
				if(StudentList.getList()==null){
					System.exit(1);
				}
				Grade.saveGrade(StudentList.getList());
			}
			//Hämta studenter
			if(list.contains(cID)){
				StudentList.getRelevant(cID);
			}
			else{
				System.out.println("ERROR 404! Course not found.");
			}
		}
	}
}
