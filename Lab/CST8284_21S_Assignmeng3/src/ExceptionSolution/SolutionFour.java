package ExceptionSolution;

import java.io.IOException;

/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Assignment 3
 * Date:Aug 7, 2021
 *
 */
public class SolutionFour {

	public static void main(String[] args) {

		Exception exception = new Exception();
		
		try {
			exception.addSuppressed(null);
		} catch (Exception e) {
			System.out.println("super class Exception is catching");
			e.printStackTrace();
		}
		
		Exception ioxException = new IOException();
	
		try {

			ioxException = null;
			ioxException.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
