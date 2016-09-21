package leetcode;

/**
 * Created by ykp on 9/19/16.
 */
public class SearchInA2DMatrixSecond {


    public boolean searchMatrix(int[][] matrix, int target) {


        int rows = matrix.length;
        int cols = matrix[0].length;

        int i= rows-1;
        int j = 0;


        while(matrix[i][j] > target  && i-1 >=0){
            i-=1;
        }

        while(matrix[i][j] < target && j+1 < rows){
            j+=1;
        }


        if(matrix[i][j] == target){
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        int[][] matrix = {{-1,-1}};
        SearchInA2DMatrixSecond search = new SearchInA2DMatrixSecond();
        if(search.searchMatrix(matrix,0)){
            System.out.println("The numebr is present");
        }else{
            System.out.println("The number is not present");
        }
    }
}
