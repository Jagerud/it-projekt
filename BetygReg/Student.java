package BetygReg;
import java.util.*;

public class Student {

	private String ID;
	//private String grade;
	private Grade gradeObject;

	public Student(String id){
		ID = id;
		//grade = grades;
		gradeObject =  new Grade();
		//grade2 = grades2;
	}
	/*public String getGrade(){
		return grade;
	} */
	public void alterGrade(){
		System.out.println("Set grade. (u, g, vg)");
		Scanner sc = new Scanner(System.in);
		gradeObject.setGrade(sc.nextLine().toLowerCase());
		while(!gradeObject.getGrade().equals("g") && !gradeObject.getGrade().equals("vg") && !gradeObject.getGrade().equals("u")){
			System.out.println("Invalid grade.");
			gradeObject.setGrade(sc.nextLine());
		}

	}
	public Grade getGrade(){
		return gradeObject;
	}
}
