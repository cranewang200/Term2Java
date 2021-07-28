package polylab.lab7;


// LAB 7: YOU ARE REQUIRED TO MODIFY THIS CODE!!!

//Programmer.java

//Programmer - This is an abstract superclass that IMPLEMENTS the Payme interface.

//SOME MODIFICATION ARE REQUIRED IN THIS SECTION OF YOUR HERE - LOOK CLOSELY!!!

public abstract class Programmer implements Payme{

private String firstName;
private String lastName;
private String socialSecurityNumber;
//private int month;
//private int year;

//three-argument constructor
public Programmer(String first, String last, String ssn) {

 firstName = first;
 lastName = last;
 socialSecurityNumber = ssn;
}

//public Programmer(String firstName, String lastName, 
//String socialSecurityNumber, int month, int year) {
//	
//this.firstName = firstName;                                    
//this.lastName = lastName;                                    
//this.socialSecurityNumber = socialSecurityNumber;    
//this.month =  month;
//this.year = year;
//} 


/** CHANGES ARE REQUIRED IN THIS SECTION. 
* THINK OF THE BEST WAY TO ACCESS PRIVATE VARIABLES.
* IN THIS PORTION OF YOUR CODE INCLUDE ALL OF SUCH THAT APPLIES.
*/





//return String representation of Programmer object
@Override
public String toString() {
	System.out.println();
return String.format("%s %s\n%s:%s ", 
  getFirstName(), getLastName(), "social security number",getSocialSecurityNumber());
} 


//Note: We do NOT implement Payme method getPaymentAmount() here. 
// THEREFORE, TO AVOID A COMPILATION ERROR, YOU SHOULD DECLARE THIS CLASS AS....??
@Override
	public abstract double getPaymentAmount() ;




public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getSocialSecurityNumber() {
	return socialSecurityNumber;
}

public void setSocialSecurityNumber(String socialSecurityNumber) {
	this.socialSecurityNumber = socialSecurityNumber;
}

//public abstract double earnings(); /** No implementation here. DO YOU KNOW WHY? What should this method be?*/
} 


