package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ykp on 9/17/16.
 */
public class LongestCommonPrefixVerticalScan {

    public int getShortestString(String[] array){

        int min = Integer.MAX_VALUE;
        for(int i=0;i < array.length;i++){
            if(array[i].length() < min){
                min = array[i].length();
            }
        }

        return min;
    }


    public String findLongest(String[] array){
        String result="";

        int lenToIterate = getShortestString(array);

        int index = 0;
        for(int i=0;i < lenToIterate; i++){
            char current = array[0].charAt(i);
            for(int j=1;j < array.length;j++){
                if(array[j].charAt(i)!=current){
                    index = j;
                    break;
                }
            }
        }
        result = array[0].substring(0,index);
        return result;
    }

    public static void main(String[] args){
        LongestCommonPrefixVerticalScan vertical = new LongestCommonPrefixVerticalScan();
        String[] array = {"geeksforgeeks","geeks","geek","geezer"};
        //String result = vertical.findLongest(array);
        //System.out.println(result);
        String a = "3";
        String b = "30";
        String[] arr = {a,b};
        Arrays.sort(arr, new Comparator<String>(){

            @Override
            public int compare(String i, String j){
                String s1 = i+j;
                String s2 = j+i;
                return s1.compareTo(s2);
            }
        });

        for(String str: arr){
            System.out.println(str);
        }

        //System.out.println(a.compareTo(b));

    }
}
