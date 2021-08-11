package ExceptionSolution;
/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Assignment 3
 * Date:Aug 7, 2021
 * Description: Practice the Exceptions
 */

/**
 *Exception practice
 */
public class SolutionThree {
	/*start point of the program*/
	public static void main(String[] args) {
		try {
			courseStarting();
		} catch (Exception e) {
			System.out.println("Rethrowing an exception");
			System.err.println("Exception message from getMessage() is " + e.getMessage());
			e.printStackTrace() ;
		}finally {
			System.out.println("Rethrow an exception done ");
		}

	}
	
	// throw the exception back to  courseStarting() method
	static void courseEnding() throws Exception{
		 throw new Exception("Exceptiong thrown in courseEnding()");
		
	}
	// call courseEnding() method; rethrow exceptions back to main method
	static void  courseStarting() throws Exception{		
		courseEnding();
	}
}
