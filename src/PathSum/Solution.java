package PathSum;



public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	 
	public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
        	return false;
        else if(root.val == sum && root.left == null && root.right == null)
        	return true;
        else 
        	return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode t = s.new TreeNode(5);
		TreeNode t4 = s.new TreeNode(4);
		TreeNode t8 = s.new TreeNode(8);
		t.left = t4;t.right = t8;
		TreeNode t11 = s.new TreeNode(11);
		t4.left = t11;
		TreeNode t13 = s.new TreeNode(13);
		t8.left = t13;
		TreeNode t42 = s.new TreeNode(4);
		t8.right = t42;
		TreeNode t7 = s.new TreeNode(7);
		TreeNode t2 = s.new TreeNode(2);
		t11.left = t7;t11.right = t2;
		TreeNode t1 = s.new TreeNode(1);
		t42.right = t1;
		
		System.out.println(hasPathSum(t,22));
		
	}

}
