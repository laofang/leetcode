/**
 * Leetcode553题，最优除法
 * 关键字：数组、数学
 * 主要思路：
 * 1. a / b 最大，需要 分子最大，分母最小
 * 2. 所以在元素大于三个的情况，被除数为第一个元素，除数为第二个元素一直除到最后
 */
public class LC553 {
    public String optimalDivision(int[] nums) {
        StringBuilder ans = new StringBuilder();
        if(nums.length == 1) {
            return String.valueOf(nums[0]);
        } else if(nums.length == 2)  {
            return ans.append(nums[0]).append("/").append(nums[1]).toString();
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(i == 0) {
                    ans.append(nums[i]).append("/").append("(");
                } else if(i == nums.length-1) {
                    ans.append(nums[i]).append(")");
                    break;
                } else {
                    ans.append(nums[i]).append("/");
                }
            }
        }
        return ans.toString();
    }
}
