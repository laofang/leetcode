/**
 * Leetcode942题，增减字符串匹配
 * 关键字：贪心、数组、数学、双指针、字符串
 * 主要思路：
 * 1. 使用贪心算法
 * 2. 如果当前位置是字符'I'，就放当前最小值，最小值左移
 * 3. 如果当前位置是字符'D'，就放当前最大值，最大值右移
 * 4. 最后将剩下的放在最后一个位置即可
 */
public class LC942 {
    public int[] diStringMatch(String s) {
        int l = 0;
        int r = s.length();
        int[] ans = new int[s.length() + 1];
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'I') {
                ans[i] = l++;
            } else {
                ans[i] = r--;
            }
        }
        ans[s.length()] = l;
        return ans;
    }
}
