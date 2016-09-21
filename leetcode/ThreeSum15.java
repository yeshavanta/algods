package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ykp on 9/13/16.
 */
public class ThreeSum15 {

    public List<List<Integer>> findThreeSum(int[] array){

        List<List<Integer>> result = new ArrayList();
        Arrays.sort(array);

        int i =0 ;

        while(i < array.length -2){
            if(array[i] > 0){
                break;
            }

            int j = i+1;
            int k = array.length-1;

            while(j < k){
                int sum = array[i]+array[j]+array[k];

                if(sum == 0){
                    result.add(Arrays.asList(array[i],array[j],array[k]));
                }
                if(sum <= 0){
                    while(array[j] == array[++j] && j < k);
                }
                if(sum >= 0){
                    while(array[k--] == array[k] && j < k);
                }

            }

            while( array[i]==array[++i] && i < array.length-2 );

        }

        return result;
    }


    public static void main(String[] args){
        ThreeSum15 threeSum = new ThreeSum15();
        int[] array = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum.findThreeSum(array);
        for(List<Integer> al : result){
            for(int i : al){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
