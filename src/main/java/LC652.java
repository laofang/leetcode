import structure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode652题，寻找重复的子树
 * 关键字：树、深度优先搜索、二叉树、哈希表
 * 主要思路：
 * 1. 对以每个节点为根的树进行序列化，并用Map进行存储
 * 2. 查看是否有相同序列化的结果，如果有则加入答案，只加一次
 */
public class LC652 {
    Map<String, TreeNode> map = new HashMap<>(20000);
    Map<String,Boolean> mapUsed = new HashMap<>(20000);

    List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);

        return list;

    }
    public String f(TreeNode root) {
        if(root == null) return "nal";
        return root.val + "(" + f(root.left) + ")" + "(" + f(root.right) + ")";
    }
    public void dfs(TreeNode root) {
        if(root == null) return;

        String s = f(root);

        if(map.get(s) != null) {
            if(!mapUsed.get(s)) {
                list.add(root);
                mapUsed.put(s,true);
            }
        } else {
            map.put(s,root);
            mapUsed.put(s,false);
        }

        dfs(root.left);
        dfs(root.right);
    }
}
