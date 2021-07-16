

package polylab;


//CommissionProgrammer.java
//CommissionProgrammer class extends Programmer.

public class CommissionProgrammer extends Programmer { 
private double grossSales; // gross weekly sales
private double commissionRate; // commission percentage

//constructor
public CommissionProgrammer(String firstName, String lastName, 
String socialSecurityNumber, int month, int year, 
double grossSales, double commissionRate) {
super(firstName, lastName, socialSecurityNumber, month, year);

if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate 
  throw new IllegalArgumentException(
     "Commission rate must be > 0.0 and < 1.0");
}

if (grossSales < 0.0) { // validate
  throw new IllegalArgumentException("Gross sales must be >= 0.0");
}

this.grossSales = grossSales;
this.commissionRate = commissionRate;
} 

//set gross sales amount on the creation of apps
public void setGrossSales(double grossSales) {
if (grossSales < 0.0) { // validate
  throw new IllegalArgumentException("Gross sales must be >= 0.0");
}

this.grossSales = grossSales;
} 

//return gross sales amount 
public double getGrossSales() {
return grossSales;
} 

//set commission rate
public void setCommissionRate(double commissionRate) {
if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate
  throw new IllegalArgumentException(
     "Commission rate must be > 0.0 and < 1.0");
}

this.commissionRate = commissionRate;
} 

//return commission rate
public double getCommissionRate() {
return commissionRate;
} 

//calculate earnings; override abstract method earnings in Programmer

@Override                                                           
public double earnings() {                                            
return getCommissionRate() * getGrossSales();                    
}                                             

//return String representation of CommissionProgrammer object

  
                                             
//TO DO: COMEPLETE THIS PORTION. Format your solution according to sample output.     
//START     
@Override
	public String toString() {
		String commissionProgrammerOutput = "";
		commissionProgrammerOutput += "commission programmer :" + getFirstName() + " " + getLastName() +"\n";
		commissionProgrammerOutput += "social security number:" + getSocialSecurityNumber()+"\n";
		commissionProgrammerOutput += "birth month and year:" + getBirthDate()+"\n";
		commissionProgrammerOutput += "gross sales:" + getGrossSales() +";"+ "commission rate:" + getCommissionRate();
//		commissionProgrammerOutput += "earned $" + earnings()+"\n";
		return commissionProgrammerOutput;
	}
//END

}

