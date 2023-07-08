/**
 * Leetcode167题，两数之和II-输入有序数组
 * 关键字：数组、双指针、二分查找
 * 主要思路：
 * 1. 双指针，前后相加，如果和大于target，右向左移，如果和小于target，左向右移，否则返回结果
 * 2. 注意题目要求索引从1开始，所以得到的索引要加1
 */
public class LC167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
            int curVal = numbers[left] + numbers[right];
            if(curVal > target) {
                right--;
            } else if(curVal < target) {
                left++;
            } else {
                return new int[] {left+1,right+1};
            }
        }
        return new int[]{};
    }
}
