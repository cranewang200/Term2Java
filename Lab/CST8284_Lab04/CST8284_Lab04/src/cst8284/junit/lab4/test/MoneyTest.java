package cst8284.junit.lab4.test;

import java.math.BigDecimal;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import org.junit.Before;
import org.junit.Test;

import cst8284.junit.lab4.Currency;
import cst8284.junit.lab4.Money;


public class MoneyTest {

    private static final BigDecimal PRICE = new BigDecimal("47");
    private Currency currency;
    private Money money;
	private static final BigDecimal DIFFERENT_PRICE = new BigDecimal("1337");

    @Before
    public void initMoney() throws Exception {
        currency = new Currency("USD");
        money = new Money(PRICE, currency);
    }

    @Test
    public void testGetPrice_True() {
    	
    	BigDecimal result = money.getPrice();
    	
    	assertTrue(result == PRICE);
    	

    }
    
    @Test
    public void testGetPrice_False() {
    	
    	BigDecimal result = money.getPrice();
    	
    	assertFalse(result == DIFFERENT_PRICE);
    	
    }

    @Test
    public void testGetCurrency_True() {
    	
    	Currency result = money.getCurrency();
    	
    	assertTrue(result.equals(currency));
    	

    }

    @Test
    public void testGetCurrency_False() {
    	Currency result = money.getCurrency();
    	
    	assertFalse(!result.equals(currency));
    	

    }
    
    @Test
    public void testEquals_WhenEquals() {
        Money secondMoney = new Money(PRICE, currency);
        assertTrue(money.equals(secondMoney));
        
        //test when two money object has the same price and currency, then they are equals
    }

    @Test
    public void testEquals_WhenNotEquals() {

    	Money secondMoney = new Money(DIFFERENT_PRICE, currency);
    	assertFalse(money.equals(secondMoney));
    	assertFalse(money.hashCode() == secondMoney.hashCode());
 
    	// Create another money object 
    	// Verify that the hash code for money is different
    	// from the hash code of this new object

    }

    @Test
    public void testHashCode_Equal() {
    	

    	Money secondMoney = new Money(PRICE, currency);
    	
    	assertTrue(money.hashCode() == secondMoney.hashCode());
    	
    	// Create a money object  with a same currency
    	// Verify that the hash code for money is same
    	// from the hash code of this new object

    }
    
    @Test
    public void testHashCode_NotEqual() {
    	
    	Money secondMoney = new Money(DIFFERENT_PRICE, currency);
    	
    	assertFalse(money.hashCode() == secondMoney.hashCode());

    }
    
    @Test
    public void testHashCode() {
    	    	
    	assertTrue(money.hashCode() == PRICE.hashCode() + currency.hashCode());
    	
    	//test hashCode method , the result == price.hashCode + currency.hashCode
    	
    }
    
}
