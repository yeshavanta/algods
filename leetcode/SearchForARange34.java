package leetcode;

/**
 * Created by ykp on 9/19/16.
 */
public class SearchForARange34 {

    public int[] searchRange(int[] array, int target){
        int[] result = {-1,-1};

        int low = 0;
        int high = array.length-1;

        while(array[low] < array[high]){
            int mid = low + (high - low)/2;

            if(array[mid] > target){
                high = mid-1;
            }else if(array[mid] < target){
                low = mid + 1;
            }else{
                if(array[low] == array[mid]){
                    high--;
                }else{
                    low++;
                }
            }
        }

        if(array[low] == array[high] && array[low] == target){
            result[0] = low;
            result[1] = high;
        }

        return result;
    }

    public static void main(String[] args){
        SearchForARange34 search = new SearchForARange34();
        int[] array = {1, 1, 2, 2, 3, 5, 5, 5, 7, 7, 8, 8, 8, 10};
        int[] result = search.searchRange(array,8);
        for(int i : result){
            System.out.println(i);
        }
    }
}
