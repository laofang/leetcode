/**
 * Leetcode334题，递增的三元子序列
 * 关键字：数组、贪心
 * 主要思路：
 * 1. 先设置一个first和second数字
 * 2. 每次进行比较，如果小于等于first的，赋值给first的，如果不是，则和second的比较
 * 3. 如果一个值，大于了first和second说明递增序列存在
 */
public class LC334 {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3)  return false;
        int first = nums[0];
        int second = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= first) {
                first = nums[i];
            } else if(nums[i] <= second || second == Integer.MIN_VALUE) {
                second = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
