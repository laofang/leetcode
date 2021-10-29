import java.util.LinkedList;

/**
 * Leetcode45题，跳跃游戏II
 * 关键字：数组，动态规划
 * 主要思路：
 * 1. 最开始我又想回溯，回溯超时，然后又想动态规划
 * 2. 然后一看题解，小丑就是我自己，直接遍历设置界限，到界限时计数，再更新界限即可
 */
public class LC45 {
    /**
     * 遍历设置界限计数，更新界限
     */
    public int jump(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        int k = 0;
        int max = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            //如果新的界限，已经大于等于最后了，就可以结束了
            if(k >= nums.length - 1) {
                break;
            }
            max = Math.max(max,nums[i] + i);
            //由于第一次就计数1了，所以最后那一跳不加也无所谓了
            if(i == k) {
                count++;
                k = max;
            }
        }
        return count;
    }

    /**
     * 回溯算法，数据量大一点儿就会超时
     */
    public int jumpTrackBack(int[] nums) {
        int[] ans = new int[1];
        if(nums.length <= 1) {
            return 0;
        }
        ans[0] = Integer.MAX_VALUE;
        trackBack(nums,0,ans,new LinkedList<Integer>());
        return ans[0];
    }
    public void trackBack(int[] nums, int index, int[] curMin, LinkedList<Integer> res) {
        if(index + nums[index] >= nums.length - 1) {
            if(res.size() + 1 < curMin[0]) {
                curMin[0] = res.size() + 1;
            }
            return;
        }
        int k = nums[index];
        for(int i = nums[index]; i > 0; i-- ) {
            //尝试每一个
            if(res.size() + 1 > curMin[0]) {
                return;
            }
            res.add(i+index);

            trackBack(nums,i+index,curMin,res);
            //回溯
            res.removeLast();
        }

    }
}
