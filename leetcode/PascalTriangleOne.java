package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ykp on 9/18/16.
 */
public class PascalTriangleOne {

    public List<List<Integer>>generateTriangle(int numOfRows){
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numOfRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;
    }

    public static void main(String[] args){
        PascalTriangleOne pascal = new PascalTriangleOne();
        pascal.generateTriangle(5);
    }
}
