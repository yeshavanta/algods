package leetcode;

/**
 * Created by ykp on 9/17/16.
 */
public class GasStation134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int count = 0;
        int current = 0;
        int start = 0;
        int n = gas.length;

        while( start < 2 *n && count < n){

            current = current + gas[start % n] - cost[start % n];

            if(current >= 0){
                count++;
            }else{
                count = 0;
                current = 0;
            }
            start++;

        }

        return count < n ? -1 : start % n;

    }

    public static void main(String[] args){
        GasStation134 gas = new GasStation134();
        int[] gasindices = {1,2};
        int[] cost = {2,1};
        System.out.println(gas.canCompleteCircuit(gasindices,cost));
    }
}
