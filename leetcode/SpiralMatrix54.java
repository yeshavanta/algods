package leetcode;

import java.util.ArrayList;

/**
 * Created by ykp on 9/24/16.
 */
public class SpiralMatrix54 {

    public int[] getSpiralTraversal(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = cols-1;
        int top = 0;
        int bot = rows-1;

        ArrayList<Integer> result = new ArrayList();

        while(result.size() < rows*cols ){

            if(right < left){
                break;
            }

            for(int j=left;j <=right;j++){
                result.add(matrix[top][j]);
            }

            ++top;

            if(top > bot){
                break;
            }

            for(int i=top;i <=bot;i++){
                result.add(matrix[i][right]);
            }
            --right;

            if(right < left){
                break;
            }

            for(int j=right;j >=left;j--){
                result.add(matrix[bot][j]);
            }
            --bot;

            if(top > bot){
                break;
            }

            for(int i=bot;i >=top;i--){
                result.add(matrix[i][left]);
            }
            ++left;
        }


        int[] finalResult = new int[result.size()];

        for(int k=0;k < result.size();k++){
            finalResult[k] = result.get(k);
        }

        return finalResult;
    }

    public void displayArray(int[] result){
        for(int i=0;i < result.length;i++){
            System.out.print(result[i]+" ");
        }
    }

    public static void main(String[] args){
        SpiralMatrix54 spiral = new SpiralMatrix54();

        int[][] matrix = {
                {1,2}
        };

        int[] result = spiral.getSpiralTraversal(matrix);
        spiral.displayArray(result);
    }
}
