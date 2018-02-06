/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author C0381953
 */
import java.util.Stack;
public class CalcBrain implements Calculations {
    /**
     * A single digit from the UI.
     * 
     * @param digit an integer
     * @return The result to display.
     */
    private Stack fun;
    private String op;
    public CalcBrain(){
        fun = new Stack();
        op = "";
    }
    @Override
    public String digit(String digit){
        return digit;
    }
    /**
     * An arithmetic operator from the UI.
     * @param op
     * @return The result to display.
     */
    @Override
    public String operator( String op){
 
        return op;
    }
    /**
     * The ClearEntry button on the UI has been pressed
     * so remove any digits typed so far.
     * 
     * @return A calculated value to display. 
     */
    @Override
    public String clearEntry(){
        fun = new Stack();
        return "";
    }
   
    /**
     * The Clear button on the UI has been pressed
     * so all memory in the calculator is cleared.
     * 
     * @return A message to display. 
     */
    @Override
    public String clear(){
        op = "";
        fun = new Stack();
        return "";
    }
    /**
     * The Enter button on the UI has been pressed.
     * @return A message to display.
     */
    @Override
    public String enterPressed(){
        return " ";
    }
 
    /**
     * A decimal point on the UI has been pressed.
     * @return A message to display.
     */
    @Override
    public String addDecimal(){
        return ".";
    }
    /**
     * The operand sign on the UI is toggled to negative.
     * @return Treat the operand as a negative value.
     */       
      
    
}
