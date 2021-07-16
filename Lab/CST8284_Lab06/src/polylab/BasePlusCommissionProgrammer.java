package polylab;

//Lab 6 - BasePlusCommissionProgrammer.java
//BasePlusCommissionProgrammer class extends CommissionProgrammer.

public class BasePlusCommissionProgrammer extends CommissionProgrammer { 
private double baseSalary; // base salary per week

//constructor
public BasePlusCommissionProgrammer(String firstName, String lastName, 
String socialSecurityNumber, int month, int year, 
double grossSales, double commissionRate, double baseSalary) {
super(firstName, lastName, socialSecurityNumber, 
  month, year, grossSales, commissionRate);

if (baseSalary < 0.0) { // validate baseSalary                  
  throw new IllegalArgumentException("Base salary must be >= 0.0");
}

this.baseSalary = baseSalary;                
}

//set base salary
public void setBaseSalary(double baseSalary) {
if (baseSalary < 0.0) { // validate baseSalary                  
  throw new IllegalArgumentException("Base salary must be >= 0.0");
}

this.baseSalary = baseSalary;                
} 

//return base salary
public double getBaseSalary() {
return baseSalary;
}

//calculate earnings; override method earnings in CommissionProgrammer
@Override                                                            
public double earnings() {                                             
return getBaseSalary() + super.earnings();                        
} 

//return String representation of BasePlusCommissionProgrammer object
   
                                                      
//TO DO: COMEPLETE THIS PORTION. Format your solution according to sample output.     
//START     
@Override
	public String toString() {
	 String basePlusCommissionProgrammerOutput = "";
	 basePlusCommissionProgrammerOutput += "base-salaried commission programmer: " + getFirstName() +" "+ getLastName()+"\n";
	 basePlusCommissionProgrammerOutput += "social security number:" + getSocialSecurityNumber()+"\n";
	 basePlusCommissionProgrammerOutput += "birth month and year:" + getBirthDate()+"\n";
	 basePlusCommissionProgrammerOutput += "gross sales: " + getGrossSales() +"; commission rate:"
			 								+ getCommissionRate() + "; base salary:" + getBaseSalary();
//	 basePlusCommissionProgrammerOutput += "earned $" + earnings()+"\n";
		return basePlusCommissionProgrammerOutput;
	}
//END


}



