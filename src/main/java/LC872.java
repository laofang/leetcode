import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode872题，叶子相近的树
 * 关键字：树、深度优先搜索、二叉树
 * 主要思路：
 * 1. 分别将两棵树的叶子结点，存在两个列表中，在判断这两个列表是否相等
 */
public class LC872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        generateLeafList(root1,list1);
        generateLeafList(root2,list2);
        if(list1.size() != list2.size()) return false;
        for(int i = 0; i < list1.size(); i++) {
            if(list1.get(i) != list2.get(i)) return false;
        }
        return true;
    }

    public void generateLeafList(TreeNode root,List<Integer> list) {
        if(root.left == null && root.right == null) {
            list.add(root.val);
        }
        if(root.left != null) generateLeafList(root.left,list);
        if(root.right != null) generateLeafList(root.right,list);
    }
}
