import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode1995题，统计特殊四元组
 * 关键字；数组、双指针、背包、哈希
 * 主要思路：
 * 1. nums[a] + nums[b] = nums[d] - nums[c]
 * 2. b（或者c）从最后的位置向前移动
 * 3. d从后向前，每个元素与b+1，也就是c相减，并存入map
 * 4. a从0开始，每个元素与b进行相加
 * 5. 对比相加的结果和记录的数量相加
 */
public class LC1995 {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        //c向前移动
        for(int c = n - 2;c >= 2;c--) {
            //d到c的每个元素与c做差
            for(int d = n - 1; d > c; d--) {
                int count = map.getOrDefault(nums[d] - nums[c],0);
                map.put(nums[d]-nums[c],++count);
            }
            int b = c - 1;
            //a到b的每个元素与b相加
            for(int a = 0; a < b; a++) {
                int count = map.getOrDefault(nums[a] + nums[b],0);
                ans += count;
            }
        }
        return ans;
    }
}
