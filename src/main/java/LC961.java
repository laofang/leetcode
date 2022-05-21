/**
 * Leetcode961题，在长度2N的数组中找出重复N次的元素
 * 关键字：数组、哈希表
 * 主要思路：
 * 1. 遍历，对每个数字出现的次数进行记录
 */
public class LC961 {
    public int repeatedNTimes(int[] nums) {
        int[] counts = new int[10000];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
            if(counts[nums[i]] >= (int)nums.length / 2) {
                return nums[i];
            }
        }
        return 0;
    }
}
