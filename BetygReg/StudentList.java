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
		list = new ArrayList<String>(Arrays.asList(content.split(", ")));

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
			String rel = sc.nextLine();
			while(!list2.contains(rel+" u") && !list2.contains(rel+" g") && !list2.contains(rel+" vg")){
				System.out.println("That student is not in this course.");
				rel = sc.nextLine();
			}
			rel = rel.toLowerCase();
			//Studentens betyg
			String relGrade = list2.get(0).substring(9, 10);
			//String relGrade2 = list2.get(0).subtring(11);
			current = new Student(rel, relGrade);
			current.alterGrade();
			for(int i = 0; i<list.size(); i++){
				if(list.get(i).contains(cID+" "+rel)){
					list.set(i, cID+" "+rel+" "+current.getGrade().getGrade());
				}
			}
			for(int i = 0; i<list2.size(); i++){
				if(list2.get(i).contains(rel)){
					list2.set(i, rel+" "+current.getGrade().getGrade());
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
