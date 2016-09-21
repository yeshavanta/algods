package leetcode;

/**
 * Created by ykp on 9/20/16.
 */
public class LongestPalindromicSubstring {

    public String getLongest(String string){
        int beginIndex = 0;
        int maxLen = 1;

        boolean table[][] = new boolean[string.length()][string.length()];

        for(int i=0;i < table.length; i ++){
            for(int j=0;j < table[0].length ; j++){
                if(i == j){
                    table[i][j] = true;
                }
            }
        }

        int length = 2;
        int n = string.length();
        for(int i=0;i < n-length+1;i++ ){
            if(string.charAt(i) == string.charAt(i+1)){
                table[i][i+1] = true;
                beginIndex = i;
                maxLen = 2;
            }
        }

        for(int len = 3; len <= n; len++){
            for(int i=0;i < n-len+1;i++){
                int j = i + len - 1;
                if(string.charAt(i) == string.charAt(j) && table[i+1][j-1]){
                    table[i][j] = true;
                    beginIndex = i;
                    maxLen = len;
                }
            }
        }

        return string.substring(beginIndex,beginIndex+maxLen);
    }

    public static void main(String[] args){
        LongestPalindromicSubstring longest = new LongestPalindromicSubstring();
        String string = "bb";
        System.out.println(longest.getLongest(string));
    }
}
