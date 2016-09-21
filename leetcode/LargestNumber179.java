package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ykp on 9/17/16.
 */
public class LargestNumber179 {

    public String largestNumber(int[] nums) {
        String result = "";

        String[] strings = new String[nums.length];

        for(int i=0;i < nums.length;i++){
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, new Comparator<String>(){

            @Override
            public int compare(String a, String b){
                String i = a + b;
                String j = b + a;

                return j.compareTo(i);
            }
        });

        StringBuilder sb = new StringBuilder();

        for(String s: strings){
            sb.append(s);
        }

        return result;
    }

    public static void main(String[] args){
        LargestNumber179 largest = new LargestNumber179();
        int[] array = {3, 30, 34, 5, 9};
        System.out.println(largest.largestNumber(array));
    }
}
