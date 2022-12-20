/**
 * Leetcode1760题，袋子里最少数目的球
 * 关键字：数组、二分查找
 * 主要思路：
 * 1. 用二分查找的方式，尝试每个袋子装1~100000000个球，需要多少个额外的袋子
 * 2. 如果需要的袋子数是maxOperations，且是满足条件的最小的值，就是答案
 */
public class LC1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 1000000000;
        while(left <= right) {
            int half = (left + right) / 2;
            if(getExBags(half,nums) > maxOperations) {
                left = half + 1;
            } else {
                right = half - 1;
            }
        }
        return left;
    }
    public int getExBags(int perCnt,int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += (num + perCnt - 1) / perCnt - 1;
        }
        return sum;
    }
}
