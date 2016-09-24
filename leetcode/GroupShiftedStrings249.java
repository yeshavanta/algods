package leetcode;

import java.util.*;

/**
 * Created by ykp on 9/22/16.
 */
public class GroupShiftedStrings249 {

    public List<List<String>> findGroups(String[] strings){
        List<List<String>> result = new ArrayList();
        Map<String, List<String>> map = new HashMap();
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            String key = "";
            for (int i = 0; i < str.length(); i++) {
                char c = (char) (str.charAt(i) - offset);
                if (c < 'a') {
                    c += 26;
                }
                key += c;
            }
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList();
                map.put(key, list);
            }
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }


    public static void main(String[] args){
        GroupShiftedStrings249 group = new GroupShiftedStrings249();
        String[] array = {"bcd","abc","xyz", "az","ba", "acef", "a","z"};
        List<List<String>>  result = group.findGroups(array);
        for(List<String> stringlist : result){
            for(String string: stringlist){
                System.out.print(string+" ");
            }
            System.out.println();
        }
    }
}
