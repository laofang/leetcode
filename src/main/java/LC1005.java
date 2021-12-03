import java.util.Arrays;

/**
 * Leetcode1005题，K次取反后最大化的数组和
 * 关键字：数组、贪心、排序
 * 主要思路：
 * 1. 先排序，然后从小到达，如果有反转次数，且是负数就反转，反转次数为0就正常相加
 * 2. 如果反转到正数了，那就再排序（找到最小的就行），只对最小的反转，如果最小的是0或是偶次数反转，不用变
 */
public class LC1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int i = 0;
        int target = nums[0];
        while(i < nums.length) {
            //如果k在正负交界处还能反转，反转后的最小值，可能是分界负数和正数的绝对值的最小值
            if(i > 0 && k > 0 && nums[i] >= 0 && nums[i-1] < 0) {
                target = Math.min(nums[i],-nums[i-1]);
            }
            //有反转次数，且当前数小于0，反转
            if (k > 0 && nums[i] < 0) {
                sum += -nums[i];
                k--;
                //始终是负数的话，绝对值最小就是负数值最大的那个
                target = nums[i];
            } else {
                sum += nums[i];
            }
            i++;
        }
        //反转次数没用完，且还剩奇次反转，那就将最小值反转，结果减去这个值*2即可
        if(k > 0 && k % 2 != 0) {
            sum -= 2 * Math.abs(target);
        }
        return sum;
    }
}
