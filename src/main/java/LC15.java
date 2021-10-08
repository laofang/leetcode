import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode第十五题，三数之和
 * 主要思路：
 * 1. 先排序，然后对每个元素找到对应的两个元素
 *      1. 当前元素索引为i，left = i + 1,right = nums.length - 1
 *      2. nums[i]>0 那其后的数字和必定大于0则结束
 *      3. 找到所有当前元素符合的另外两个元素
 *          1. 如果相加等于0
 *              再找下一个，要跳过nums[left] == nums[left+1]的元素，同理也要跳过nums[right] = nums[right-1]的元素，不然会重复
 *          2. 如果相加小于0，说明最小的不够大，left++
 *          3. 如果相加大于0，说明最大的过大，right--
 *      4. 再找下一个元素nums[i+1],如果nums[i+1]==nums[i]，需要抛弃，因为nums[i]所有符合条件的都已经找到，若再找，会出现重复
 *
 */
public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> rL = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //三个数和必大于0直接返回即可
            if(nums[i] > 0) {
                return rL;
            }
            //如果当前元素和上一个元素相同，直接抛弃，不然解集会重复
            if(i - 1 >= 0 && nums[i-1] == nums[i]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            //左指针小于右指针执行
            while(left < right) {
                int target = nums[i] + nums[left] + nums[right];
                //三数和为0
                if(target == 0) {
                    //加入三个数作为其中一个解
                    rL.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //移动左指针，排除相同的数字，不然解会重复
                    while(left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    //移动右指针，排除相同的数字，不然解会重复
                    while(left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                    //大于0说明大的太大，所以右指针左移一位
                } else if(target > 0) {
                    right--;
                    //小于0说明小的太小，所以左指针右移一位
                } else {
                    left++;
                }
            }
        }
        return rL;
    }
}
