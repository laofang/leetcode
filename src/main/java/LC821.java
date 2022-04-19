/**
 * Leetcode821题，字符的最短距离
 * 关键字：数组、双指针、字符串
 * 主要思路：
 * 1. 与42题接雨水的一种解法比较类似
 * 2. 首先用两个数组，其中一个数组记录每个位置左侧最近的目标字符的位置；另一个数组记录每个位置右侧最近的目标字符的位置
 * 3. 再遍历每个位置，左右最近目标字符更近的与当前位置差的绝对值就是答案
 */
public class LC821 {
    public int[] shortestToChar(String s, char c) {
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        int cIndex = -1;
        for (int i = 0; i < left.length; i++) {
            if(s.charAt(i) == c) {
                cIndex = i;
            }
            left[i] = cIndex;
        }
        cIndex = -1;
        for(int i = right.length -1; i >= 0; i--) {
            if(s.charAt(i) == c) {
                cIndex = i;
            }
            right[i] = cIndex;
        }
        int[] ans = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if(left[i] == -1) {
                ans[i] = right[i] - i;
            } else if(right[i] == -1) {
                ans[i] = i - left[i];
            } else{
                ans[i] = Math.min(right[i] - i,i-left[i]);
            }
        }
        return ans;
    }
}
