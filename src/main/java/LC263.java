/**
 * Leetcode263题，丑数
 * 关键字：数学
 * 主要思路：
 * 1. 尝试除2,3,5如果可以完全除，就除
 * 2. 如果三个都不能除，就返回false
 * 3. 直到除到1的情况，返回true
 * 注意：
 * 1. <=0时，返回false
 */
public class LC263 {
    public boolean isUgly(int n) {
        final int[] nums = new int[]{2,3,5};
        if(n <= 0) return false;
        while(n != 1) {
            int i = 0;
            for(; i < nums.length; i++) {
                if(n % nums[i] == 0) {
                    n /= nums[i];
                    break;
                }
            }
            if(i == nums.length) return false;
        }
        return true;
    }
}
