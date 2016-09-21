package leetcode;

import java.util.HashMap;

/**
 * Created by ykp on 9/15/16.
 */
public class LongestSubStringWhichContainsTwoUniqueCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String string){
        int max = Integer.MIN_VALUE;

        int start = 0;

        HashMap<Character,Integer> map = new HashMap();

        for(int i=0;i < string.length();i++){
            char c = string.charAt(i);

            if(map.get(c)== null){
                map.put(c,1);
            }else{
                int currentCount = map.get(c);
                map.put(c,currentCount+1);
            }

            if(map.size() > 2){
                max = Math.max(max, i-start);

                while(map.size() > 2){
                    char ca = string.charAt(start);

                    int currentCount = map.get(ca);

                    if(currentCount == 1){
                        map.remove(ca);
                    }else{
                        map.put(ca,currentCount-1);
                    }
                    start++;
                }
            }

        }

        max = Math.max(max, string.length()-start);

        return max;
    }


    public static void main(String[] args){
        LongestSubStringWhichContainsTwoUniqueCharacters longest = new LongestSubStringWhichContainsTwoUniqueCharacters();
        String string = "abcbbbbcccbdddadacb";
        System.out.println(longest.lengthOfLongestSubstringTwoDistinct(string));
    }
}
