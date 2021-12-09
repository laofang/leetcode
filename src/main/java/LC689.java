/**
 * Leetcode689题，三个无重叠子数组的最大和
 * 关键字：动态规划、前缀和、窗口
 * 主要思路：
 * 1. 三个子数组的长度为k，初始位置为[0,k-1]、[k,2k-1]、[2k,3k-1]
 * 2. 然后整体移动，计算新的位置第一子数组，第一、二子数组、一、二、三子数组的和是否比记录的最大还大
 * 3. 如果大就进行更新，更新需要注意，在更新一、二子数组和的时候，要保存此时的一最大坐标，同理，在更新一、二、三子数组和时候，要保存此时的第二子数组的坐标，和对应的第一数组坐标
 */
public class LC689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = new int[]{0, k, 2 * k};
        int maxSum1 = 0;
        int maxSum12 = 0;
        int maxSum123 = 0;
        //三个子数组初始状态
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                maxSum1 += nums[i];
                maxSum12 = maxSum1;
            }
            if (i >= k && i < 2 * k) {
                maxSum12 += nums[i];
                maxSum123 = maxSum12;
            }
            if (i >= 2 * k && i < 3 * k) {
                maxSum123 += nums[i];
            }
        }
        int sum1 = maxSum1;
        int sum2 = maxSum12 - maxSum1;
        int sum3 = maxSum123 - maxSum12;
        //a是更新maxSum12时的子数组一的位置
        //b时更新maxSum123时的，maxSum12对应的子数组一的位置
        //c是更新maxSum123时，子数组二的位置
        int a = ans[0], b = ans[0], c = ans[1];
        for (int i = 0; i < nums.length - 3 * k; i++) {
            //除头加尾
            sum1 = sum1 - nums[i] + nums[k + i];
            //如果大于maxSum1
            if (sum1 > maxSum1) {
                maxSum1 = sum1;
                //更新位置，更新不会对后面的产生影响
                ans[0] = i + 1;
            }
            //同上
            sum2 = sum2 - nums[k + i] + nums[2 * k + i];
            if (maxSum1 + sum2 > maxSum12) {
                maxSum12 = maxSum1 + sum2;
                ans[1] = k + i + 1;
                //更新使maxSum12最大的，子数组1的位置，更新不会对后面的产生影响
                a = ans[0];

            }
            //同上
            sum3 = sum3 - nums[2 * k + i] + nums[3 * k + i];
            if (maxSum12 + sum3 > maxSum123) {
                maxSum123 = maxSum12 + sum3;
                ans[2] = 2 * k + i + 1;
                //更新使maxSum123最大的子数组1的位置
                b = a;
                //个更新使maxSum123最大的子数组2的位置
                c = ans[1];
            }
//            System.out.println(sum1 + " " +sum2 + " " +sum3 + " " + maxSum1 + " " + maxSum12 + " " + maxSum123);
        }
        return new int[]{b, c, ans[2]};
    }
}
