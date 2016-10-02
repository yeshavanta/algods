package leetcode;

/**
 * Created by ykp on 9/26/16.
 */
public class LongestIncreasingPathInAMatrix329 {

    public int longestIncreasingPath(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        int max = Integer.MIN_VALUE;

        int[][] cache = new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j < cols;j++){
                max = Math.max(max, dfs(matrix,cache,i,j));
            }
        }

        return max;
    }

    public int dfs(int[][] matrix, int[][] cache, int i, int j){
        if(cache[i][j] != 0){
            return cache[i][j];
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int max = 1;

        for(int k=0;k < dx.length;k++){
            int x = i+dx[k];
            int y = j+dy[k];

            if(x <0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]){
                continue;
            }

            int len = 1 + dfs(matrix,cache,x,y);
            max = Math.max(max,len);
        }

        cache[i][j] = max;
        return max;

    }

    public static void main(String[] args){
        LongestIncreasingPathInAMatrix329 longest = new LongestIncreasingPathInAMatrix329();
        int[][] matrix = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        System.out.println(longest.longestIncreasingPath(matrix));
    }
}
