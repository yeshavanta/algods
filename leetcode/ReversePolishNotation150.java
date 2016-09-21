package leetcode;

import java.util.Stack;

/**
 * Created by ykp on 9/9/16.
 */
public class ReversePolishNotation150 {

    public boolean isOperator(String c){
        String operators = "+-*/";
        if(operators.contains(c)){
            return true;
        }
        return false;
    }

    public int applyOperator(String operator, int a , int b){
        if(operator.equals("+")){
            return a + b;
        }else if(operator.equals("-")){
            return a - b;
        }else if(operator.equals("*")){
            return a * b;
        }else{
            return a / b;
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();

        for(int i = 0; i < tokens.length;i++){
            String current = tokens[i];

            if(isOperator(current)){
                int b = stack.pop();
                int a = stack.pop();

                int result = applyOperator(current,a,b);
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(current));
            }
        }

        return stack.peek();
    }

    public static void main(String[] args){
        ReversePolishNotation150 reverse = new ReversePolishNotation150();
        String[] tokens = {"0","3","/"};
        System.out.println(reverse.evalRPN(tokens));
    }
}
