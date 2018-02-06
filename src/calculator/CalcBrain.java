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
    private String op;
    public CalcBrain(){
        fun = new Stack();
        op = "";
    }
    @Override
    public String digit(String digit){
        op += digit;
        return digit;
    }
    /**
     * An arithmetic operator from the UI.
     * @param op
     * @return The result to display.
     */
    @Override
    public String operator( String op){
       if(fun.empty()){
           return "error no values";
       }
        this.op = op;
        calculate();
        return op+" "+fun.peek().toString()+"\n";
    }
    private void calculate( ){
        Float calc = 0.f;
        switch(this.op){
            case "+":
                calc = fun.pop() + fun.pop();
                fun.push(calc);
                break;
            case "-":
                calc = fun.pop() + fun.pop();
                fun.push(calc);
                break;
            case "*":
                calc = fun.pop() * fun.pop();
                fun.push(calc);
                break;
            case "/":
                calc = fun.pop() / fun.pop();
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
    private float toPower(float base, float power){
        float holder = 0;
        for(; 0.f >= power ; power--){
            base *= base; 
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
        op = "";
        return "\nCleared digits\n";
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
        return "\nMemory cleared\n";
    }
    /**
     * The Enter button on the UI has been pressed.
     * @return A message to display.
     */
    @Override
    public String enterPressed(){
        if(op.equals("")){
            return " ";
        }
        fun.push(Float.parseFloat(op));
        op = "";
        return " ";
    }
   
    /**
     * A decimal point on the UI has been pressed.
     * @return A message to display.
     */
    @Override
    public String addDecimal(){
        op +=".";
        return ".";
    }
    /**
     * The operand sign on the UI is toggled to negative.
     * @return Treat the operand as a negative value.
     */       
      
    
}
