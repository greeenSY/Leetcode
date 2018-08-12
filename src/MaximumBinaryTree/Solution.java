package MaximumBinaryTree;

import sun.reflect.generics.tree.Tree;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            if(left!=null) {
                System.out.println(left);
            }
            if(right!=null) {
                System.out.println(right);
            }
            return Integer.toString(val);
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildMax(nums, 0, nums.length-1);
    }

    private TreeNode buildMax(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int max=start;
        for(int i=start; i<=end; i++){
            if(nums[i] > nums[max]){
                max = i;
            }
        }
        TreeNode node = new TreeNode(nums[max]);
        node.left = buildMax(nums, start, max-1);
        node.right = buildMax(nums, max+1, end);

        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {3, 2, 1, 6, 0, 5};
        System.out.println(solution.constructMaximumBinaryTree(array));
    }

}
