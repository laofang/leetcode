import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode228题，汇总区间
 * 关键字：数组
 * 主要思路：
 * 1. 双指针，找到连续的序列，进行填写，注意只有一个的情况和边界情况
 */
public class LC228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int left = 0;
        int right = 1;
        int n = nums.length;
        if(n == 1) {
            ans.add(nums[0] + "");
            return ans;
        }
        while(right < n) {
            while(right < n && nums[right] - nums[right - 1] == 1) right++;
            if(right - left == 1) {
                ans.add(nums[left]+"");
            } else {
                ans.add(nums[left] + "->" +nums[right-1]);
            }
            left = right;
            right++;
            if(right == n) {
                if(right - left == 1) {
                    ans.add(nums[left]+"");
                } else {
                    ans.add(nums[left] + "->" +nums[right-1]);
                }
            }
        }
        return ans;
    }
}
