import structure.TreeNode;

/**
 * Leetcode108题，将有序数组转换为二叉搜索树
 * 关键字：树、二叉树、二叉搜索树、平衡二叉树、递归、分治
 * 主要思路：
 * 1. 二分，数组中间的数字为根，然后左子树连接左子树的根，右侧连接右子树的根
 * 2. 对数组左侧和右侧继续执行1的操作
 */
public class LC108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return getTree(nums,0,nums.length-1);
    }

    public TreeNode getTree(int[] nums,int s,int e) {
        if(s >= e) {
            return new TreeNode(nums[s]);
        }
        int half = (s + e) / 2;
        TreeNode root = new TreeNode(nums[half]);
        if(s < half) {
            root.left = getTree(nums,s,half-1);
        }
        if(e > half ) {
            root.right = getTree(nums,half+1,e);
        }
        return root;
    }
}
