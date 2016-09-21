package leetcode;

/**
 * Created by ykp on 9/17/16.
 */
public class LongestCommonPrefixHorizontalScan {

    public String commonPrefixUtil(String a, String b){
        int len = 0;
        if(a.length() < b.length()){
            len = a.length();
        }else {
            len = b.length();
        }

        int i =0;
        for(; i < len;i++){
            if(a.charAt(i) != b.charAt(i)){
                break;
            }
        }

        return a.substring(0,i);
    }

    public String findLongestCommonPrefix(String[] array){

        String prefix = array[0];
        for(int i=1;i < array.length;i++){
            prefix = commonPrefixUtil(array[i],prefix);
        }

        return prefix;

    }

    public static void main(String[] args){
        LongestCommonPrefixHorizontalScan hscan = new LongestCommonPrefixHorizontalScan();
        String[] array = {"geeksforgeeks","geeks","geek","geezer"};
        System.out.println(hscan.findLongestCommonPrefix(array));
    }
}
