
package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculatorController {
    CalculatorModel m;
    CalculatorView v;
    CalculatorController(CalculatorModel model,CalculatorView v){
        this.m=model;
        this.v=v;
        this.v.addListener(new CalcListener());
    }
    CalculatorController(){
        
    }
    public CalcListener getListener(){
        return new CalcListener();
    }
    public class CalcListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
          switch(e.getActionCommand()){
              case "1": addNumsToModel(1);break;
              case "2": addNumsToModel(2);break;
              case "3": addNumsToModel(3);break;
              case "4": addNumsToModel(4);break;
              case "5": addNumsToModel(5);break;
              case "6": addNumsToModel(6);break;
              case "7": addNumsToModel(7);break;
              case "8": addNumsToModel(8);break;
              case "9": addNumsToModel(9);break;
              case "C": m.setNum1(0);m.setNum2(0);m.result=0;v.ecran.setText("");break;
              case "+": 
                  AjoutPlusDesNombres('+');
                v.ecran.setText(m.getNum1()+"+"); break;
              case "-": 
               AjoutPlusDesNombres('-');
               v.ecran.setText(m.getNum1()+"-");break;
              case "*": 
                  AjoutPlusDesNombres('*');
               v.ecran.setText(m.getNum1()+"*");break;
              case "/": 
                  AjoutPlusDesNombres('/');
                v.ecran.setText(m.getNum1()+"/");break;
              case "=": 
                  m.calculate();v.ecran.setText(m.result+"");break;
          }
         
          
        }
    }
    public void addNumsToModel(int n){
            //si l'ope est + ou - ou * ou / cela veut dire qu'il faut remplir num2
            if(m.getOp()!='x'){
            m.setNum2(m.getNum2()*10+n);
            v.ecran.setText(v.ecran.getText()+m.getNum2()+"");
            }
            //sinon c'est a dire l'op n'est pas initialise
            else{ m.setNum1(m.getNum1()*10+n);
            v.ecran.setText(m.getNum1()+"");
            }
}
    public void AjoutPlusDesNombres(char o){
        //si l'ope est + ou - ou * ou / calculer les equations precedentes puis copier le resultat dans num1 et changer l'op a la nouvelle
        if(m.getOp()!='x'){
                    m.calculate(m.getOp());
                  m.setNum1(m.result);
                  m.setNum2(0);
                  m.setOp(o);
              }
        //sinon
         else{
             m.setOp(o);
         }
    }
}
