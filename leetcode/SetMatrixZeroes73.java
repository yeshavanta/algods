package leetcode;

/**
 * Created by ykp on 9/24/16.
 */
public class SetMatrixZeroes73 {

    public void displayMatrix(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i=0;i < rows;i++){
            for(int j=0;j < cols;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] setZeroes(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] rowsBool = new boolean[rows];
        boolean[] colsBool = new boolean[cols];

        for(int i =0;i < rows;i++){
            for(int j=0;j < cols;j++){
                if(matrix[i][j] == 0){
                    rowsBool[i] = true;
                    colsBool[j] = true;
                }
            }
        }

        for(int i=0;i < rows;i++){
            for(int j=0; j < cols; j++){
                if(rowsBool[i] || colsBool[j]){
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args){
        SetMatrixZeroes73 set = new SetMatrixZeroes73();
        int[][] matrix = {
                {1,1,1,0},
                {1,1,1,0},
                {1,1,0,0},
                {1,0,0,0}
        };
        set.displayMatrix(set.setZeroes(matrix));
    }
}
