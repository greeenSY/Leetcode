package FlattenBinaryTreeToLinkedList;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

	public static void flatten(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> sk = new Stack<TreeNode>();  
		TreeNode tmp = root;
		while(tmp != null){
			while(tmp.left!=null){
				if(tmp.right != null)
					sk.push(tmp.right);
				tmp.right = tmp.left;
				tmp.left = null;
				tmp = tmp.right;
			}
			if(tmp.right == null && !sk.isEmpty())
				tmp.right = sk.pop();
			tmp = tmp.right;
		}
		
			
		/*if(root == null)
			return;
		TreeNode re = new TreeNode(0);
		TreeNode tmp,s;
		s = re;
		Stack<TreeNode> sk = new Stack<TreeNode>();  
		sk.push(root);
		while(!sk.isEmpty()){
			tmp = sk.pop();
			if(tmp.right != null)
				sk.push(tmp.right);
			if(tmp.left != null)
				sk.push(tmp.left);
			
			s.right = tmp;
			s = tmp;
		}
		root =  re.right;
		*/
    }
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t1.left = t2;t1.right = t5;
		t2.left = t3;t2.right = t4;
		t5.right = t6;
		
		flatten(t1);
		TreeNode t = t1;
		while(t != null){
			System.out.println(t.val);
			t = t.right;
		}
	}

}
