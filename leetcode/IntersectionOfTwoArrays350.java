package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ykp on 9/24/16.
 */
public class IntersectionOfTwoArrays350 {

    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer,Integer> map = new HashMap();

        for(int i=0;i < nums1.length;i++){
            if(map.get(nums1[i]) == null){
                map.put(nums1[i],1);
            }else{
                int count = map.get(nums1[i]);
                map.put(nums1[i],count+1);
            }
        }

        ArrayList<Integer> result = new ArrayList();
        for(int i=0;i < nums2.length;i++){
            if(map.get(nums2[i]) != null){
                result.add(nums2[i]);
                int count = map.get(nums2[i]);
                if(count == 1){
                    map.remove(nums2[i]);
                }else{
                    map.put(nums2[i],count-1);
                }
            }
        }

        int[] results = new int[result.size()];


        for(int i=0;i < result.size();i++){
            results[i] = result.get(i);
        }

        return results;
    }

    public static void main(String[] args){
        IntersectionOfTwoArrays350 intersection = new IntersectionOfTwoArrays350();
        int[] a = {1,2,2,1};
        int[] b = {2,2};
        int[] result = intersection.intersect(a, b);
        for(int i: result){
            System.out.println(i);
        }
    }
}
