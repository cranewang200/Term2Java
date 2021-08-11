package ExceptionSolution;

//import java.util.InputMismatchException;
//import java.util.Scanner;
/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Assignment 3
 * Date:Aug 6, 2021
 * Description: Practice the Exceptions. This class I try to practice some try catch exceptions.
 * First part, I try to catch exception for every inner class. 
 * Second part, I initiate 3 objects for 3 inner classes. and create one method for each class to catch a specific exception.
 * The second part need to input any String to catch the input Mismatch Exception.
 */
public class SolutionOne {

 //   ExceptionOne exceptionOne = new ExceptionOne();
  	public static void main(String[] args) {


		//First part. catch 3 inner class exceptions.
		//try catch inner class ExceptionOne
		try {
			 throw new SolutionOne().new ExceptionOne();
			 
		} catch (ExceptionOne e) {
			System.err.println("inner class ExceptionOne");
		
		}
		//try catch inner class ExceptionTwo
		System.out.println();
		try {
			 throw new SolutionOne().new ExceptionTwo();
		} catch (ExceptionOne e) {
			System.err.println("inner class ExceptionTwo");
			e.printStackTrace();
		}
		//try catch inner class ExceptionThree
		System.out.println();
		try {
			 throw new SolutionOne().new ExceptionThree();
		} catch (ExceptionThree e) {
			System.err.println("inner class ExceptionThree");
			System.out.println("message of getMessage is :" + e.getMessage()); //The getMessage() should be null value
		}
		
		
		
		//second part. initiate 3 objects for 3 inner classes. and create one method for each class to catch a specific exception.
		//initiate object inner class ExceptionOne
//		SolutionOne.ExceptionOne exceptionOne = new SolutionOne().new ExceptionOne();
//		SolutionOne.ExceptionTwo exceptionTwo = new SolutionOne().new ExceptionTwo();		
//		SolutionOne.ExceptionThree exceptionThree = new SolutionOne().new ExceptionThree();
		
//		System.out.println();
//     	exceptionOne.inputs();  // call inner class method to catch exception. the inner class will handle the exception
//		System.out.println(); //start a new line
//		
//		  
//		try {
//			exceptionTwo.div(5, 0);	 // call inner class method to catch exception. will handle the exception.		
//		} catch (Exception e) {
//			System.out.println("ExceptionTwo exception is catched");
//		}
//		
//		System.out.println();
//	
//		try {
//			exceptionThree.printNull(); // call inner class method to catch exception. will handle the exception.	
//		} catch (Exception e) {
//			System.out.println();
//			System.err.println("ExceptionThree exception is catching");
//			System.err.println("Null Point Exception(java.lang.throwable.NullPointerException)");
//		}finally {
//			System.err.println("ExceptionThree exception is catched");
//		}
//		System.out.println();
		
		
	}

	
	
	/**
	 * inner class ExceptionOne extends Exception
	 *
	 */
	public class ExceptionOne extends Exception{
//		Scanner scanner = new Scanner(System.in);
		/**
		 * this method will catch and handle a input mismatch exception
		 * use print() to output the message
		 */
//		void inputs() {
//			System.out.print("Input a String to catch more exceptions");
//			try {
//				int i = scanner.nextInt();
//			} catch (InputMismatchException e) {
//				System.out.println();
//				System.out.println("ExceptionOne exception is catching");
//				e.printStackTrace(); //use	printStackTrace() to output the exception message		
//			}
//			finally {
//				System.out.println("ExceptionOne exception is catched");
//			}
//		}		
	}
	
	/**
	 * inner class ExceptionTwo extends ExceptionOne
	 *
	 */
	public class ExceptionTwo extends ExceptionOne{
		
//		/**
//		 * this method catch and handle the exception (java.lang.ArithmeticException)
//		 * use getMessage() to output the message
//		 */
//		int div(int a, int b){			
//			try { 
//				int x = a/b;			
//			} catch (Exception e) {
//				System.out.println("ExceptionTwo exception is catching");
//				System.out.println("the second oprand can not be 0");
//				System.out.println("getMessage of Exception is :"+e.getMessage()); //use getMessage() to output the exception message	
//
//			}
//			return a/b;
//		}
	}
	
	/**
	 * inner class ExceptionThree  extends ExceptionTwo
	 *
	 */
	public class ExceptionThree extends ExceptionTwo{

//		Object object = null;
//		/**
//		 * this method just throws Exception and don't handle it. 
//		 * let other methods which calls this method to handle the exception.
//		 * will use the print.err() to output the message
//		 */
//		void printNull() throws Exception{
//				object.toString();
//		}
//			
//	}
}
}

