package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ykp on 9/16/16.
 */
public class MajorityElementSecond229 {


    public List<Integer> findMajority(int[] nums){
        int count1 = 0, count2 = 0;
        int value1 = 0, value2 = 0;

        List<Integer> result = new ArrayList();
        for(int i=0;i < nums.length;i++){
            if(count1 == 0 && nums[i]!= value2){
                value1 = nums[i];
                count1=1;
            }else if(nums[i] == value1){
                count1++;
            }else if(count2 == 0 && nums[i]!= value1){
                value2 = nums[i];
                count2=1;
            }else if(nums[i]==value2){
                count2++;
            }else{
                --count1;
                --count2;
            }
        }


        count1 = count2 = 0;

        for(int i : nums){
            if(i==value1){
                ++count1;
            }else if(i==value2){
                ++count2;
            }
        }

        if(count1 > nums.length/3){
            result.add(value1);
        }
        if(count2 > nums.length/3){
            result.add(value2);
        }

        return result;
    }

    public static void main(String[] args){
        MajorityElementSecond229 majority = new MajorityElementSecond229();
        int[] array = {1,2,2,3,2,1,1,3};
        List<Integer> result = majority.findMajority(array);
        for(int i: result){
            System.out.println(i);
        }
    }
}
