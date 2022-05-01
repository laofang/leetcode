import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode1305题，两棵二叉搜索树中的所有元素
 * 关键字：树、二叉树、二叉搜索树、深度优先搜索、排序
 * 主要思路：
 * 1. 树的中序遍历 + 归并
 * 2. 中序遍历二叉搜索树，访问顺序就是正序排列，加入List
 * 3. 再将两棵树构成的List进行归并排序
 */
public class LC1305 {
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        getSearch(root1,l1);
        getSearch(root2,l2);

//        return merge(l1,l2);

        List<Integer> ans = new LinkedList<>();
        int i = 0;
        int j = 0;
        while(i < l1.size() && j < l2.size()) {
            if(l1.get(i) <= l2.get(j)) {
                ans.add(l1.get(i++));
            } else {
                ans.add(l2.get(j++));
            }
        }
        if(i < l1.size()) {
            ans.addAll(l1.subList(i,l1.size()));
        }
        if(j < l2.size()) {
            ans.addAll(l2.subList(j,l2.size()));

        }
        return ans;
    }
    public void getSearch(TreeNode root,List<Integer> list) {
        if(root != null) {
            getSearch(root.left,list);
            list.add(root.val);
            getSearch(root.right,list);
        }
    }
    public List<Integer> merge(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        if(l1.size() == 0) {
            return l2;
        }
        if(l2.size() == 0) {
            return l1;
        }
        Integer temp;
        if(l1.get(0) <= l2.get(0)) {
            temp = l1.poll();
        } else {
            temp = l2.poll();
        }
        List<Integer> ret = new LinkedList<>();
        ret.add(temp);
        ret.addAll(merge(l1,l2));
        return ret;
    }
}
