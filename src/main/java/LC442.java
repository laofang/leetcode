import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode442题，数组中重复的数据
 * 关键字：数组、哈希表
 * 主要思路：
 * 1. 类似第41题，缺失的第一个正数
 * 2. 在原数组上建立hash关系，nums[i] = i + 1
 * 3. 第一次遍历，将每个数字k，放在nums[k-1]的位置，如果k-1的位置已经是k，就继续循环
 * 4. 第二次遍历，找到nums[i] != i+1的元素，加入答案列表
 */
public class LC442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while(i < nums.length) {
            int index = nums[i] - 1;
            if(nums[index]!= nums[i]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            } else{
                i++;
            }
        }
        for(i = 0; i < nums.length;i++) {
            if(nums[i] != i+1) ans.add(nums[i]);
        }
        return ans;
    }
}
