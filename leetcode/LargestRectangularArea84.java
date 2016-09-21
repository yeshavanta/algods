package leetcode;

import java.util.Stack;

/**
 * Created by ykp on 9/16/16.
 */
public class LargestRectangularArea84 {

    public int findLargestRectangularArea(int[] histogram){

        Stack<Integer> stack = new Stack();

        int i=0;

        int min = Integer.MIN_VALUE;

        while(i < histogram.length){

            if(stack.isEmpty() ||  histogram[stack.peek()] <= histogram[i] ){
                stack.push(i++);
            }else{


                    int index = stack.pop();

                    int area = histogram[index] * (stack.isEmpty() ? i : i-stack.peek()-1);
                    if(area > min){
                        min = area;
                    }

            }

        }


        while(!stack.isEmpty()){

            int index = stack.pop();

            int area = histogram[index] * ( stack.isEmpty() ? i : i-stack.peek()-1);

            if(area > min){
                min = area;
            }
        }

        return min;
    }

    public static void main(String[] args){
        LargestRectangularArea84 largest = new LargestRectangularArea84();
        int[] array = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(largest.findLargestRectangularArea(array));
    }
}
