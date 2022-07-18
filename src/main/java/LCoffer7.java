import structure.TreeNode;

import java.util.Arrays;

/**
 * Leetcode 剑指offer 07题，重建二叉树
 * 关键字：树、数组、哈希表、分治、二叉树
 * 主要思路：
 * 1. 前序遍历数组可以找到根
 * 2. 中序遍历数组，可以从根分出左右子树
 * 3. 同时中序根位置，也刚好能将前序遍历数组分为左右子树
 */
public class LCoffer7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int val = preorder[0];
        int index = 0;

        for (int i = 0; i < inorder.length; i++) {
            if(val == inorder[i]) {
                index = i;
                break;
            }
        }
        TreeNode node = new TreeNode(val);

        if(index == 0) {
            node.left = null;
        } else {
            int[] preLeft = Arrays.copyOfRange(preorder,1,index+1);
            int[] inoLeft = Arrays.copyOfRange(inorder,0,index);
            node.left = buildTree(preLeft,inoLeft);
        }

        if(index+1 >= inorder.length) {
            node.right = null;
        } else {
            int[] preRight = Arrays.copyOfRange(preorder,index+1,preorder.length);
            int[] inoRight = Arrays.copyOfRange(inorder,index+1,inorder.length);
            node.right = buildTree(preRight,inoRight);
        }
        return node;
    }
}
