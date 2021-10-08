import java.util.Arrays;

/**
 * 相比十六题，如果不去重，也可相对还简单了一点
 */
public class LC16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minValue = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                //三数和与target的差
                int dValue = Math.abs(sum - target);
                //当前的差最小，更新最小差值和更新结果
                if(dValue < minValue) {
                    minValue = dValue;
                    result = sum;
                }
                //如果和大于target，右指针左移
                if(sum > target) {
                    right--;
                    //如果和小于target，左指针右移
                } else if(sum < target) {
                    left++;
                    //如果sum和target相等返回sum即可
                } else{
                    return sum;
                }
            }
        }
        return result;
    }
}
