package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ykp on 9/20/16.
 */
public class GroupAnagrams49 {

    public List<List<String>> groupAnagrams(String[] strings){
        List<List<String>> result = new ArrayList();

        HashMap<String, List<String>> map = new HashMap();
        for(String string: strings){
            String sorted = getSorted(string);
            if(map.get(sorted) != null){
                List<String> current = map.get(sorted);
                current.add(string);
                map.put(sorted,current);
            }else{
                List<String> re = new ArrayList();
                map.put(sorted, re);
            }
        }

        for(String key : map.keySet()){
            result.add(map.get(key));
        }

        return result;
    }

    public String getSorted(String string){
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static void main(String[] args){
        GroupAnagrams49 group = new GroupAnagrams49();
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        group.groupAnagrams(strings);
    }
}
