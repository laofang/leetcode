/**
 * Leetcode1709题，第k个数
 * 关键字：哈希表、数学、动态规划、堆（优先队列）
 * 主要思路：
 * 1. 可以看成三条有序链表的合并
 * 2. 三条链表如下
 *      1. 3 * nums[0], 3 * nums[1], 3 * nums[2] ……
 *      2. 5 * nums[0], 5 * nums[1], 5 * nums[2] ……
 *      3. 7 * nums[0], 7 * nums[1], 7 * nums[2] ……
 */
public class LCInterview1709 {
    public int getKthMagicNumber(int k) {
        int p3 = 0,p5 = 0, p7 = 0;
        int[] nums = new int[k];
        nums[0] = 1;
        for(int i = 1; i < k; i++) {
            nums[i] = Math.min(nums[p3] * 3,Math.min(nums[p5] * 5,nums[p7] * 7));
            //这里只要是和最小的相等的指针都会+1，避免了重复的情况
            if(nums[i] == nums[p3] * 3) ++p3;
            if(nums[i] == nums[p5] * 5) ++p5;
            if(nums[i] == nums[p7] * 7) ++p7;
        }
        return nums[k-1];
    }

}
