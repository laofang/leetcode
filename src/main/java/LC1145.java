import structure.TreeNode;

/**
 * Leetcode1145题，二叉树着色游戏
 * 关键字：树、深度优先搜索、二叉树
 * 主要思路：
 * 1. 先找到x的节点
 * 2. 作为玩家2，可以选择x邻近的节点作为初始节点，这有三个选择，x的父节点以及左右子节点
 * 3. 要尽量贪心，选择的初始节点一侧的节点数量最大，另外两个方向都属于玩家1
 * 4. 最后判断最多节点的一路，是否大于另两路之和即可
 */
public class LC1145 {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode node = findX(root,x);
        int lCnt = nodeCount(node.left);
        int rCnt = nodeCount(node.right);
        int cnt = n - lCnt - rCnt - 1;
        int maxCnt = Math.max(cnt,Math.max(lCnt,rCnt));
        return maxCnt > n - maxCnt;
    }
    public int nodeCount(TreeNode root) {
        if(root == null) return 0;
        return nodeCount(root.left) + nodeCount(root.right) + 1;
    }
    public TreeNode findX(TreeNode root,int x) {
        if(root == null) return null;
        if(root.val == x) return root;
        TreeNode node = findX(root.left,x);
        if(node != null) return node;
        node = findX(root.right,x);
        return node;
    }
}
