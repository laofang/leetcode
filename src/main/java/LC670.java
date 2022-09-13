/**
 * Leetcode670题，最大交换
 * 关键字：贪心、数学
 * 主要思路：
 * 1. 从低位到高位，一个动态数组，存储低n位中的最大值的索引，值相同时，存储更低位的索引
 * 2. 然后从高位到低位，如果当前高位的值，小于高位到低位中的最大值，则进行交换
 */
public class LC670 {
    public int maximumSwap(int num) {
        int[] dp = new int[String.valueOf(num).length()];
        int[] nums = new int[dp.length];
        int index = 0;
        int max = -1;
        while(num != 0) {
            int v = num % 10;
            num /= 10;
            nums[index] = v;
            if(v > max) {
                dp[index++] = index-1;
                max = v;
            } else {
                dp[index] = dp[index - 1];
                index++;
            }
        }
        for(int i = nums.length-1; i >= 0; i--) {
            if(dp[i] != i && nums[i] != nums[dp[i]]) {
                int temp = nums[i];
                nums[i] = nums[dp[i]];
                nums[dp[i]] = temp;
                break;
            }
        }
        int ans = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            ans = ans * 10 + nums[i];
        }
        return ans;
    }
}
