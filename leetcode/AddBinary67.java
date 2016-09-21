package leetcode;

/**
 * Created by ykp on 9/13/16.
 */
public class AddBinary67 {

    public String addTwoNumbers(String a, String b){
        StringBuilder result = new StringBuilder();

        int i=a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while(i >=0 || j >=0 || carry > 0){
            int sum = carry;
            if( i >=0){
                sum = sum + a.charAt(i)-'0';
                i -=1;
            }
            if(j >=0){
                sum = sum + b.charAt(j) - '0';
                j -=1;
            }

            carry = sum / 2;
            result.append(sum % 2);
        }

        if(carry != 0){
            result.append(carry);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args){
        AddBinary67 addBinary = new AddBinary67();
        System.out.println(addBinary.addTwoNumbers("10","10"));
    }
}
