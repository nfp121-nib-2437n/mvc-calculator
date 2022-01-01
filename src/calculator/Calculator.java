
package calculator;


public class Calculator {

   
    public static void main(String[] args) {
      CalculatorView view= new CalculatorView();
      CalculatorModel model=new CalculatorModel();
      CalculatorController c=new CalculatorController(model,view);
    }
    
}
