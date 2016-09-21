package leetcode;

import java.util.ArrayList;

/**
 * Created by ykp on 9/21/16.
 */
public class SummaryRanges228 {

    public String[] getSummaryRange(int[] array){

        String[] result = null;
        ArrayList<String> resultList = new ArrayList();

        int start = array[0];
        int current = 0;
        int prev = array[0];

        for(int i=1;i < array.length;i++){
            current = array[i];
            if(current == prev+1){
                prev = current;

                if(i == array.length-1){
                    if(start == prev){
                        resultList.add(String.valueOf(start));
                    }else{
                        resultList.add(String.valueOf(start)+"->"+String.valueOf(current));
                    }
                }
            }else{
                if(start == prev){
                    resultList.add(String.valueOf(start));
                }else{
                    resultList.add(String.valueOf(start)+"->"+String.valueOf(prev));
                }
                start = current;
                prev = current;
            }
        }

        if(start == prev && start == array[array.length-1]){
            resultList.add(String.valueOf(start));
        }

        result = new String[resultList.size()];
        for(int i=0;i < resultList.size();i++){
            result[i] = resultList.get(i);
        }

        return result;
    }

    public static void main(String[] args){
        SummaryRanges228 summary = new SummaryRanges228();
        int[] array = {0,2,4,5,7};
        String[] result = summary.getSummaryRange(array);
        for(String string: result){
            System.out.println(string);
        }
    }
}
