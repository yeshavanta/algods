package leetcode;

import java.util.ArrayList;

/**
 * Created by ykp on 9/21/16.
 */
public class FlipGame293 {

    public String[] getOutput(String string){

        ArrayList<String> results = new ArrayList();
        char[] array = string.toCharArray();
        for(int i=0; i < string.length()-1;i++){
            if(array[i] == array[i+1] && array[i] == '+'){
                array[i] = '-';
                array[i+1] = '-';
                results.add(new String(array));
                array[i] = '+';
                array[i+1] = '+';
            }
        }

        String[] result = results.toArray(new String[results.size()]);
        return result;
    }

    public static void main(String[] args){
        FlipGame293 flip = new FlipGame293();
        String string = "+---+++-+";
        String[] result = flip.getOutput(string);
        for(String s: result){
            System.out.println(s);
        }
    }
}
