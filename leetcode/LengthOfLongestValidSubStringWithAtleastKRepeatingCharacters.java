package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by ykp on 9/14/16.
 */
public class LengthOfLongestValidSubStringWithAtleastKRepeatingCharacters {

    public int getLengthOfLongest(String string, int k){

        HashMap<Character,Integer> map = new HashMap();
        for(int i=0;i < string.length();i++){
            char c = string.charAt(i);
            if(map.get(c) == null){
                map.put(c,1);
            }else{
                int currentCount = map.get(c);
                map.put(c, currentCount+1);
            }
        }

        HashSet<Character> splitSet = new HashSet();

        for(char c : map.keySet()){
            int count = map.get(c);
            if(count < k){
                splitSet.add(c);
            }
        }

        if(splitSet.isEmpty()){
            return string.length();
        }

        int max = Integer.MIN_VALUE;

        int i=0,j=0;
        while(j < string.length()){
            if(splitSet.contains(string.charAt(j))){
                if(j!=i){
                    max = Math.max(max, getLengthOfLongest(string.substring(i,j),k));
                }
                i = j+1;
            }
            j++;
        }

        if(j!=i){
            max = Math.max(max,getLengthOfLongest(string.substring(i,j),k));
        }

        return max;

    }

    public static void main(String[] args){

        LengthOfLongestValidSubStringWithAtleastKRepeatingCharacters length = new LengthOfLongestValidSubStringWithAtleastKRepeatingCharacters();
        String string = "aaabb";
        int k = 3;
        System.out.println(length.getLengthOfLongest(string, k));

        System.out.println(string.substring(0,3));
    }
}
