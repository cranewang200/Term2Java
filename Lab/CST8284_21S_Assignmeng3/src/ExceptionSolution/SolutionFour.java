package ExceptionSolution;

import java.io.IOException;

/**
 * 
 * Class Name: CST8284-300 
 * Author Name: Ming Wang 
 * Class Name: Assignment 3
 * Date:Aug 7, 2021
 * Description: practice the sequence of the exception.
 */
public class SolutionFour {
	/*start point of the program*/
	public static void main(String[] args) {		
		Exception ex = new Exception();
		IOException ioe = new IOException();		
		try {			
//			throw ex;    //uncomment this line, will catch super class Exception
			throw ioe;  //uncomment this line, will catch subclass IOException
				}
//will show a compile error if uncomment the following code to catch the super class exception first
//			catch (Exception e) {
//			System.out.println("super class Exception is catched");
//			e.printStackTrace();
//		}

		catch (IOException e) {
			System.err.println("sub class IOException is catched");
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println("super class Exception is catched " + e.getMessage());
			e.printStackTrace();
		}
	}

}
