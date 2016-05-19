package BetygReg;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Start {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner sc = new Scanner(System.in);

		//Hämtar lista över kurser
		Course co = new Course();

		co.getCourseList();

	}

}
