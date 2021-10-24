import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode40题，组合总和II
 * 关键字：回溯
 * 主要思路：
 * 1. 和上一题的思路基本相同，主要注意同一层次不要进行重复数字的尝试
 */
public class LC40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        //先排序
        Arrays.sort(candidates);
        traceBack(candidates,0,0,temp,res,target);
        return res;

    }
    public void traceBack(int nums[],int k,int sum,List<Integer> temp,List<List<Integer>> res,int target) {
        //结束条件
        if(sum > target) {
            return;
        }
        if(sum == target) {
            List<Integer> l = new LinkedList<>();
            for(Integer i : temp) {
                l.add(i);
            }
            res.add(l);
            return;
        }

        for(int i = k ; i < nums.length; i++) {
            //剪枝
            //避免同一层进行重复尝试
            if( i > k && nums[i-1] == nums[i]) continue;
            if(sum + nums[i] > target) break;
            //尝试
            temp.add(nums[i]);
            sum = sum + nums[i];
            traceBack(nums,i+1,sum,temp,res,target);
            //回溯
            temp.remove(temp.size() - 1);
            sum = sum - nums[i];
        }

    }
}
