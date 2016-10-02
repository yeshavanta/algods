package leetcode;

/**
 * Created by ykp on 9/26/16.
 */
public class RangeSumQuery303 {

    int[] nums;
    int[][] dp ;

    public RangeSumQuery303(int[] nums){
        this.nums = nums;
        dp = new int[nums.length][nums.length];
        populateDp();
    }

    public void populateDp(){

        dp[0][0] = nums[0];

        for(int i=1;i < nums.length;i++){
            dp[0][i] = dp[0][i-1] + nums[i];
        }

        for(int i=1;i < nums.length;i++){
            for(int j=i;j < nums.length;j++){
                dp[i][j] = dp[0][j] - dp[0][i];
            }
        }
    }

    public int sumRange(int i, int j){
        if(i > j){
            return Integer.MIN_VALUE;
        }
        return dp[i][j];
    }

    public static void main(String[] args){
        int[] nums = {-2,0,3,-5,2,-1};
        RangeSumQuery303 range = new RangeSumQuery303(nums);
        System.out.println(range.sumRange(2,2));
    }
}
