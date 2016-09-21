package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by ykp on 9/11/16.
 */
public class ExpediaCount {

    public void printSortedFrequency(int[] array){

        HashMap<Integer,Integer> map = new HashMap();
        for(int i =0;i < array.length;i++){
            if(map.get(array[i]) == null){
               map.put(array[i],1);
            }else{
                int currentCount =  map.get(array[i]);
                map.put(array[i],currentCount+1);
            }
        }

        TreeMap<Integer,ArrayList<Integer>> treeMap = new TreeMap();
        for(int i=0;i < array.length;i++){
            int currentCount = map.get(array[i]);
            if(treeMap.get(currentCount) != null){
                ArrayList<Integer> currentList = treeMap.get(currentCount);
                currentList.add(array[i]);
                treeMap.put(currentCount,currentList);
            }else{
                ArrayList<Integer> currentList = new ArrayList();
                currentList.add(array[i]);
                treeMap.put(currentCount,currentList);
            }
        }

        for( ArrayList<Integer> list:  treeMap.values()){
            Collections.sort(list);
            for(int i: list){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args){
        int[] array  = {8,8,1,1,1,3,3,4};
        ExpediaCount expedia = new ExpediaCount();
        expedia.printSortedFrequency(array);
    }
}
