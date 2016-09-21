package leetcode;

/**
 * Created by ykp on 9/12/16.
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 */
public class ValidPalindrome125 {

    public boolean isPalindrome(String testString){
        if(testString.isEmpty() || testString == null){
            return true;
        }

        int left = 0;
        int right = testString.length()-1;

        while(left < right){
            while(left < testString.length()-1 && !Character.isLetterOrDigit(testString.charAt(left))){
                ++left;
            }
            while( right > 0 && !Character.isLetterOrDigit(testString.charAt(right))){
                --right;
            }
            if(Character.isLetterOrDigit(testString.charAt(left)) && Character.isLetterOrDigit(testString.charAt(right)) && Character.toLowerCase(testString.charAt(left))!=Character.toLowerCase(testString.charAt(right))){
                return false;
            }else{
                ++left;
                --right;
            }

        }

        return true;
    }


    public static void main(String[] args){
        ValidPalindrome125 valid = new ValidPalindrome125();
        String testString = "Red rum, sir, is murder";
        if(valid.isPalindrome(testString)){
            System.out.println("The given string is a palindrome");
        }else{
            System.out.println("The given string is not a palindrome");
        }
    }
}
