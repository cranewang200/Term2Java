package polylab;

public class ActionProgrammer extends Programmer{
	private double wage ;
	private int pieces ;
	
	
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




	public double getWage() {
		return wage;
	}




	public void setWage(double wage) {
		if (wage <= 0.0) { // validate 
			  throw new IllegalArgumentException(
			     "wage  must be > 0.0 ");
			}
		this.wage = wage;
	}




	public int getPieces() {
		return pieces;
	}




	public void setPieces(int pieces) {
		if (pieces < 0) { // validate
			  throw new IllegalArgumentException("pieces must be >= 0");
			}
		this.pieces = pieces;
	}




	@Override
	public double earnings() {
		double earned = getWage() * getPieces();
		return earned;
	}
	
	@Override
	public String toString() {
		String actionProgrammerOutput = "";
		actionProgrammerOutput += "Action programmer :" ;
		actionProgrammerOutput += super.toString()+ "\n";
		actionProgrammerOutput += "wage:" + getWage() +";"+ "pieces:" + getPieces() ;

		return actionProgrammerOutput;
	}

}
