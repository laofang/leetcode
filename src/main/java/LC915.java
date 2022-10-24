/**
 * Leetcode915题，分割数组
 * 关键字：数组
 * 主要思路：
 * 1. 计算[0,0],[0,1]……[0,n]每一个的最大值
 * 2. 计算[n,n],[n-1,n]……[0,n]每一个最小值
 * 3. 找到[0,k]最大值，小于[k+1,n]最小值的，k最小的位置
 */
public class LC915 {
    public int partitionDisjoint(int[] nums) {
        int[] rMin = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for(int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min,nums[i]);
            rMin[i] = min;
        }
        int max = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max,nums[i]);
            if(max <= rMin[i+1]) return  i + 1;
        }
        return -1;
    }
}
