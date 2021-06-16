package cst8284.junit.lab4;
/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Lab4
 * Date:Jun 16, 2021
 * Decription: this class includes the methods for counter's increment, decrement,
 * addition and subtraction. besides, it includes a toString method to output the result
 */
public class Counter {

	/*
	 * A Counter object stores a count variable
	 * that is >= 0
	 * The counter  can be incremented or decremented
	 * But the stored value should never be negative
	 * It should wrap to zero when it reaches the value Integer.MAX_VALUE
	 */

    private int count;

    /**
     * default constructor with no parameters
     *  Counter with count=0
     */
    public Counter() {
        count = 0;
    }

    /**
     * Constructor with int field, if the passed in value is a negative number
     * it will return 0
     * @param c  Initial value of count
     */
    public Counter(int c) {
    	if(c < 0) {
    		count = 0;
    	}
        count = c;
    }

    /*
     * mutator of the count
     */
    public void setCount(int count) {
		this.count = count;
	}

	/**
     * increment method it is used for increment 1 by its-self
     * and won't return a value is greater than Integer.MAX_VALUE 
     * @return new counter value
     */
    public int increment() {
    	
    	if(count >= Integer.MAX_VALUE  ) {
    		return 0;
    	}
    	
    	return ++count;
   
    }

    /**
     * decrement method it is used for decrement 1 by its-self
     * and won't return a negative number 
     * @return new counter value
     */
    public int decrement() {
    	
    	if (count <= 0) {
    		return 0;
    	}
    	
        return --count;
    }

    /**
     * 
     * accessor of the count
     * @return counter value
     */
    public int getCount() {
        return count;
    }

    /**
     * this method is used to get the result of addition of 2 numbers 
     * first it will verify the result is not greater than Integer.MAX_VALUE
     * then do the addition and return the result
     * If the result is greater than Integer.MAX_VALUE. it will return a new default constructor
     * with count = 0
     * @param c the second object which passed in
     * @return new object of the addition result
     */
    public Counter add(Counter c) {
    	long result = ((long)this.count + (long)c.count);
    	if (result >= Integer.MAX_VALUE) {
    		return new Counter();
    	}
    	
        return new Counter(this.count + c.count);
    }

    /**
     * this method is used to get the result of subtraction of 2 numbers 
     * first it will verify the result is not a negative number
     * then do the subtraction and return the result
     * If the result is a negative number. it will return a new default constructor
     * with count = 0
     * @param c the second object which passed in
     * @return new object of the subtraction result
     */
    public Counter sub(Counter c) {    	
    	if((this.count - c.count) <= 0) {
    		return new Counter();
    	}else {
    		return new Counter(this.count - c.count);
    	}
    }
       
  
    /**
     * This method is used to output the formated result to the console
     *
     * @return a string representation of this counter
     */
    public String toString() {
        return "Count is " + count ;
    } 
  

}
