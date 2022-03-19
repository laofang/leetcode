import structure.TreeNode;

/**
 * Leetcode606题，根据二叉树创建字符串
 * 关键字：树、深度优先搜索、二叉树、字符串
 * 主要思路：
 * 1. 当前节点分为四种情况：
 *      1. 左右子树都存在，需要左右子树分别加上括号
 *      2. 只有右子树存在，左子树直接就是'()'，右子树左右加括号
 *      3. 只有左子树存在，右子树不用管，左子树左右加括号
 *      4. 左右子树都不存在，不用管
 */
public class LC606 {
    public String tree2str(TreeNode root) {
        if(root == null) return "";
        StringBuilder ans = new StringBuilder();
        ans.append(root.val);
        if(root.left != null && root.right != null) {
            ans.append("(").append(tree2str(root.left)).append(")");
            ans.append("(").append(tree2str(root.right)).append(")");
        } else if(root.left == null && root.right != null) {
            ans.append("()");
            ans.append("(").append(tree2str(root.right)).append(")");
        } else if(root.left != null && root.right == null) {
            ans.append("(").append(tree2str(root.left)).append(")");
        }
        return ans.toString();

    }
}
