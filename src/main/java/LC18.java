import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode第十八题，四数之和
 * 这道题的思路和第十五题的思路十分类似，不过多了一重循环，然后还是双指针操作
 * 操作过程中可以做一些剪枝，可以提高效率
 */
public class LC18 {
    //TODO 算法只有 55%效率和13%的存储，可进一步优化
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> res =  new LinkedList<List<Integer>>();
        //遍历前两个数，并固定
        for (int i = 0; i < nums.length; i++) {
            //剪枝
            if(nums[i] > 0 && nums[i] > target) return res;
            //去重
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                //剪枝
                int twoSum = nums[i]  + nums[j];
                if(twoSum > 0 && twoSum > target) continue;
                //去重
                if(j > i + 1 && nums[j] == nums[j-1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                //找到前两位确定时，所有成立的情况
                while(left < right) {
                    //剪枝
                    int threeSum = nums[i] + nums[j] + nums[left];
                    if(threeSum > 0 && threeSum >target) break;
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target) {
                        res.add(List.of(nums[i],nums[j],nums[left],nums[right]));
                        //去重
                        while(left < right && nums[left+1] == nums[left]) {
                            left++;
                        }
                        //去重
                        while(left < right && nums[right-1] == nums[right]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
