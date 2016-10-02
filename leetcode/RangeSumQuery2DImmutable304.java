package leetcode;

import matrices.RangeSumQuery2DMatrix;

/**
 * Created by ykp on 9/29/16.
 */
public class RangeSumQuery2DImmutable304 {

    int[][] dp = null;

    public void initialize(int[][] matrix){

        int rows = matrix.length;

        if(rows == 0){
            return;
        }
        int cols = matrix[0].length;

        dp = new int[rows+1][cols+1];

        for(int i=1;i < dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRange(int row1,int col1,int row2,int col2){
        int iMax = Math.max(row1,row2);
        int iMin = Math.min(row1,row2);

        int jMax = Math.max(col1,col2);
        int jMin = Math.min(col1,col2);

        return dp[iMax+1][jMax+1] - dp[iMax+1][jMin] - dp[iMin][jMax+1] + dp[iMin][jMin];
    }

    public static void main(String[] args){
        RangeSumQuery2DImmutable304 range = new RangeSumQuery2DImmutable304();
        int[][] matrix = {
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        };
        range.initialize(matrix);
        System.out.println(range.sumRange(2, 1, 4, 3));
    }
}
