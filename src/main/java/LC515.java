import structure.TreeNode;

import java.util.*;

/**
 * Leetcode515题，在每个树行中找最大值
 * 关键字：树、深度优先搜索、广度优先搜索、二叉树
 * 主要思路：
 * 1. bfs，按层次遍历，每次层次循环，都选出当前层次最大的，加入答案
 * 2. dfs，深度遍历过程中，加入一个层次参数，用hashMap记录当前已遍历层次最大值，然后每次遍历根据比较结果，进行更新
 */
public class LC515 {

    Map<Integer,Integer> map = new HashMap<>();
    //DFS版
    public List<Integer> largestValuesDFS(TreeNode root) {
        List<Integer> ans  = new ArrayList<>();
        dfs(root,0);
        int i = 0;
        Integer temp;
        while( (temp = map.get(i++)) != null) {
            ans.add(temp);
        }
        return ans;
    }
    public void dfs(TreeNode root, int layer) {
        if(root != null) {
            Integer temp = map.getOrDefault(layer,Integer.MIN_VALUE);
            if(root.val >= temp) {
                map.put(layer,root.val);
            }
            dfs(root.left,layer+1);
            dfs(root.right,layer+1);
        }
    }

    //BFS版
    public List<Integer> largestValuesBFS(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            q.offer(null);
            int max = Integer.MIN_VALUE;
            while(q.peek() != null) {
                TreeNode temp = q.poll();
                max = Math.max(max,temp.val);
                if(temp.left != null) {
                    q.offer(temp.left);
                }
                if(temp.right != null) {
                    q.offer(temp.right);
                }
            }
            q.poll();
            ans.add(max);
        }
        return ans;
    }

}
