package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ykp on 9/11/16.
 */
public class ExpediaAnirudhagain {

    int globalI = 0;
    int globalJ = 0;

    int maxValue = Integer.MIN_VALUE;

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

    ArrayList<Values> arraylist = new ArrayList();

    public int maxOfArray(int[] array, int start, int end){
        int max = Integer.MIN_VALUE;
        for(int i=start; i <=end;i++){
            if(array[i] > max){
                max = array[i];
            }
        }

        return max;
    }

    public void startProcess(int[] array, int start, int end){
        if(start < end){
            return;
        }
        int maxIndex = maxOfArray(array,start,end);
        int leftmax = maxOfArray(array,start,maxIndex-1);
        int rightmax = maxOfArray(array,maxIndex + 1 , end);

        if((array[maxIndex]& array[leftmax]) > maxValue){
            maxValue = array[maxIndex]& array[leftmax];
            globalI = leftmax;
            globalJ = maxIndex;
            arraylist = new ArrayList();
            arraylist.add(new Values(leftmax, maxIndex));
        }else if((array[maxIndex]& array[leftmax]) == maxValue){
            arraylist.add(new Values(leftmax, maxIndex));
        }

        if((array[maxIndex]& array[rightmax]) > maxValue){
            maxValue = array[maxIndex]& array[rightmax];
            globalI = maxIndex;
            globalJ = rightmax;
            arraylist = new ArrayList();
            arraylist.add(new Values( maxIndex, rightmax));
        }else if((array[maxIndex]& array[rightmax]) > maxValue){
            arraylist.add(new Values(maxIndex, rightmax));
        }

        startProcess(array,start,maxIndex-1);
        startProcess(array,maxIndex+1,end);

    }

    public int[] testcase(int[] array){

        startProcess(array, 0, array.length-1);

        Collections.sort(arraylist, new ArrayComparator());

        Values result = arraylist.get(0);

        int[] resultarray = {result.i,result.j};

        return resultarray;

    }


    public static void main(String[] args){
        ExpediaAnirudhagain expedia = new ExpediaAnirudhagain();
        int[] array = {6,3,6};
        int[] result = expedia.testcase(array);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
