package leetcode;

/**
 * Created by ykp on 9/13/16.
 */
public class RemoveDuplicatesFromSortedArray26 {


    public int getLength(int[] array){

        int index = 0;

        for(int i = 1 ; i < array.length;i++ ){
            if(array[i]!=array[index]){
                array[++index]=array[i];
            }
        }
        return index+1;
    }

    public static void main(String[] args){
        RemoveDuplicatesFromSortedArray26 remove = new RemoveDuplicatesFromSortedArray26();
        int[] array = {1,1,2};
        System.out.println(remove.getLength(array));
    }
}
