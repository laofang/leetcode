import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode77题，组合
 * 关键字：回溯、排列组合
 * 主要思路：
 * 1. 如果k元素组合，就分为k层进行回溯，每层遍历，后一层在前一层之后开始遍历即可
 */
public class LC77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans =new LinkedList<List<Integer>>();
        int[] res = new int[k];
        traceBack(1,0,n,k,ans,res);
        return ans;
    }
    public void traceBack(int start,int count,int n, int k,List<List<Integer>> ans,int[] res) {
        if(count == k) {
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < res.length; i++) {
                list.add(res[i]);
            }
            ans.add(list);
            return;
        }
        for(int i = start; i <= n - k + count+1;i++) {
            res[count] = i;
            traceBack(i+1,count+1,n,k,ans,res);
        }
    }
}
