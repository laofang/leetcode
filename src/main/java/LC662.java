import structure.TreeNode;

import java.util.Arrays;

/**
 * Leetcode662题，二叉树最大宽度
 * 关键字：树、深度优先搜索、广度优先搜索、二叉树
 * 主要思路：
 * 1. 按二叉树的规律，对节点进行递归编号
 * 2. 编号可能会特别大，所以，每一层的开始要进行重新编号
 *      Integer.MAX_VALUE + 1 = -2147483648
 *      -2147483648 - Integer.MAX_VALUE = 1
 *      只要一层的数量小于 Integer.MAX_VALUE就没问题
 * 3. 每层编号尝试减去每层第一个的编号，更新最大值
 */
public class LC662 {
    int[] la = new int[3001];
    int ans = 0;
    public int widthOfBinaryTree(TreeNode root) {
        Arrays.fill(la,-1);
        searchBinaryTree(root,1,1);
        return ans;
    }
    public void searchBinaryTree(TreeNode root,int num, int layer) {
        if(root == null) return;
        if(la[layer] == -1) la[layer] = num;
        ans = Math.max(ans,num - la[layer] + 1);
        searchBinaryTree(root.left, num * 2, layer+1);
        searchBinaryTree(root.right,num * 2 + 1, layer+1);
    }
}
