package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ykp on 9/24/16.
 */
public class SlidingWindowMaximum239 {

    public int[] getSlidingWindowMaximum(int[] nums, int k){

        Deque<Integer> deq = new LinkedList();
        ArrayList<Integer> result = new ArrayList();

        for(int i=0; i < nums.length;i++){
            while(!deq.isEmpty() && nums[i] >= nums[deq.getLast()]){
                deq.removeLast();
            }

            deq.addLast(i);

            if (i - deq.getFirst() + 1 > k) {
                deq.removeFirst();
            }

            if(i+1 >= k){
                result.add(nums[deq.getFirst()]);
            }
        }

        int[] finalRes = new int[result.size()];

        for(int i=0;i < finalRes.length;i++){
            finalRes[i] = result.get(i);
        }

        return finalRes;
    }

    public static void main(String[] args){
        SlidingWindowMaximum239 slide = new SlidingWindowMaximum239();
        int[] array = {7,2,4};
        int[] result = slide.getSlidingWindowMaximum(array, 2);
        for(int i=0;i < result.length;i++){
            System.out.println(result[i]);
        }
    }
}
