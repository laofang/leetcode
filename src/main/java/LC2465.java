import java.util.Arrays;

/**
 * Leetcode2465题，不同的平均值数目
 * 关键字：数组、哈希表、双指针、排序
 * 主要思路：
 * 1. 排序，前后元素相加，求不同的和的数量
 */
public class LC2465 {
    public int distinctAverages(int[] nums) {
        int[] map = new int[201];
        int i = 0;
        int j = nums.length - 1;
        int ans = 0;
        Arrays.sort(nums);
        while(i < j) {
            int sum = nums[i++] + nums[j--];
            if(map[sum] == 0) {
                map[sum]++;
                ans++;
            }
        }
        return ans;
    }
}
