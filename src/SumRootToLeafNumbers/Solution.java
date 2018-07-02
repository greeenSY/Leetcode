package SumRootToLeafNumbers;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {

	public static int sumNumbers(TreeNode root) {
		if(root==null)
			return 0;
		Stack<TreeNode> s = new Stack<TreeNode>();
		int res=0;
		TreeNode tmp;
		s.push(root);
		while(!s.isEmpty()){
			tmp = s.pop();
			if(tmp.left == null && tmp.right == null){
				res += tmp.val;
			}
			if(tmp.left != null){
				tmp.left.val += tmp.val*10;
				s.push(tmp.left);
			}
			if(tmp.right != null){
				tmp.right.val += tmp.val*10;
				s.push(tmp.right);
			}
		}
		return res;
        
    }
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(3);
		System.out.println(sumNumbers(t));

	}

}
