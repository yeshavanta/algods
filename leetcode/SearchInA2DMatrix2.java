package leetcode;

/**
 * Created by ykp on 9/25/16.
 */
public class SearchInA2DMatrix2 {

    public boolean isPresent(int[][] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols-1;


        while(row < rows && col >=0){
            if(matrix[row][col] == target){
                return true;
            }else{
                if(matrix[row][col] > target){
                    col--;
                }else{
                    row++;
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        SearchInA2DMatrix2 search = new SearchInA2DMatrix2();
        int[][] matrix = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}

        };
        if(search.isPresent(matrix, 7)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
