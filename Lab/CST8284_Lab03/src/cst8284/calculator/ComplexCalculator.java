package cst8284.calculator;


import org.w3c.dom.css.Counter;
/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Lab3
 * Date:June 2, 2021
 *
 *This class include the method to calculate the math. and the method to input date and output 
 * message
 */

public class ComplexCalculator {
	
	private java.util.Scanner op = new java.util.Scanner(System.in);
	private Complex c;  // stores result of current calculation 


	public ComplexCalculator(Complex c1, Complex c2){
		
		System.out.println("Which math operation do you wish to perform?  Enter +, -, *, /");
				
		switch (op.nextLine().charAt(0)){
		   case '+':
		      setComplexResult(add(c1, c2));  
		      break;
		   case '-':
			   setComplexResult(subtract(c1, c2));  
			      break;

		   case '*':
			   setComplexResult(multiply(c1, c2));  
			      break;

		   case '/':
			   setComplexResult(divide(c1, c2));  
			      break;

		   default:
			  System.out.println("Unknown operation requested");
		}		
	}
	
	public ComplexCalculator() {}  // Needed for Lab 4; do not change
	
	public Complex add(Complex c1, Complex c2){
		double real = c1.getReal() + c2.getReal();  // As per the Lab Appendix
		double imag = c1.getImag() + c2.getImag();
		return(new Complex(real, imag));
	}

	
	public Complex subtract(Complex c1, Complex c2){
		double real = c1.getReal() - c2.getReal();  
		double imag = c1.getImag() - c2.getImag();
		return(new Complex(real, imag));

	}
	
	public Complex multiply(Complex c1, Complex c2){
		double real = c1.getReal() * c2.getReal() - c1.getImag() * c2.getImag();  
		double imag = c1.getReal() * c2.getImag() + c2.getReal() * c1.getImag();
		return(new Complex(real, imag));

	}
	
	public Complex divide(Complex c1, Complex c2){	

		//first version of divide method
//		double real;
//		double imag;	
//		if (c2.isZero()){
//			System.out.println("Divide-by-zero error detected");
//			real = 0.0;
//			imag = 0.0;	
//		}else {
//			real = ((c1.getReal() * c2.getReal()) + (c1.getImag() * c2.getImag()))
//					/ ((Math.pow(c2.getReal(),2) + (Math.pow(c2.getImag(),2))));  
//			imag = ((c1.getImag() * c2.getReal()) - (c1.getReal() * c2.getImag())) 
//					/ ((Math.pow(c2.getReal(),2) + (Math.pow(c2.getImag(),2))));
//		}
		
		//second version of divide method
		setComplexResult(multiply(c2, c2.conjugate()));  //first calculate divisor part
		Complex c3 = new Complex(1 / c.getReal(), 0);	//second make 1/divisor to multiplier
		setComplexResult(multiply((multiply(c1, c2.conjugate())), c3)); //use multiply calculate the result
		
		if (c2.isZero()) {
			System.out.println("Divide-by-zero error detected");
			c = new Complex(0,0);		
			
		}
		return c;

	}  
	

	/**
	 * mutator of the Complex. set the object Complex value by parameter passed in
	 * @param c	object Complex value
	 */
	public void setComplexResult(Complex c) {
		this.c = c;

	}
	/**
	 * accessor of the Complex, get the value of object Complex
	 * @return object Complex itself 
	 */
	public Complex getComplexResult(){

		return (c);
	}
	

	/**
	 * this toString method is used to call the toString method of Complex class.
	 */
	public String toString(){
		String str =c.toString();
		return str;

	}
	

}
