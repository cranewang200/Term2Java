package ExceptionSolution;

import java.io.File;
import java.util.Scanner;
/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Assignment 4
 * Date:Aug 7, 2021
 *  Description: Practice the Exceptions
 */
/**
 * outter class SolutionTwo
 */
public class SolutionTwo {

	public static void main(String[] args) {
		//try catch 1 ExceptionBlue
		//use use print() to output the message
		SolutionTwo.ExceptionBlue blue = new SolutionTwo().new ExceptionBlue();
		try {
			blue.addSuppressed(null);
		} catch (Exception e) {
			System.out.println("ExceptionBlue is catching");
			System.out.println("Message of the Exception is ExceptionBlue");
		}finally {
			System.out.println("ExceptionBlue is catched");
		}
		
		//try catch 2 ExceptionYellow
		//use use print.err() to output the message
		System.out.println();
		SolutionTwo.ExceptionYellow yellow = new SolutionTwo().new ExceptionYellow();
		try {
			yellow= null;
			yellow.toString();
		} catch (Exception e) {
			
			System.err.println("ExceptionYellow is catching");
			System.err.println("Message of the Exception is ExceptionYellow");
		}finally {
			System.err.println("ExceptionYellow is catched");
		}
		
		//try catch 3 IOException
		//use use getMessage() to output the message
		System.out.println();
		try {
			Scanner scanner = new Scanner(new File("input.txt"));			
		} catch (Exception e) {
			System.out.println("IOException is catching");
			System.out.println("exception of getMessage() is" + e.getMessage());
		}finally {
			System.out.println("IOException is catched");
		}
		
		//try catch 4 IOException NullPointerException
		//use use printStackTrace() to output the message
		System.out.println();
		Object object = null;
		try {
			object.toString();
		} catch (Exception e) {
			System.err.println("Null Pointer Exception is catching");
			e.printStackTrace();
		}finally {
			System.err.println("Null Pointer Exception is catched");
		}
		
	}
	
	/**
	 * inner class ExceptionBlue
	 */
	public class ExceptionBlue extends Exception{
		
	}

	/**
	 * inner class ExceptionYellow
	 */
	public class ExceptionYellow extends ExceptionBlue{
		
	}
}
