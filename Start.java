package BetygReg;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Start {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		//Hämtar lista över kurser
		while(true){
			System.out.println("username:(1)");
			String user = sc.nextLine();
			System.out.println("password:(1)");
			String pass = sc.nextLine();
			if(user.equals("1") && pass.equals("1")){
				Course.getCourseList();
			}
			else{
				System.out.println("Invalid loggin.");
			}
		}

	}

}
