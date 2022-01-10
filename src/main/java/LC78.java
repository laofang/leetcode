import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode78题，子集
 * 关键字：回溯、组合
 * 主要思路：
 * 1. 就是对n个元素的集合，分别求1个元素、2个元素……n个元素的组合
 * 2. 最后加上一个空集即可
 */
public class LC78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans =new LinkedList<List<Integer>>();

        for(int k = 1; k <= nums.length;k++) {
            int[] res = new int[k];
            traceBack(0, 0, nums.length-1 ,nums, k, ans, res);
        }
        ans.add(new LinkedList<>());
        return ans;
    }
    public void traceBack(int start, int count, int n,int[] nums, int k, List<List<Integer>> ans, int[] res) {
        if(count == k) {
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < res.length; i++) {
                list.add(res[i]);
            }
            ans.add(list);
            return;
        }
        for(int i = start; i <= n - k + count+1;i++) {
            res[count] = nums[i];
            traceBack(i+1,count+1,n,nums,k,ans,res);
//            res[count] = 0;
        }
    }
}
