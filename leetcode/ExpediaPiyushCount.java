package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ykp on 9/11/16.
 */
public class ExpediaPiyushCount {

    public long getDoubleMaxValue(long[] a, long b){
        HashMap<Long,Long> map = new HashMap();

        ArrayList<Long> aAfterReshuffle = new ArrayList();

        for(int i=0; i < a.length;i++){
            if(map.get(a[i]) == null){
                map.put(a[i],1L);
            }else{
                long currentCount =  map.get(a[i]);
                map.put(a[i],currentCount+1);
            }
        }


        int index = 0;

        if(map.get(b) == null){
            return b;
        }

        long currentValueOfB = b;
        while(true){

            if(map.get(currentValueOfB) == null){
                break;
            }


            long currentCount = map.get(currentValueOfB);


            while(currentCount > 0){
                aAfterReshuffle.add(currentValueOfB);
                --currentCount;
            }

            map.remove(currentValueOfB);

            currentValueOfB = currentValueOfB * 2;

        }

        return currentValueOfB;


    }

    public static void main(String[] args){
        ExpediaPiyushCount count = new ExpediaPiyushCount();
        long[] a = {1,1,1};
        long b = 1;

        System.out.println(count.getDoubleMaxValue(a, b));
    }
}
