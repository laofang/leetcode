import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Leetcode496题，下一个更大元素I
 * 关键字：栈、数组、哈希表、单调栈
 * 主要思路：
 * 1. 采用单调栈，将nums2中每个元素入栈，如果入栈元素大于栈顶元素，栈顶元素出栈，并进行记录（此时入栈元素，就是出栈元素的右侧第一个更大的元素）
 * 2. 重复上面的步骤
 */
public class LC496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        LinkedList<Integer> stack = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums2) {
            while(!stack.isEmpty() && stack.peek() < num) {
                int val = stack.pop();
                map.put(val,num);
            }
            stack.push(num);
        }
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            int val = map.getOrDefault(nums1[i],-1);
            ans[i] = val;
        }
        return ans;
    }
}
