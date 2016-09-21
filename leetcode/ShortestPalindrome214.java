package leetcode;

/**
 * Created by ykp on 9/20/16.
 */
public class ShortestPalindrome214 {

    public String shortestPalindrome(String s){
        int i=0;
        int j=s.length()-1;

        while(j>=0){
            if(s.charAt(i)==s.charAt(j)){
                i++;
            }
            j--;
        }

        if(i==s.length())
            return s;

        String suffix = s.substring(i);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, i));
        return prefix+mid+suffix;
    }

    public static void main(String[] args){
        ShortestPalindrome214 shortest = new ShortestPalindrome214();
        String string = "aacecaaa";
        System.out.println(shortest.shortestPalindrome(string));
    }
}
