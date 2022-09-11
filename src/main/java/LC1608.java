import java.util.Arrays;

/**
 * Leetcode1608题，特殊数组的特征值
 * 关键字：数组、二分查找、排序
 * 主要思路：
 * 1. 先排序，然后遍历每个元素，根据当前元素，以及后面的元素数量，来判断x的值
 */
public class LC1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0;i < nums.length; i++) {
            if(i == 0 && nums[i] >= nums.length - i) return nums.length-i;
            if(i > 0 && nums[i] >= nums.length - i && nums.length - i > nums[i-1]) return nums.length-i;
        }
        return -1;
    }
}
