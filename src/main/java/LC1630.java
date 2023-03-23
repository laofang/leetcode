import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode1630题，等差子数组
 * 关键字：数组、排序
 * 主要思路：
 * 1. 直接按规则暴力模拟
 */
public class LC1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = l.length;
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int left = l[i];
            int right = r[i];
            int len = right - left + 1;
            int[] array = new int[len];
            int j = 0;
            while(left <= right) {
                array[j++] = nums[left++];
            }
            ans.add(isEquidistant(array));
        }
        return ans;
    }
    public boolean isEquidistant(int[] array) {
        Arrays.sort(array);
        for(int i = 2; i < array.length; i++) {
            if(array[i] - array[i-1] != array[i-1] - array[i-2]) return false;
        }
        return true;
    }
}
