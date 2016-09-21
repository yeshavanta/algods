package leetcode;

/**
 * Created by ykp on 9/16/16.
 */
public class SearchInRotatedSortedArray {


    public int search(int[] nums, int target){

        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] == target){
                return mid;
            }


            if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target < nums[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else if(nums[mid] <= nums[end]){
                if(nums[mid] < target && target <= nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args){
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        int[] array = {4,5,6,7,0,1,2};
        int target = 2;
        int index = search.search(array, target);
        if(index!=-1){
            System.out.println(index);
        }else{
            System.out.println(-1);
        }

    }
}
