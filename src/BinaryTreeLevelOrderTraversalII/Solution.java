package BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	//Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode tmp = null;
		if(root == null)
			return result;
		queue.add(root);
		while(!queue.isEmpty()){
			ArrayList<Integer> level = new ArrayList<Integer>();
			int n = queue.size();
			for(int i = 0; i < n; i++){
				tmp = queue.poll();
				level.add(tmp.val);
				if(tmp.left != null) queue.add(tmp.left);
				if(tmp.right != null) queue.add(tmp.right);
			}
			result.add(0, level);
		}
		return result;
	        
	}
	public static void main(String[] args) {
		Solution tmp = new Solution();
		TreeNode a = tmp.new TreeNode(1);
		a.left = tmp.new TreeNode(2);
		TreeNode b = tmp.new TreeNode(3);
		a.right = b;
		TreeNode c = tmp.new TreeNode(4); 
		b.left = c;
		c.right = tmp.new TreeNode(5); 
		System.out.println(levelOrderBottom(a));

	}

}
