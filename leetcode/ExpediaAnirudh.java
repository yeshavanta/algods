package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ykp on 9/11/16.
 */
public class ExpediaAnirudh {

    class Values{
        int i;
        int j;


        public Values(int i,int j){
            this.i=i;
            this.j=j;
        }
    }

    class ArrayComparator implements Comparator<Values> {

        public int compare(Values v1, Values v2){
            if(v1.i != v2.i){
                return v1.i - v2.i;
            }else{
                return (v1.j-v1.i)-(v2.j-v2.i);
            }

        }
    }

    public int[] testcase(int[] array){


        int maxValue = Integer.MIN_VALUE;
        ArrayList<Values> arraylist = new ArrayList();


        for(int i=0;i< array.length;i++){
            for(int j=i+1;j < array.length;j++){
                int[] temp = Arrays.copyOfRange(array,i,j+1);
                Arrays.sort(temp);
                int last = temp[temp.length-1];
                int lastButOne = temp[temp.length-2];

                if((last & lastButOne) > maxValue) {
                    maxValue = last & lastButOne;
                    arraylist = new ArrayList();
                    arraylist.add(new Values(i, j));
                }else if((last & lastButOne) > maxValue){
                    arraylist.add(new Values(i, j));
                }
            }
        }

        Collections.sort(arraylist,new ArrayComparator() );

        Values result = arraylist.get(0);

        int[] resultarray = {result.i,result.j};

        return resultarray;
    }

    public static void main(String[] args){
        ExpediaAnirudh expedia = new ExpediaAnirudh();
        int[] array = {3,5};
        int[] result = expedia.testcase(array);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
