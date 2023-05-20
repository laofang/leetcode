import java.util.Arrays;

/**
 * Leetcode977题，有序数组的平方
 * 关键字：数组、双指针、排序
 * 主要思路：
 * 1. 先求出每个元素的平方，再进行排序
 */
public class LC977 {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}

//todo, 逃课LC1373题，二叉搜索子树的最大键值和，困难