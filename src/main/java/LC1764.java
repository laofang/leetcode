/**
 * Leetcode1764题，通过连接另一个数组的子数组得到一个数组
 * 关键字：贪心、数组、字符串匹配
 * 主要思路：
 * 1. 采用了暴力循环的方式
 * 2. 使用KMP算法可以优化，但是不想写KMP算法
 */
public class LC1764 {
    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0;
        int j = 0;
        while(i < groups.length && j < nums.length) {
            int k = 0;
            int t = j;
            while(k < groups[i].length && j < nums.length && groups[i][k] == nums[j]) {
                k++;
                j++;
            }
            if(k == groups[i].length) {
                i++;
            } else{
                j = t + 1;
            }
        }
        return i == groups.length;
    }
}
