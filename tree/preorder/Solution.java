package tree.preorder;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for binary tree
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if (root==null) return result;
        Stack <TreeNode> s=new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()){
            TreeNode n=s.pop();
            result.add(n.val);
            if (n.right!=null) s.push(n.right);
            if (n.left!=null) s.push(n.left);
        }
        return result;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(5);
		TreeNode t5 = new TreeNode(6);
		TreeNode t6 = new TreeNode(7);
		TreeNode t7 = new TreeNode(8);
		root.left = t1;
		root.right = t2;
		t1.left = t3;
		t1.right = t4;
		t2.left = t5;
		t5.left = t6;
		t6.right = t7;
		Solution s  = new Solution();
		ArrayList<Integer> output = s.preorderTraversal(root);
		for(int i=0;i<output.size();i++){
			System.out.println(output.get(i));
		}
	}
}

