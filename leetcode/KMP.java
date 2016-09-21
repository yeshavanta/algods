package leetcode;

/**
 * Created by ykp on 9/11/16.
 */
public class KMP{

    public int[] generateKMPTable(String pattern){
        char[] patternArray = pattern.toCharArray();
        int[] result = new int[patternArray.length];

        int j = 0;

        for(int i=1;i <patternArray.length;){
            if(patternArray[j] == patternArray[i]){
                result[i] = j+1;
                j++;
                i++;
            }else{
                if(j!=0){
                    j = result[j-1];
                }else{
                    result[i] = 0;
                    i++;
                }
            }
        }


        return result;
    }

    public int[] computePartialMatchTable(String pattern){

        int i;
        int j=0;


        int[] table = new int[pattern.length()];
        char[] patArray = pattern.toCharArray();

        for(i=1;i < patArray.length;){

            if(patArray[i] == patArray[j]){
                table[i] = j+1;
                i++;
                j++;
            }else{
                if(j!=0){
                    j = table[j-1];
                }else{
                    table[i]=0;
                    i++;
                }
            }
        }




        return table;
    }

    public boolean kmp(String text, String pattern){
        int[] kmpTable = computePartialMatchTable(pattern);
        int i=0;
        int j=0;
        char[] textArray = text.toCharArray();
        char[] patternArray = pattern.toCharArray();

        while(i < textArray.length &&  j < patternArray.length){
            if(textArray[i] == patternArray[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = kmpTable[j-1];
                }else{
                    i++;
                }
            }
        }

        if( j == patternArray.length){
            return true;
        }

        return false;


    }

    public void printArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args){
        String pattern = "abcdabcy";
        String text = "abcxabcdabcdabcy";
        KMP kmp = new KMP();
        if(kmp.kmp(text,pattern)){
            System.out.println("The pattern does exist");
        }else{
            System.out.println("The pattern does not exist");
        }

    }
}
