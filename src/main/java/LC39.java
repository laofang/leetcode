import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode39题，组合总数
 * 关键字：回溯
 * 主要思路：
 * 1. 回溯法，来找到和为target的元素
 * 2. 每一层都都可以用上一层的元素以及之后的元素
 * 3. 每次尝试+新元素，如果大于target，直接剪枝
 */
public class LC39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        traceBack(candidates,0,0,temp,res,target);
        return res;

    }
    public void traceBack(int nums[],int k,int sum,List<Integer> temp,List<List<Integer>> res,int target) {
        //结束条件，和已经等于target
        if(sum == target) {
            List<Integer> l = new LinkedList<>();
            for(Integer i : temp) {
                l.add(i);
            }
            res.add(l);
            return;
        }

        for(int i = k ; i < nums.length; i++) {
            //剪枝，相加已经大于target
            if(sum + nums[i] > target) continue;
            //尝试
            temp.add(nums[i]);
            sum = sum + nums[i];
            traceBack(nums,i,sum,temp,res,target);
            //回溯
            temp.remove(temp.size() - 1);
            sum = sum - nums[i];
        }

    }
}
