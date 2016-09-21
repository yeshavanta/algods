package leetcode;

/**
 * Created by ykp on 9/12/16.
 */
public class ZigZagConversion6 {

    public String getString(String input, int rows){
        StringBuilder[] sb = new StringBuilder[rows];
        for(int i=0;i < sb.length;i++){
            sb[i] = new StringBuilder("");
        }

        int index = 0;
        int incre = 1;

        for(int i=0;i < input.length();i++){
            sb[index].append(input.charAt(i));
            if(index == 0){
                incre = 1;
            }
            if(index == rows-1){
                incre = -1;
            }
            index = index+incre;
        }

        String result = "";

        for(int i=0;i < sb.length;i++){
            result = result + sb[i];
        }


        return result;

    }

    public static void main(String[] args){
        ZigZagConversion6 zigZag = new ZigZagConversion6();
        String inputString = "PAYPALISHIRING";
        int numberOfRows = 4;
        System.out.println(zigZag.getString(inputString, numberOfRows));
    }
}
