package BetygReg;
import java.util.*;

public class Student {

	private String ID;
	private String grade;

	public Student(String id, String grades){
		ID = id;
		grade = grades;
	}
	public String getGrade(){
		return grade;
	}
	public void setGrade(){
		System.out.println("Set grade. (u, g, vg)");
		Scanner sc = new Scanner(System.in);
		grade = sc.nextLine().toLowerCase();
		while(!grade.equals("g") && !grade.equals("vg") && !grade.equals("u")){
			System.out.println("Invalid grade.");
			grade = sc.nextLine();
		}
	}
}
