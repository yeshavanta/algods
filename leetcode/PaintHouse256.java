package leetcode;

/**
 * Created by ykp on 9/28/16.
 */
public class PaintHouse256 {

    public int getMinPaintCost(int[][] costs){

        int[] mincosts = new int[costs[0].length];

        if(costs == null || costs.length == 0){
            return Integer.MIN_VALUE;
        }

        mincosts[0] = costs[0][0];
        mincosts[1] = costs[0][1];
        mincosts[2] = costs[0][2];
        int lastA = 0;
        int lastB = 0;
        int lastC = 0;


        for(int i=1;i < costs.length;i++){
            lastA += Math.min(mincosts[1],mincosts[2]);
            lastB += Math.min(mincosts[0],mincosts[2]);
            lastC += Math.min(mincosts[0],mincosts[1]);

            mincosts[0] = lastA;
            mincosts[1] = lastB;
            mincosts[2] = lastC;
        }

        return Math.min(Math.min(lastA,lastB),lastC);

    }

    public static void main(String[] args){
        PaintHouse256 paint = new PaintHouse256();
        int[][] paintCosts = {
                {5,8,6},
                {9,14,13},
                {7,5,12},
                {14,15,17},
                {3,20,10}
        };
        System.out.println(paint.getMinPaintCost(paintCosts));
    }
}
