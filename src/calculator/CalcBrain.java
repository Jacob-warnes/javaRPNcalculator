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
    private Stack <Float> fun;
    private String operand;
    public CalcBrain(){
        fun = new Stack();
        operand = "";
    }
    private void emptyOp(){
        operand = "";
    }
    @Override
    public String digit(String digit){
        operand += digit;
        return digit;
    }
    /**
     * An arithmetic operator from the UI.
     * @param op
     * @return The result to display.
     */
    @Override
    public String operator( String op){
       if(!operand.equals("")){ // enterPressed must be called before operator input 
           return "";
       }
        if(fun.size() < 2){ // needs two in stack to calculate 
           return "";
       }
        calculate(op);
        emptyOp();
        return " "+op+"\n"+fun.peek().toString()+" ";
    }
    private void calculate(String op ){
        Float calc = 0.f;
        switch(op){
            case "+":
                calc = fun.pop() + fun.pop();
                fun.push(calc);
                break;
            case "-":
                calc = fun.pop();
                calc = fun.pop() - calc;
                fun.push(calc);
                break;
            case "*":
                calc = fun.pop() * fun.pop();
                fun.push(calc);
                break;
            case "/":
                calc = fun.pop();
                calc = fun.pop() /calc;
                fun.push(calc);
                break;
            case "^":
                calc = toPower(fun.pop(),fun.pop());
                fun.push(calc);
                break;
            default:
                fun.push(calc);
        }        
    }
    private float toPower(float power, float base){
        float holder = 1,f;
        for(; 0.f < power ; power--){
            holder *= base; 
        }
        return holder;
    }
    /**
     * The ClearEntry button on the UI has been pressed
     * so remove any digits typed so far.
     * 
     * @return A calculated value to display. 
     */
    @Override
    public String clearEntry(){
        emptyOp();
        return "\nCleared Digits\n";
    }
   
    /**
     * The Clear button on the UI has been pressed
     * so all memory in the calculator is cleared.
     * 
     * @return A message to display. 
     */
    @Override
    public String clear(){
        emptyOp();
        fun = new Stack();
        return "\nClear All\n";
    }
    /**
     * The Enter button on the UI has been pressed.
     * @return A message to display.
     */
    @Override
    public String enterPressed(){
        if(operand.equals("")){
            return " ";
        }
        fun.push(Float.parseFloat(operand));
        emptyOp();
        return " ";
    }
   
    /**
     * A decimal point on the UI has been pressed.
     * @return A message to display.
     */
    @Override
    public String addDecimal(){
       if(operand.contains(".")){
           return "";
       }
        operand +=".";
        return ".";
    }
    /**
     * The operand sign on the UI is toggled to negative.
     * @return Treat the operand as a negative value.
     */       
      
    
}
