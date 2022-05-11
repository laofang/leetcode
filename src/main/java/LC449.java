import structure.TreeNode;

import java.util.Arrays;

/**
 * Leetcode449题，序列化和反序列化二叉搜索树
 * 关键字：树、深度优先搜索、广度优先搜索、设计、二叉搜索树、字符串、二叉树
 * 主要思路：
 * 1. 还原一棵二叉树，需要知道二叉树的前、中序或者中、后序；
 * 2. 题目中是二叉搜索树，可以按前序遍历进行序列化
 * 3. 解析序列化的字符串，是前序数组，进行排序后，便是中序数组
 * 4. 知道前序和中序就可以进行递归还原
 *      1. 前序数组的第一个元素即是根
 *      2. 中序数组中找到根的位置，根的左侧即是左子树[0,mid-1]，右侧即是右子树[0,mid+1]
 *      3. 前序数组[1,mid]是左子树，[mid+1,length-1]是右子树
 *      4. 对左子树和右子树重复以上过程，直到数组长度为0返回null
 */
public class LC449 {
    public String serialize(TreeNode root) {
        if(root != null) {
            return " " + root.val + serialize(root.left) + serialize(root.right);
        }
        return "";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.trim();
        if(data.equals("")) return null;
        String[] vals = data.split("\\s+");
        int[] preOrder = new int[vals.length];
        for(int i = 0; i < vals.length;i++) {
            preOrder[i] = Integer.valueOf(vals[i]);
        }
        int[] inOrder = (int[])preOrder.clone();
        Arrays.sort(inOrder);
        return generateTree(preOrder,inOrder);
    }
    private TreeNode generateTree(int[] preOrder,int[] inOrder) {
        if(preOrder.length == 0) return null;
        TreeNode root = new TreeNode(preOrder[0]);
        int mid = -1;
        for(int i = 0; i < inOrder.length; i++) {
            if(inOrder[i] == preOrder[0]) {
                mid = i;
                break;
            }
        }

        int[] leftPre = Arrays.copyOfRange(preOrder,1,mid+1);
        int[] rightPre = Arrays.copyOfRange(preOrder,mid+1,preOrder.length);

        int[] leftIn = Arrays.copyOfRange(inOrder,0,mid);
        int[] rightIn = Arrays.copyOfRange(inOrder,mid+1,inOrder.length);

        root.left = generateTree(leftPre,leftIn);
        root.right = generateTree(rightPre,rightIn);
        return root;
    }
}
