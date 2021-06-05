
package cst8284.calculator;

import java.awt.Image;

/**
 * 
 * Class Name: CST8284-300 
 * Author Name: Ming Wang 
 * Class Name: Lab3 
 * Date:Jun 2, 2021
 * 
 * This class include 5 different constructors chain together.each constructor
 * called by other constructors with different parameter type. Also include the
 * isZero method and toString method and conjugate method
 *
 */
public class Complex {
	private double real = 0;
	private double imag = 0;

	// Complex constructor that takes in a single string, e.g. "2-4i"
	public Complex(String cStr) {
		this(cStr.split("(?=\\+)|(?=\\-)")); // splits cStr at + or - into an
		// array of strings having two elements. The first element of the
		// resultant array will be the real portion, while the second is the
		// imaginary portion. This array is passed to the next constructor.

	}

	// Complex constructor that takes in an array of two strings from the above
	// constructor e.g. cStr[0]="2", cStr[1]="-4i"
	public Complex(String[] cStr) {
		this(cStr[0], cStr[1]);

	}

	// Complex constructor that takes two separate strings as parameters, e.g. "2" and "-4i"
	public Complex(String r, String i) {
		this(Integer.parseInt(r), Integer.parseInt(i.substring(0, i.length() - 1)));

	}

	// Complex constructor that takes in two ints as parameters, e.g. 2 and -4
	public Complex(int r, int i) {
		this((double) r, (double) i);

	}

	// Complex constructor that takes in two ints and stores them as floats, e.g. as
	// 2.0 and -4.0
	public Complex(double r, double i) {
		setReal(r);
		setImag(i);
	}

	// default Complex constructor; it will chain automatically to the (int, int)
	// constructor
	public Complex() {
		this(0, 0);
	}

	// accessor of real to get the value of real
	public double getReal() {
		return real;
	}

	// mutator of real to set the value of real
	public void setReal(double real) {
		this.real = real;
	}

	// accessor of imag to get the value of imag
	public double getImag() {
		return imag;
	}

	// mutator of imag to set the value of imag
	public void setImag(double imag) {
		this.imag = imag;
	}

	// accessor of the object Complex, get the value which stored in the object
	// Complex
	public Complex getComplex() {
		return this;
	}

	/**
	 * toString method to verify if the imag < 0. if the imag < 0 then output a "-"
	 * before imag.
	 */
	public String toString() {
		String str = "";

		if (getImag() < 0) {
			str = getReal() + "-" + Math.abs(getImag()) + "i";
		} else {
			str = getReal() + "+" + getImag() + "i";
		}

		return str;
	}

	/**
	 * isZeor method to verify the divisor is not zero.
	 * 
	 * @return true means the divisor is zero. false means the divisor is not zero,
	 *         the division can continue
	 */
	public boolean isZero() {

		return ((Math.pow(real, 2) + Math.pow(imag, 2)) == 0);

	}

	/**
	 * conjugate method to get the real value and -imag value, to pass the value to
	 * divide method 
	 * @return object complex (real, - imag)
	 */
	public Complex conjugate() {
		return new Complex(getReal(), -getImag());
	}

}
