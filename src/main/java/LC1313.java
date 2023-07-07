/**
 * Leetcode1313题，解压缩编码列表
 * 关键字：数组
 * 主要思路：
 * 1. 模拟
 */
public class LC1313 {
    public int[] decompressRLElist(int[] nums) {
        int length = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) length += nums[i];
        }
        int[] ans = new int[length];
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                for(int j = 0; j < nums[i]; j++) {
                    ans[index++] = nums[i+1];
                }
            }
        }
        return ans;
    }
}
