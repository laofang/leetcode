import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode448题，找到所有数组中消失的数字
 * 关键字：数组、哈希表
 * 主要思路：
 * 1. 把每个数字放到它对应的索引位置，除非对应的位置，已经有相同的数字占据
 * 2. 遍历调整后的数组，如果一个位置上的数字不符合预期，就把该位置加入答案
 */
public class LC448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        List<Integer> ans = new ArrayList<>();
        while(i < nums.length) {
            while (i < nums.length && nums[i] == i + 1) i++;
            if(i >= nums.length) break;

            if (nums[nums[i] - 1] == nums[i]) {
                i++;
            } else {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                ans.add(i+1);
            }
        }
        return ans;
    }
}
//todo 逃课LC1697，检查边长度限制的路径是否存在，困难，图，并查集和排序