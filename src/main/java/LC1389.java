/**
 * Leetcode1389题，按既定顺序创建目标数组
 * 关键字：数组、模拟
 * 主要思路：
 * 1. 找到位置，从当前位置后移，再插入
 */
public class LC1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int k = index[i];
            int j = i;
            while(j > k) {
                target[j] = target[j-1];
                j--;
            }
            target[k] = val;
        }
        return target;
    }
}
