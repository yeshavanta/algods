package leetcode;

/**
 * Created by ykp on 9/13/16.
 */
public class RemoveDuplicatesFromSortedArray80 {

    public int remove(int[] array){
        int i=0;

        for(int n : array){

            if(i < 1 || n >array[i-1]){
                array[i] = n;
                ++i;
            }
        }

        return i;
    }


    public static void main(String[] args){
        RemoveDuplicatesFromSortedArray80 remove = new RemoveDuplicatesFromSortedArray80();
        int[] array = {1,1,1,2,2,3};
        System.out.println(remove.remove(array));
    }
}
