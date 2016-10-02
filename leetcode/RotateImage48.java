package leetcode;

/**
 * Created by ykp on 9/25/16.
 *
 *
 *
 * clockwise rotate
 * first reverse up to down, then swap the symmetry
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
 *
 *
 * anticlockwise rotate
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
 *
 */
public class RotateImage48 {

    public void displayMatrix(int[][] matrix){
        for(int i=0;i < matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void rotateInPlace(int[][] matrix){

        int rows = matrix.length;
        int cols = matrix[0].length;


        for(int i=0;i < rows;i++){
            reverseCol(matrix, i);
        }

        for(int i=0;i < rows;i++){
            for(int j=i; j < cols;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void reverseCol(int[][] matrix, int colNum){
        int start = 0;
        int end = matrix.length -1;

        while(start <= end){
            int temp = matrix[start][colNum];
            matrix[start][colNum] = matrix[end][colNum];
            matrix[end][colNum] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args){
        RotateImage48 rotate = new RotateImage48();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate.rotateInPlace(matrix);
        rotate.displayMatrix(matrix);
    }
}
