
package polylab;


//Programmer abstract superclass.

public abstract class Programmer  {
private final String firstName;
private final String lastName;
private final String socialSecurityNumber;
private final Date birthDate;

//constructor
public Programmer(String firstName, String lastName, 
String socialSecurityNumber, int month, int year) {
this.firstName = firstName;                                    
this.lastName = lastName;                                    
this.socialSecurityNumber = socialSecurityNumber;    
this.birthDate =  new Date(month, year);
} 

public String getFirstName() {
	return firstName;
}

public String getLastName() {
	return lastName;
}

public String getSocialSecurityNumber() {
	return socialSecurityNumber;
}

public Date getBirthDate() {
	return birthDate;
}


//return String representation of Programmer object
@Override
public String toString() {
return String.format("%s %s\n%s: %s\n%s: %s", 
  getFirstName(), getLastName(), 
  "social security number", getSocialSecurityNumber(), 
  "birth month and year", getBirthDate());
} 


/**abstract method must be overridden by concrete subclasses */

public abstract double earnings(); /** No implementation here. DO YOU KNOW WHY? */
//because You don't need to implement a abstract method in a abstract class. It will be
//implemented in its subclass(concrete class). The abstract class is create for regulate the 
//Behavior of the program. It's a must implement method in somewhere of the whole program.
} 


