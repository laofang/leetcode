import java.util.Arrays;

/**
 * Leetcode462题，最少移动次数使数组元素相等
 * 关键字：数组、数学、排序
 * 主要思路：
 * 1. 可以将每个元素看成数轴上的点
 * 2. 假设存在两点为x和y,且 x < y，他们到数轴上k点的最小距离，即是k在[x,y]上，此时的距离即是y - x;
 * 3. 所以有奇数个元素时，在中位数上；偶数个元素时，可以是两个中位数点区间上的任意一点
 * 4. min = (nums[n] - nums[0]) + (nums[n-1] + nums[1]) + ...... + (nums[n - i] + nums[i])
 */
public class LC462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < nums.length - i - 1;i++) {
            ans += nums[nums.length - i - 1] - nums[i];
        }
        return ans;
    }
}
