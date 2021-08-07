package ExceptionSolution;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Assignment 3
 * Date:Aug 6, 2021
 * Description: Practice the Exceptions
 */
public class SolutionOne {

 //   ExceptionOne exceptionOne = new ExceptionOne();
  	public static void main(String[] args) {
		//initiate object inner class ExceptionOne
		SolutionOne.ExceptionOne exceptionOne = new SolutionOne().new ExceptionOne();		
     	exceptionOne.inputs();  // call inner class method to catch exception. the inner class will handle the exception

		System.out.println(); //start a new line
		
		  SolutionOne.ExceptionTwo exceptionTwo = new SolutionOne().new ExceptionTwo();		  
		try {
			exceptionTwo.div(5, 0);	 // call inner class method to catch exception. will handle the exception.		
		} catch (Exception e) {
			System.out.println("ExceptionTwo exception is catched");
		}
		
		System.out.println();
		SolutionOne.ExceptionThree exceptionThree = new SolutionOne().new ExceptionThree();
		try {
			exceptionThree.printNull(); // call inner class method to catch exception. will handle the exception.	
		} catch (Exception e) {
			System.out.println();
			System.err.println("ExceptionThree exception is catching");
			System.err.println("Null Point Exception(java.lang.throwable.NullPointerException)");
		}finally {
			System.err.println("ExceptionThree exception is catched");
		}
		System.out.println();
		
		
	}

	
	
	/**
	 * inner class ExceptionOne
	 *
	 */
	public class ExceptionOne extends Exception{
		Scanner scanner = new Scanner(System.in);
		/**
		 * this method will catch and handle a input mismatch exception
		 * use print() to output the message
		 */
		void inputs() {
			System.out.print("input a String to catch exception");
			try {
				int i = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println();
				System.out.println("ExceptionOne exception is catching");
	//			System.out.println("ExceptionOne's exception is "+ e.getMessage());
				e.printStackTrace();			
			}
			finally {
				System.out.println("ExceptionOne exception is catched");
			}
		}		
	}
	
	/**
	 * inner class ExceptionTwo
	 *
	 */
	public class ExceptionTwo extends ExceptionOne{
		
		/**
		 * this method catch and handle the exception (java.lang.ArithmeticException)
		 * use getMessage() to output the message
		 */
		int div(int a, int b){			
			try { 
				int x = a/b;			
			} catch (Exception e) {
				System.out.println("ExceptionTwo exception is catching");
				System.out.println("the second oprand can not be 0");
				System.out.println("getMessage of Exception is :"+e.getMessage());
//				e.printStackTrace();
			}
			return a/b;
		}
	}
	
	/**
	 * inner class ExceptionTwo
	 *
	 */
	public class ExceptionThree extends ExceptionTwo{
		Object object = null;
		/**
		 * this method just throws Exception and don't handle it. 
		 * let other methods which calls this method to handle the exception.
		 * will use the print.err() to output the message
		 */
		void printNull() throws Exception{
				object.toString();
		}
	
		
		
	}
}


