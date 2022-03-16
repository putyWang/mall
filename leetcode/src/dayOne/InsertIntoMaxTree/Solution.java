package dayOne.InsertIntoMaxTree;

import base.tree.TreeNode;

public class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val){
        if(root == null || val > root.val)
            return new TreeNode(val,root,null);

        //当根节点值小于val时，将根节点的值加入递归函数中
        else
            root.right = insertIntoMaxTree(root.right,val);

        return root;
    }
}
