/**
 * Leetcode559题，N叉树的最大深度
 * 关键字：树、树深度、递归
 * 主要思路：
 * 1. 递归求得最深长度的子树
 */
public class LC559 {
    public int maxDepth(Node root) {
        //如果树是null返回0
        if(root == null) {
            return 0;
        }
        //如果子树空，返回1
        if(root.children == null) {
            return 1;
        }
        int max = 0;
        //最大子树深度
        for(Node node : root.children) {
            max = Math.max(maxDepth(node),max);
        }
        //1 + 最大深度就是答案
        return 1 + max;
    }
}
