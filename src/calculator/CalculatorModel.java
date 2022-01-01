
package calculator;


public class CalculatorModel {
    private int num1,num2;
    private char op= 'x';
    public int result;
    public int getNum1(){
        return this.num1;
    }
    public void setNum1(int num1){
        this.num1=num1;
    }
    public int getNum2(){
        return this.num2;
    }
    public void setNum2(int num2){
        this.num2=num2;
    }
    public char getOp(){
        return this.op;
    }
    public void setOp(char o){
        this.op=o;
    }
    public void calculate(){
        switch(op){
            case '+': this.result+=this.num1+this.num2;break;
            case '-': this.result+=this.num1-this.num2;break;
            case '/': if(this.num2!=0) this.result+=this.num1/this.num2; else result=0;break;
            case '*': this.result+=this.num1*this.num2;break;
            default : this.result=0;
        }
        
    }
    public void calculate(char op){
        switch(op){
            case '+': this.result=this.num1+this.num2;break;
            case '-': this.result=this.num1-this.num2;break;
            case '/': if(this.num2!=0) this.result=this.num1/this.num2; else result=0;break;
            case '*': this.result=this.num1*this.num2;break;
            default : this.result=0;
        }
        
    }
}
