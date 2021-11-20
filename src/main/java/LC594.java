import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode594题，最长和谐子序列
 * 关键字：哈希、数组
 * 主要思路：
 * 1. 记录每一个数字的数量，然后查看大于小于1的总和数量最大的那个就是答案
 */
public class LC594 {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>(20000);
        int ans = 0;
        for(int i = 0; i < nums.length;i++) {
            int count = map.getOrDefault(nums[i],0);
            map.put(nums[i],++count);
            int plusOne = map.getOrDefault(nums[i] + 1,0);
            int minusOne = map.getOrDefault(nums[i]-1,0);
            plusOne = plusOne == 0 ? 0 : plusOne + count;
            minusOne = minusOne == 0 ? 0 : minusOne + count;
            ans = Math.max(ans,Math.max(plusOne,minusOne));
        }

        return ans;
    }
}
