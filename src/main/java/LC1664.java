/**
 * Leetcode1664题，生成平衡数组的方案数
 * 关键字：数组、动态规划
 * 主要思路：
 * 1. 计算前缀奇数和前缀偶数和，再计算后缀奇数和和后缀偶数和
 * 2. 遍历nums[i]，计算每个位置前后的奇数和和偶数和，来判断是否是平衡数组
 */
public class LC1664 {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] pOdd = new int[n+1];
        int[] pEven = new int[n+1];
        int[] lOdd = new int[n+1];
        int[] lEven = new int[n+1];

        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                if(i == 0) {
                    pEven[i] = nums[i];
                } else {
                    pEven[i] = pEven[i-2] + nums[i];
                    pOdd[i] = pOdd[i-1];
                }
            } else {
                if(i == 1) {
                    pOdd[i] = nums[i];
                } else {
                    pOdd[i] = pOdd[i-1] + nums[i];
                }
                pEven[i] = pEven[i-1];
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            if( i % 2 == 0) {
                if(i == n - 1) {
                    lEven[i] = nums[i];
                } else {
                    lEven[i] = nums[i] + lEven[i + 2];
                    lOdd[i] = lOdd[i+1];
                }
            } else {
                if(i == n - 1) {
                    lOdd[i] = nums[i];
                } else {
                    lOdd[i] = nums[i] + lOdd[i + 2];
                    lEven[i] = lEven[i+1];
                }
            }
        }

        int ans = 0;
        for(int i = 0;i < n; i++) {
            if(pOdd[i] + lEven[i] == pEven[i] + lOdd[i]) {
                ++ans;
            }
        }
        return ans;
    }
}
