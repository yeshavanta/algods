package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ykp on 9/13/16.
 */
public class Triangle120 {

    public int getMinimumPathSumFromTop(List<List<Integer>> triangle){


        int result[] = new int[triangle.size()];

        List<Integer> currentList = triangle.get(triangle.size()-1);


        for(int i=0;i < currentList.size();i++){
            result[i] = currentList.get(i);
        }

        for(int i=triangle.size()-2;i >=0;i--){
            currentList = triangle.get(i);

            for(int j=0;j < currentList.size();j++){
                result[j] = Math.min(result[j],result[j+1])+ currentList.get(j);
            }
        }


        return result[0];
    }

    public static void main(String[] args){
        Triangle120 triangle = new Triangle120();
        List<List<Integer>> triangleList = new ArrayList();
        triangleList.add(Arrays.asList(2));
        triangleList.add(Arrays.asList(3,4));
        triangleList.add(Arrays.asList(6,5,7));
        triangleList.add(Arrays.asList(4,1,8,3));
        System.out.println(triangle.getMinimumPathSumFromTop(triangleList));
    }
}
