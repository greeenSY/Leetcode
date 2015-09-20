package ConstructBinaryTreefromPreorderandInorderTraversal;

/**
 * Created by Green on 2015/9/20.
 */
public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;
        if(n==0 || inorder.length != n){
            return null;
        }
        TreeNode root,tmp;
        root = new TreeNode(preorder[0]);
        tmp = root;
        int i = 0;
        for(; i<n; i++){
            if(inorder[i] == preorder[0])
                break;
        }
        int[] preorderLeft = new int[i];
        for(int j=0; j<i; j++){
            preorderLeft[j] = preorder[j+1];
        }
        int[] preorderRight = new int[n-i-1];
        for(int j=0; j<n-1-i; j++){
            preorderRight[j] = preorder[i+j+1];
        }
        int[] inorderLeft = new int[i];
        for(int j=0; j<i; j++){
            inorderLeft[j] = inorder[j];
        }
        int[] inorderRight = new int[n-1-i];
        for(int j=0; j<n-1-i; j++){
            inorderRight[j] = inorder[i+j+1];
        }
        root.left = buildTree(preorderLeft,inorderLeft);
        root.right = buildTree(preorderRight,inorderRight);

        return root;
    }

    public void printTree(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] pre = {1,2,3};
        int[] in = {1,2,3};
        TreeNode res = s.buildTree(pre, in);

        s.printTree(res);
    }

}
