import structure.TreeNode;

/**
 * Leetcode654题，最大二叉树
 * 关键字：栈、树、数组、分治、二叉树、单调栈
 * 主要思路：
 * 1. 使用递归分治的方式来构造二叉树
 * 2. 获取范围内最大值索引，根据最大索引构造根节点，再将索引两侧分成两个部分，进行递归
 */
public class LC654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTree(nums,0,nums.length);
    }
    public TreeNode constructTree(int[] nums,int start,int end) {
        if(start >= end) return null;
        int index = getRangeMaxIndex(nums, start, end);
        TreeNode node = new TreeNode(nums[index]);
        node.left = constructTree(nums,start,index);
        node.right = constructTree(nums,index+1, end);
        return node;
    }
    public int getRangeMaxIndex(int[] nums, int start, int end) {
        if(start >= end) return -1;
        int max = -1;
        int index = -1;
        for(int i = start; i < end; i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
