package leetcode;

import java.util.HashMap;

/**
 * Created by ykp on 9/10/16.
 */
public class Trial {


    public static void main(String[] args){
        int name = 100;
        int complement = ~name;
        //System.out.println(name + complement);

        HashMap<Character,Integer> one = new HashMap();
        HashMap<Character,Integer> two = new HashMap();

        one.put('a',1);
        one.put('b',1);

        two.put('b',1);
        two.put('a',1);


        if(one.equals(two)){
            System.out.println("Yaay");
        }else{
            System.out.println("Naay");
        }
    }
}
