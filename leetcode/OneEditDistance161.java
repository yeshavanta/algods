package leetcode;

/**
 * Created by ykp on 9/23/16.
 */
public class OneEditDistance161 {

    public boolean areOneEditDistanceAway(String a, String b){
        int m = a.length();
        int n = b.length();

        if(Math.abs(m-n) > 1){
            return false;
        }

        int i= 0,j=0;
        int count = 0;
        while(i < m && j < n){
            if(a.charAt(i) == b.charAt(j)){
                j++;
                i++;
            }else{
                count++;

                if(count >1){
                    return false;
                }

                if(m > n){
                    i++;
                }else if(m < n){
                    j++;
                }else{
                    i++;
                    j++;
                }
            }
        }

        if(i < m || j < n){
            count++;
        }

        if(count > 1){
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        OneEditDistance161 one = new OneEditDistance161();
        if(one.areOneEditDistanceAway("abv","abdef")){
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }
    }
}
