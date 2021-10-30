import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Leetcode47题，全排列II
 * 关键字：全排列、数组、回溯
 * 主要思路：
 * 1. 在上一题的基础上，加一个判断条件，同一层交换的时候，不允许相同的元素和目标元素交换超过一次
 */
public class LC47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        LinkedList<Integer> cur = new LinkedList<>();
        trackBack(nums,0,res,cur);
        return res;
    }
    /**
     * 全排列的回溯算法
     * @param nums 待全排列的数组
     * @param index 当前排到的位置
     * @param res 最终结果
     * @param cur 临时存储一次全排列的结果
     */
    public void trackBack(int[] nums, int index, List<List<Integer>> res, LinkedList<Integer> cur) {
        //如果当前结果中的元素和数组长度相等，说明已经达成一次全排列
        if(cur.size() == nums.length) {
            List<Integer> l = new LinkedList<>();
            for(int v : cur) {
                l.add(v);
            }
            res.add(l);
            return;
        }
        Map<Integer,Integer> logM = new HashMap();
        for(int i = index ; i < nums.length; i++) {
            //每一层，如果将要交换的数字，之前已经交换过，则不必再交换
            if(logM.get(nums[i]) != null) continue;
            logM.put(nums[i],nums[i]);
            //从当前位置开始，和自身以及其后的进行交换
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            cur.add(nums[index]);
            //当前位之后的数组进行同样的操作
            trackBack(nums,index+1,res,cur);
            //回溯，再换回来
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            cur.removeLast();
        }
    }
}
