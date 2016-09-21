package leetcode;

import java.util.HashSet;

/**
 * Created by ykp on 9/14/16.
 */
public class LongestConsecutiveSubStringUsingHashSet {

    public int getLongestConsecutiveSubString(String string){
        HashSet<Character> set = new HashSet();

        int i=0;
        int start = 0;
        int maxLen = Integer.MIN_VALUE;

        while(i < string.length()){

            char c = string.charAt(i);

            if(!set.contains(c)){
                set.add(c);
            }else{

                maxLen = Math.max(maxLen, set.size());

                while(start < i && string.charAt(start) != c){
                    set.remove(c);
                    start++;
                }

                start++;
            }

            i++;

        }

        maxLen = Math.max(maxLen, set.size());

        return maxLen;
    }

    public static void main(String[] args){
        LongestConsecutiveSubStringUsingHashSet longest = new LongestConsecutiveSubStringUsingHashSet();
        String string = "abcabcbb";
        System.out.println(longest.getLongestConsecutiveSubString(string));
    }
}
