package leetcode;

import java.util.HashMap;

/**
 * Created by ykp on 9/14/16.
 *
 * Find longest consecutive substring without repeating characters
 *
 */
public class LongestConsecutiveSubString3 {

    public int findLengthOfLongestConsecutiveSubString(String string){
        HashMap<Character,Integer> map = new HashMap();

        int start = 0;
        int end = 0;

        int maximum_size = Integer.MIN_VALUE;

        for(end=0;end < string.length();end++){
            char c = string.charAt(end);

            if(map.get(c) == null){
                map.put(c,end);
            }else{
                if(end-start > maximum_size){
                    maximum_size = end-start;
                }

                int destIndex = map.get(c)+1;

                while(start < destIndex){
                    map.remove(string.charAt(start));
                    start+=1;
                }

                map.put(c,end);
            }

        }

        if(end-start > maximum_size){
            maximum_size = end-start;
        }

        return maximum_size;
    }

    public static void main(String[] args){
        LongestConsecutiveSubString3 cons = new LongestConsecutiveSubString3();
        String string = "abba";
        System.out.println(cons.findLengthOfLongestConsecutiveSubString(string));
    }
}
