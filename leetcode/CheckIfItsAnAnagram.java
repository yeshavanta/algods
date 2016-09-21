package leetcode;

import java.util.HashMap;

/**
 * Created by ykp on 9/14/16.
 */
public class CheckIfItsAnAnagram {

    public boolean isAnagram(String s, String t){
        HashMap<Character,Integer> map = new HashMap();

        for(int i=0; i< s.length();i++){
            char c = s.charAt(i);
            if(map.get(c) == null){
                map.put(c,1);
            }else{
                int currentCount = map.get(c);
                map.put(c,currentCount+1);
            }
        }


        for(int i=0;i < t.length();i++){
            char c = t.charAt(i);

            if(map.get(c)== null){
                return false;
            }else{
                int currentCount = map.get(c);
                if(currentCount == 1){
                    map.remove(c);
                }else{
                    map.put(c,currentCount-1);
                }
            }
        }

        if(map.size() > 0){
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        CheckIfItsAnAnagram check = new CheckIfItsAnAnagram();
        if(check.isAnagram("anagram","nagaram")){
            System.out.println("It is an anagram");
        }else{
            System.out.println("It is not an anagram");
        }
    }
}
