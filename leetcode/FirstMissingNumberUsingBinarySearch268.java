package leetcode;

import java.util.Arrays;

/**
 * Created by ykp on 9/21/16.
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.
 *
 */
public class FirstMissingNumberUsingBinarySearch268 {

    public int findMissingNumber(int[] array){
        Arrays.sort(array);

        int low = 0;
        int end = array.length;

        while(low < end){
            int mid = low + (end - low)/2;
            if(array[mid] == mid){
                low = mid+1;
            }else{
                end = mid;
            }
        }

        return low;
    }

    public static void main(String[] args){
        FirstMissingNumberUsingBinarySearch268 binary = new FirstMissingNumberUsingBinarySearch268();
        int[] array = {0,1,2,3,5,6,7,8};
        System.out.println(binary.findMissingNumber(array));
    }
}
