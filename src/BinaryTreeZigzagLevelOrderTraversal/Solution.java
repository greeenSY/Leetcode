package BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class Solution {

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		if(root==null)
			return re;
		Stack<TreeNode> s = new Stack<TreeNode>();
		Stack<TreeNode> sNext = new Stack<TreeNode>();
		int odd = 1;
		sNext.push(root);
		while(!sNext.isEmpty()){
			s.addAll(sNext);
			sNext.clear();
			List<Integer> level = new ArrayList<Integer>();
			while(!s.isEmpty()){
				TreeNode tmp = s.pop();
				level.add(tmp.val);
				if(odd == 1){
					if(tmp.left != null)
						sNext.push(tmp.left);
					if(tmp.right != null)
						sNext.push(tmp.right);
				}else{
					if(tmp.right != null)
						sNext.push(tmp.right);
					if(tmp.left != null)
						sNext.push(tmp.left);
				}
			}
			odd *= -1;
			re.add(level);
		}
		return re;
	        
	    }
	public static void main(String[] args) {
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(20);
		TreeNode c = new TreeNode(9);
		TreeNode d = new TreeNode(15);
		TreeNode e = new TreeNode(7);
		a.left = c; a.right = b;
		b.left = d; b.right = e;
		System.out.println(zigzagLevelOrder(a));
		

	}

}
