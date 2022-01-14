/**
 * Leetcode80题，删除有序数组中的重复项II
 * 关键字：去重、数组
 * 主要思路：
 * 1. 两个指针，当前指针如果和前一个位置相同，count++;
 * 2. 如果count < 2也就是没有连续三个相同，后一个指针覆盖前一个指针就可
 * 3. count >= 2的时候，前一个指针就不动，等待出现不同的进行覆盖
 */
public class LC80 {
    public int removeDuplicates(int[] nums) {
        int o = 1;
        int c = 1;
        int count = 0;
        for(c = 1; c < nums.length;c++) {
            if(nums[c] == nums[c-1]) {
                count++;
            } else {
                count = 0;
            }
            if(count < 2) {
                nums[o++] = nums[c];
            }
        }
        return o;
    }
}
