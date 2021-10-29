import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode46题，全排列
 * 关键字：数组，回溯
 * 主要思路：
 * 1. 这道题我大学的时候做过，那时候对回溯理解的不够深刻
 * 2. 结合之前做过的回溯题，这道题就比较容易了，可以用递归的方法取理解，全排列就是将第一个数字和其余每个数字交换，再将其余的数字全排
 * 3. 也可以这么理解，每一层的第一个数字都在和前一层交换后的余下数字进行交换
 */
public class LC46 {
    public List<List<Integer>> permute(int[] nums) {
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
    public void trackBack(int[] nums,int index,List<List<Integer>> res, LinkedList<Integer> cur) {
        //如果当前结果中的元素和数组长度相等，说明已经达成一次全排列
        if(cur.size() == nums.length) {
            List<Integer> l = new LinkedList<>();
            for(int v : cur) {
                l.add(v);
            }
            res.add(l);
            return;
        }
        for(int i = index ; i < nums.length; i++) {
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
