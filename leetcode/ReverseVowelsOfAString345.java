package leetcode;

/**
 * Created by ykp on 9/21/16.
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".
 */
public class ReverseVowelsOfAString345 {

    public boolean isVowel(char c){
        String s = "aeiouAEIOU";

        if(s.indexOf(c) == -1){
            return false;
        }else{
            return true;
        }
    }

    public String reverse(String string){
        int start = 0;
        int end = string.length()-1;

        char[] array = string.toCharArray();
        while(start <= end){
            while(start <= string.length()-1 && !isVowel(array[start])){
                start++;
            }

            while(end>=0 && !isVowel(array[end])){
                end--;
            }

            if(start <= end){
                char temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }

        return String.valueOf(array);
    }

    public static void main(String[] args){
        ReverseVowelsOfAString345 reverse = new ReverseVowelsOfAString345();
        System.out.println(reverse.reverse("aA"));
    }
}
