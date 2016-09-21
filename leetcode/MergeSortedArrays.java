package leetcode;

/**
 * Created by ykp on 9/10/16.
 */
public class MergeSortedArrays {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexToInsert = nums1.length-1;
        int index = m-1;

        while(index >=0){
            nums1[indexToInsert] = nums1[index];
            index-=1;
            indexToInsert-=1;
        }

        int i = indexToInsert+1;
        int j = 0;
        int k = 0;


        while(i < nums1.length && j < n){
            if(nums1[i] <= nums2[j]){
                nums1[k] = nums1[i];
                k++;
                i++;
            }else{
                nums1[k] = nums2[j];
                k++;
                j++;
            }
        }

        while(j < n){
            nums1[k] = nums2[j];
            k++;
            j++;
        }

    }


    public static void main(String[] args){
        MergeSortedArrays mergesorted = new MergeSortedArrays();
        int[] array1 = {1,2,3,0,0,0};
        int[] array2 = {2,5,6};
        mergesorted.merge(array1,3,array2,3);
        for(int i=0;i < array1.length;i++){
            System.out.print(array1[i]+" ");
        }

    }
}
