package leetcode;

import java.util.HashMap;

/**
 * Created by ykp on 9/23/16.
 */
public class WordCount290 {

    public boolean wordPattern(String pattern, String str) {

        String strArray[] = str.split(" ");
        HashMap<Character,String> map = new HashMap();

        if(pattern.length() != strArray.length){
            return false;
        }
        for(int i=0;i <pattern.length();i++){
            char currentChar = pattern.charAt(i);
            String current = strArray[i];

            if(map.get(currentChar)!= null){
                String mappedValue = map.get(currentChar);
                if(!mappedValue.equals(current)){
                    return false;
                }
            }else if(map.containsValue(current)){
                return false;
            }else{
                map.put(currentChar,current);
            }
        }

        return true;
    }

    public static void main(String[] args){
        WordCount290 word = new WordCount290();
        String pattern = "abba";
        String words ="dog cat cat dog";
        if(word.wordPattern(pattern, words)){
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }
    }
}
