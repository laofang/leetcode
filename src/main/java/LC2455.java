/**
 * Leetcode2455题，可被三整除的偶数的平均值
 * 关键字：数组、数学
 * 主要思路：
 * 1. 模拟
 */
public class LC2455 {
    public int averageValue(int[] nums) {
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0 && nums[i] % 3 == 0) {
                sum += nums[i];
                cnt++;
            }
        }
        return cnt == 0 ? 0 : sum / cnt;
    }
}
