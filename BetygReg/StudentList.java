package BetygReg;

import java.io.*;
import java.util.*;

public class StudentList {

	private String findFile;
	private ArrayList<String> list;
	private ArrayList<String> list2 = new ArrayList<>();
	private boolean loop;
	private Student current;

	public StudentList(){

	}

	public void getRelevant(String cID) throws FileNotFoundException{
		Scanner sc = new Scanner(System.in);
		loop = true;
		//Grade grade = new Grade();		//kolla upp när de ska initieras
		findFile = "studentList.txt";
		//Hämta lista med studenter+betyg
		String content = new Scanner(new File(findFile)).useDelimiter("\\Z").next();
		//Ta bort hakarna
		content = content.substring(1);
		content = content.substring(0, content.length()-1);
		list = new ArrayList<>(Arrays.asList(content.split(", ")));

		//Hämta ut relevanta studenter som läser den valda kursen
		for(int i = 0; i<list.size(); i++){
			String a = ( list.get(i).substring(0, list.get(i).indexOf(" ")));
			if(a.equals(cID)){
				String b = ( list.get(i).substring(list.get(i).indexOf(" ")+1));
				list2.add(b);
			}
		}
		while(loop){
			if(list2.isEmpty()){
				System.out.println("There are no students in this course.");
				break;
			}
			System.out.println(list2);
			System.out.println("Which student would you like to view?");
			//Student ID
			String inputedStudent = sc.nextLine();
			while(!list2.contains(inputedStudent+" u") && !list2.contains(inputedStudent+" g") && !list2.contains(inputedStudent+" vg")){
				System.out.println("That student is not in this course.");
				inputedStudent = sc.nextLine();
			}
			inputedStudent = inputedStudent.toLowerCase();
			//Studentens betyg
			//String relGrade = list2.get(0).substring(9, 10);
			//String relGrade2 = list2.get(0).subtring(11);
			current = new Student(inputedStudent);
			current.alterGrade();
			for(int i = 0; i<list.size(); i++){
				if(list.get(i).contains(cID+" "+inputedStudent)){
					list.set(i, cID+" "+inputedStudent+" "+current.getGrade().getGrade());
				}
			}
			for(int i = 0; i<list2.size(); i++){
				if(list2.get(i).contains(inputedStudent)){
					list2.set(i, inputedStudent+" "+current.getGrade().getGrade());
				}
			}
			//Allt utom "y" och "end" tolkas som nej.
			System.out.println("Do you want to change course? (y/n)\nIf you would like to end the session write \"end\".");
			findFile = sc.nextLine();
			if(findFile.toUpperCase().equals("Y")){
				loop = false;
				list2.clear();
			}
			else if(findFile.toUpperCase().equals("END")){
				current.getGrade().saveGrade(list);
			}
		}
	}
	public ArrayList<String> getList(){
		return list;
	}
	public Student getStudent(){
		return current;
	}
}
