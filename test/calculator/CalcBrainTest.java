package calculator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JavaDeveloper
 */
public class CalcBrainTest {
    
    public CalcBrainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of digit method, of class CalcBrain.
     */
@Test
    public void testDigit() {
        System.out.println("Testing digits");
        
        // Declare a sample test digit.
        String enterDigit = "3";
        
        // Instantiate the CalcBrain object.
        Calculations instance = new CalcBrain();
        
        String expectedResult = "3";
        
        // Call the CalcBrain method digit to insert "3"
        String result = instance.digit(enterDigit);
        
        // Check that the "3" is returned from CalcBrain's digit method.
        assertEquals(expectedResult, result);        
    }
     @Test
    public void myTest() {
        System.out.println("Testing my test as entered: 2 3+ 5- 8 7+ 2*");
        String enterFirstDigit = "2";
        String enterSecondDigit = "3";
        String enterThirdDigit = "5";
        String enterFourthDigit = "8";
        String enterFithDigit = "7";
          
        String enterOperator = "+";
        String enterMinusOperator = "-";
        String enterMultiplyOperator = "*";
        Calculations instance = new CalcBrain();
        instance.digit(enterFirstDigit);
        instance.enterPressed();
        instance.digit(enterSecondDigit); 
        instance.enterPressed();
        instance.operator(enterOperator);
        
        instance.digit(enterThirdDigit);
        
        instance.operator(enterMinusOperator);
        
         instance.digit(enterFourthDigit);
         instance.enterPressed();
        instance.digit(enterFithDigit);
         instance.operator(enterOperator);
        
        instance.enterPressed();
        instance.digit(enterFirstDigit);
        
        
        String result = instance.operator(enterMultiplyOperator);
        String expectedResult = " *\n30.0 ";
        
        float delta = 0.0f;
         assertEquals(Float.parseFloat(expectedResult.replaceAll("^[^\\n]*\\n",""))
                   , Float.parseFloat(result.replaceAll("^[^\\n]*\\n",""))
                    ,delta);    
    }

    @Test
    public void testAddTwoNumbers() {
        System.out.println("Testing addition");
        String enterFirstDigit = "3";
        String enterSecondDigit = "2";
        String enterOperator = "+";
        Calculations instance = new CalcBrain();
        instance.digit(enterFirstDigit);
        instance.enterPressed();
        instance.digit(enterSecondDigit);
         instance.enterPressed();
        String result = instance.operator(enterOperator);

        String expectedResult = " +\n5.0 ";
        
        float delta = 0.0f;
        assertEquals(Float.parseFloat(expectedResult.replaceAll("\\s",""))
                   , Float.parseFloat(result.replaceAll("\\s",""))
                    ,delta);        
    }

        @Test
    public void testAddThreeNumbers() {
        System.out.println("Testing addition");
        String enterFirstDigit = "3";
        String enterSecondDigit = "2";
        String enterThirdDigit = "4";
        String enterOperator = "+";
        Calculations instance = new CalcBrain();
        instance.digit(enterFirstDigit);
        instance.enterPressed();
        instance.digit(enterSecondDigit);
        instance.enterPressed();
        instance.digit(enterThirdDigit);
        instance.enterPressed();
        
        String result = instance.operator(enterOperator);
        instance.enterPressed();
        result = instance.operator(enterOperator);
        
        String expectedResult = " +\n9.0 ";
        
        float delta = 0.0f;
        assertEquals(Float.parseFloat(expectedResult.replaceAll("\\s",""))
                   , Float.parseFloat(result.replaceAll("\\s",""))
                    ,delta);        
    }
    
        @Test
    public void testSubtractThreeNumbers() {
        System.out.println("Testing subtraction");
        String enterFirstDigit = "3";
        String enterSecondDigit = "5";
        String enterThirdDigit = "1";
        String enterOperator = "-";
        Calculations instance = new CalcBrain();
        instance.digit(enterFirstDigit);
        instance.enterPressed();
        instance.digit(enterSecondDigit);
        instance.enterPressed();
        instance.digit(enterThirdDigit);
         instance.enterPressed();
        
        String result = instance.operator(enterOperator);
        result = instance.operator(enterOperator);
        
        String expectedResult = " -\n-1.0 ";
        
        float delta = 0.0f;
        
        // Strip out the prefix " -\n" text part of the strings.
        
        assertEquals(Float.parseFloat(expectedResult.replaceAll("^[^\\n]*\\n",""))
                   , Float.parseFloat(result.replaceAll("^[^\\n]*\\n",""))
                    ,delta);        
    }    

    @Test
    public void testSubtractTwoNumbers() {
        System.out.println("Testing subtraction");
        String enterFirstDigit = "3";
        String enterSecondDigit = "2";
        String enterOperator = "-";
        Calculations instance = new CalcBrain();
        instance.digit(enterFirstDigit);
        instance.enterPressed();
        instance.digit(enterSecondDigit);
         instance.enterPressed();
        
        String result = instance.operator(enterOperator);
        
        String expectedResult = " -\n1.0 ";
        
        float delta = 0.0f;
        
        // Strip out the prefix " -\n" text part of the strings.
        
        assertEquals(Float.parseFloat(expectedResult.replaceAll("^[^\\n]*\\n",""))
                   , Float.parseFloat(result.replaceAll("^[^\\n]*\\n",""))
                    ,delta);        
    }  
    
       @Test
    public void testAddTwoDecimals() {
        System.out.println("Testing decimal addition");
        String enterOperator = "+";
        
        Calculations instance = new CalcBrain();
        instance.digit("3");
        instance.addDecimal();
        instance.digit("1");
        instance.enterPressed();
        instance.digit("2");
        instance.addDecimal();
        instance.digit("9");
        
        instance.enterPressed();
        
        String result = instance.operator(enterOperator);
        
        String expectedResult = " +\n6.0 ";
        
        float delta = 0.0f;
        
        // Strip out the prefix " -\n" text part of the strings.
        
        assertEquals(Float.parseFloat(expectedResult.replaceAll("^[^\\n]*\\n",""))
                   , Float.parseFloat(result.replaceAll("^[^\\n]*\\n",""))
                    ,delta);        
    }    
    
    @Test
    public void testClearAllPressed() {
        System.out.println("Testing clear all button");
        String enterFirstDigit = "3";
        String enterSecondDigit = "5";
        String enterOperator = "+";
        
        Calculations instance = new CalcBrain();
        instance.digit(enterFirstDigit);
        instance.enterPressed();
        instance.digit(enterSecondDigit);
        
        String clearResult = instance.clear();
        
        String result = instance.operator(enterOperator);
        
        String expectedClearResult = "\nClear All\n";               
        
        assertTrue( expectedClearResult.equalsIgnoreCase(clearResult));
        assertTrue( result.equals(""));
    }        
    
    @Test
    public void testClearEntryPressed() {
        System.out.println("Testing clear entry button");
        String enterFirstDigit = "3";
        String enterSecondDigit = "5";
        String enterThirdDigit = "4";
        
        String enterOperator = "+";
        
        Calculations instance = new CalcBrain();
        instance.digit(enterFirstDigit);
        instance.enterPressed();
        
        instance.clearEntry();
        
        instance.digit(enterSecondDigit);
         instance.enterPressed();
        instance.enterPressed();
        
        instance.digit(enterThirdDigit);
         instance.enterPressed();
        
        String result = instance.operator(enterOperator);
        
        String expectedResult = " +\n9.0 ";
        
        float delta = 0.0f;
        assertEquals(Float.parseFloat(expectedResult.replaceAll("\\s",""))
                   , Float.parseFloat(result.replaceAll("\\s",""))
                    ,delta);        
    }      
    
    @Test
    public void testMultiplyTwoDecimals() {
        System.out.println("Testing multiply decimals");
        String enterOperator = "*";
        
        Calculations instance = new CalcBrain();
        instance.digit("3");
        instance.addDecimal();
        instance.digit("1");
        instance.enterPressed();
        instance.digit("2");
        instance.addDecimal();
        instance.digit("9");
        
        instance.enterPressed();
        
        String result = instance.operator(enterOperator);
        
        String expectedResult = " +\n8.99 ";
        
        float delta = 0.0f;
        
        // Strip out the prefix " -\n" text part of the strings.
        
        assertEquals(Float.parseFloat(expectedResult.replaceAll("^[^\\n]*\\n",""))
                   , Float.parseFloat(result.replaceAll("^[^\\n]*\\n",""))
                    ,delta);        
    }   
    
    @Test
    public void testDivideTwoNumbers() {
        System.out.println("Testing division");
        String enterOperator = "/";
        
        Calculations instance = new CalcBrain();
        instance.digit("3");
        instance.digit("1");
        instance.enterPressed();
        instance.digit("2");
        
        instance.enterPressed();
        
        String result = instance.operator(enterOperator);
        
        String expectedResult = " +\n15.5 ";
        
        float delta = 0.0f;
        
        // Strip out the prefix " -\n" text part of the strings.
        
        assertEquals(Float.parseFloat(expectedResult.replaceAll("^[^\\n]*\\n",""))
                   , Float.parseFloat(result.replaceAll("^[^\\n]*\\n",""))
                    ,delta);        
    }        
    @Test
    public void testPowerOf() {
        System.out.println("Testing exponent");
        String enterOperator = "^";
        
        Calculations instance = new CalcBrain();
        instance.digit("3");
        instance.enterPressed();
        instance.digit("2");
        
        instance.enterPressed();
        
        String result = instance.operator(enterOperator);
        
        String expectedResult = " +\n9.0 ";
        
        float delta = 0.0f;
        
        // Strip out the prefix " -\n" text part of the strings.
        
        assertEquals(Float.parseFloat(expectedResult.replaceAll("^[^\\n]*\\n",""))
                   , Float.parseFloat(result.replaceAll("^[^\\n]*\\n",""))
                    ,delta);        
    }
    @Test
    public void testExpression() {
        System.out.println("Testing expression 2+(5*3)-(2^4-3)/6"); 

        Calculations instance = new CalcBrain();
        instance.digit("2");
        instance.enterPressed();
        instance.digit("5");
        instance.enterPressed();
        instance.digit("3");
        instance.enterPressed();
        instance.operator("*");
        instance.operator("+");
        instance.digit("2");
        instance.enterPressed();
        instance.digit("4");
         instance.enterPressed();
        instance.operator("^");
        instance.digit("3");
         instance.enterPressed();
        instance.operator("-");
        instance.digit("6");
         instance.enterPressed();
        instance.operator("/");
        
        String result = instance.operator("-");
                
        String expectedResult = " +\n14.83333 ";
        
        float delta = 0.0001f;
        
        // Strip out the prefix " -\n" text part of the strings.
        
        assertEquals(Float.parseFloat(expectedResult.replaceAll("^[^\\n]*\\n",""))
                   , Float.parseFloat(result.replaceAll("^[^\\n]*\\n",""))
                    ,delta);        
    }            
    
}
