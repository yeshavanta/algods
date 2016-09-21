package leetcode;

import java.util.Stack;

/**
 * Created by ykp on 9/16/16.
 */
public class MinStack {

    Stack<Integer> stack = new Stack();

    int min = Integer.MAX_VALUE;

    public void push(int number){
        if(stack.isEmpty()){
            stack.push(0);
            min = number;
        }else{
            stack.push(number-min);
            if(number < min){
                min = number;
            }
        }
    }

    public void pop(){

        if(stack.isEmpty()){
            return;
        }

        int val = stack.pop();

        if(val < 0){
            min = min-val;
        }

    }

    public int top(){
        if(stack.peek() < 0){
            return min;
        }else{
            return min+stack.peek();
        }
    }

    public int getMin(){
        return min;
    }


    public static void main(String[] args){
        MinStack minstack = new MinStack();

        minstack.push(4);
        minstack.push(5);
        minstack.push(8);
        minstack.push(3);
        System.out.println(minstack.getMin());
    }

}
