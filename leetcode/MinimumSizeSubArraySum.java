package leetcode;

/**
 * Created by ykp on 9/12/16.
 */
public class MinimumSizeSubArraySum {

    public int getMinimumSizeSubArraySum(int[] array,int target){
        int start = 0;
        int end = 0;
        int sum = 0;

        int minimum_size = Integer.MAX_VALUE;

        while(end < array.length){

            while(end < array.length-1 && sum < target ){
                sum = sum + array[end];
                end = end + 1;
            }

            if(sum < target){
                break;
            }

            while( start < end && sum >= target){
                sum = sum + array[start];
                start = start +1;
            }

            if(end -start+1 < minimum_size){
                minimum_size = end-start+1;
            }

        }

        return minimum_size == Integer.MAX_VALUE ? 0 : minimum_size;

    }
    public int getMinLen(int nums[], int s){
        int minLen = Integer.MAX_VALUE;

        int start = 0, end = 0, sum = 0;

        while( end < nums.length ){

            while( end < nums.length && sum < s ){
                sum = sum + nums[end];
                end = end + 1;
            }

            if(sum < s){
                break;
            }

            while(start < end && sum >= s){
                sum = sum - nums[start];
                start = start + 1;
            }

            if(end-start+1 < minLen){
                minLen = end-start+1;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args){
        MinimumSizeSubArraySum minimum = new MinimumSizeSubArraySum();
        int[] array = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minimum.getMinimumSizeSubArraySum(array,target));
    }
}
