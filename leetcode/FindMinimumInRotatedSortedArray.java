package leetcode;

/**
 * Created by ykp on 9/16/16.
 */
public class FindMinimumInRotatedSortedArray {

    public int findMinBySequentialSearch(int[] array, int p1, int p2){
        int min = Integer.MAX_VALUE;
        for(int i=p1;i <=p2;i++){
            if(array[i] < min){
                min = array[i];
            }
        }

        return min;
    }

    public int findMinimum(int[] array){

        int p1 = 0;
        int p2 = array.length-1;

        if(array[p1] < array[p2]){
            return array[p1];
        }

        while(p2-p1>1){

            int mid = p1+(p2-p1)/2;

            if(array[p1] == array[p2] && array[p1] == array[mid]){
                return findMinBySequentialSearch(array,p1,p2);
            }

            if(array[p1] <= array[mid]){
                p1=mid;
            }else if(array[mid] <= array[p2]){
                p2=mid;
            }

        }

        return Math.min(array[p1],array[p2]);
    }

    public static void main(String[] args){
        FindMinimumInRotatedSortedArray findMinimum = new FindMinimumInRotatedSortedArray();
        int[] array = {2,3,1};
        System.out.println(findMinimum.findMinimum(array));

    }
}
