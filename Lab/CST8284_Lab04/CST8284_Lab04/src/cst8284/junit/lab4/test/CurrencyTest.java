package cst8284.junit.lab4.test;

import cst8284.junit.lab4.Currency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {

    private static final String MONEY_CODE = "USD";
    private static final String DIFFERENT_MONEY_CODE = "CAD";
    private Currency currency;

	//construct the new object before testing
    @Before
    public void initCurrency() {
        currency = new Currency(MONEY_CODE);      
    }
   
    //test the accessor of abbreviation with same money code
    @Test
    public void testGetAbbreviation_True() {
           
        String result = currency.getAbbreviation();

        assertEquals(MONEY_CODE, result);
    }

   //test the accessor of abbreviation with different money code
    @Test
    public void testGetAbbreviation_False() {
        String result = currency.getAbbreviation();

        assertFalse(DIFFERENT_MONEY_CODE.equals(result));
    }
    
    //test the equals method with same money code
    @Test
    public void testEquals_WhenEquals() {
        Currency secondCurrency = new Currency(MONEY_CODE);
        
        Currency result = currency;
        assertEquals(result, secondCurrency);
        
    }

    //test the equals method with different money code
    @Test
    public void testEquals_WhenNotEquals() {
        Currency secondCurrency = new Currency(DIFFERENT_MONEY_CODE);
        
        Currency result = currency;
        assertFalse(result.equals(secondCurrency));

        
    }

    //test the hashcode method with same money code
    @Test
    public void testHashCode_True() {
        Currency secondCurrency = new Currency(MONEY_CODE);

        int firstHash = currency.hashCode();
        int secondHash = secondCurrency.hashCode();

        assertEquals(firstHash, secondHash);
    }
    
    //test the hashcode method with different money code
    @Test
    public void testHashCode_False() {
        Currency secondCurrency = new Currency(DIFFERENT_MONEY_CODE);
        
        int firstHash = currency.hashCode();
        int secondHash = secondCurrency.hashCode();

        assertFalse(firstHash == secondHash);
    	
    }
  
    
}

