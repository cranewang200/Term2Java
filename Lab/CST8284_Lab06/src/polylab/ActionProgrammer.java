package polylab;

/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Lab 06
 * Date:Jul 19, 2021
 * Description: This class is a subclass of the Programmer class, is used to calculate
 * the action programmer's wage
 */

/**
 * This class override the earning method and toString method from Programmer class.
 *
 */
public class ActionProgrammer extends Programmer{
	private double wage ;
	private int pieces ;
	
	/*constructor with its super class's parameters of constructor and new wage and pieces fields*/
	public ActionProgrammer(String firstName, String lastName, String socialSecurityNumber, int month, int year,
			double wage, int pieces) {
		super(firstName, lastName, socialSecurityNumber, month, year);
		
		if (wage <= 0.0) { // validate 
			  throw new IllegalArgumentException(
			     "wage  must be > 0.0 ");
			}

			if (pieces < 0) { // validate
			  throw new IllegalArgumentException("pieces must be >= 0");
			}
		
		this.wage = wage;
		this.pieces = pieces;
	}



	/*accessor of the wage*/
	public double getWage() {
		return wage;
	}



	/*mutator of the wage*/
	public void setWage(double wage) {
		if (wage <= 0.0) { // validate 
			  throw new IllegalArgumentException(
			     "wage  must be > 0.0 ");
			}
		this.wage = wage;
	}



	/*accessor of the pieces*/
	public int getPieces() {
		return pieces;
	}



	/*mutator of the pieces*/
	public void setPieces(int pieces) {
		if (pieces < 0) { // validate
			  throw new IllegalArgumentException("pieces must be >= 0");
			}
		this.pieces = pieces;
	}



	/*override earning method to calculate the earning*/
	@Override
	public double earnings() {
		double earned = getWage() * getPieces();
		return earned;
	}
	
	/*override earning method to output the information*/
	@Override
	public String toString() {
		String actionProgrammerOutput = "";
		actionProgrammerOutput += "Action programmer :" ;
		actionProgrammerOutput += super.toString()+ "\n";
		actionProgrammerOutput += "wage:" + getWage() +";"+ "pieces:" + getPieces() ;

		return actionProgrammerOutput;
	}

}
