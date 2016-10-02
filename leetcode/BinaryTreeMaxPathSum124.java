package leetcode;

/**
 * Created by ykp on 9/26/16.
 */
public class BinaryTreeMaxPathSum124 {

    public static int max = Integer.MIN_VALUE;

    public int getMaxPathSum(TreeNode root){
        if (root == null) return 0;
        int left = Math.max(0, getMaxPathSum(root.left));
        int right = Math.max(0, getMaxPathSum(root.right));
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    public int maxPathSum(TreeNode root) {

        if(root.left == null && root.right == null){
            return root.val;
        }

        max = Integer.MIN_VALUE;
        getMaxPathSum(root);

        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public static void main(String[] args){
        BinaryTreeMaxPathSum124 bin = new BinaryTreeMaxPathSum124();
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-1);
        System.out.println(bin.maxPathSum(root));
    }

}
