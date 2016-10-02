package leetcode;

/**
 * Created by ykp on 9/26/16.
 *
 * To understand this, just look at the video of Tushar Roy on how to find the length of the common subsequence
 *
 */
public class LongestCommonSubSequence {

    public int getLengthOfLongestCommonSubSequence(String a, String b){
        int m = a.length();
        int n = b.length();

        int[][] matrix = new int[m+1][n+1];

        for(int i=0;i < m+1;i++){
            matrix[i][0] = 0;
        }

        for(int j = 0; j < n+1;j++){
            matrix[0][j] = 0;
        }

        for(int i=0;i < m;i++){
            for(int j=0;j < n;j++){
                if(a.charAt(i) == b.charAt(j)){
                    matrix[i+1][j+1] = 1 + matrix[i][j];
                }else{
                    matrix[i+1][j+1] = Math.max(matrix[i][j+1],matrix[i+1][j]);
                }
            }
        }

        return matrix[m][n];
    }

    public static void main(String[] args){
        LongestCommonSubSequence longest = new LongestCommonSubSequence();
        System.out.println(longest.getLengthOfLongestCommonSubSequence("amsterdam","emanate"));
    }
}
