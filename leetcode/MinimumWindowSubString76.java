package leetcode;

import java.util.HashMap;

/**
 * Created by ykp on 9/15/16.
 */
public class MinimumWindowSubString76 {

    public int minWindow(String source, String target){
        HashMap<Character,Integer> needToFind = new HashMap();

        for(int i=0;i < target.length();i++){
            char c = source.charAt(i);
            if(needToFind.get(c) == null){
               needToFind.put(c,1);
            }else{
                int currentCount = needToFind.get(c);
                needToFind.put(c,currentCount);
            }
        }

        int count = 0;
        int minWindowLen = Integer.MAX_VALUE;
        int begin=0,end=0;

        HashMap<Character,Integer> hasFound = new HashMap();

        for(;end < source.length();end++){
            char c = source.charAt(end);
            if(hasFound.get(c) == null){
                hasFound.put(c,1);
            }else{
                int currentCount = hasFound.get(c);
                hasFound.put(c,currentCount+1);
            }

            if(hasFound.get(c) <= needToFind.get(c)){
                ++count;
            }

            if(count == target.length()){
                if(needToFind.get(source.charAt(begin)) == null){
                    ++begin;
                }else{
                    while(hasFound.get(source.charAt(begin)) > needToFind.get(source.charAt(begin))){
                        int currentCount = hasFound.get(source.charAt(begin));
                        hasFound.put(source.charAt(begin), currentCount-1);
                        begin++;
                    }
                }
            }

            int currentWindowLen = end-begin+1;
            minWindowLen = Math.min(currentWindowLen,minWindowLen);

        }


        return minWindowLen;
    }

    public static void main(String[] args){
        MinimumWindowSubString76 minimum = new MinimumWindowSubString76();
        String s = "acbbaca";
        String t = "aba";
        System.out.println(minimum.minWindow(s, t));
    }
}
