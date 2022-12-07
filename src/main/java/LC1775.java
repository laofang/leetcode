/**
 * Leetcode1775题，通过最少操作次数使数组的和相等
 * 关键字：贪心、数组、哈希表、计数
 * 主要思路：
 * 1. 先分别求出两个数组的总和，和两个总和的差的绝对值
 * 2. 和较大的数组，每个数最多可以变换为1；和较小的数组，每个数最多可以变换为6，记录可转换相对值的数量
 * 3. 贪心，从最大的变换5开始，让两个总和的差值，逐渐降到0，在这个过程中用了多少个数的变换，就是答案
 */
public class LC1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        int[] t1 = new int[6];
        int s1 = 0;
        int s2 = 0;
        for(int i = 0; i < nums1.length; i++) {
            s1 += nums1[i];
        }
        for(int i = 0; i < nums2.length; i++) {
            s2 += nums2[i];
        }

        if(s1 == s2) return 0;
        for(int num : s1 > s2 ? nums1 : nums2) {
            t1[num - 1]++;
        }
        for(int num : s1 < s2 ? nums1 : nums2) {
            t1[6-num]++;
        }
        int i = 5;
        int val = Math.abs(s1 - s2);
        int ans = 0;
        while(i > 0) {
            if(val > t1[i] * i) {
                val -= t1[i] * i;
                ans += t1[i];
                --i;
            } else {
                return ans + ((val - 1) / i + 1);
            }
        }
        return -1;
    }
}
