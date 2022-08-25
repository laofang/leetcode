import java.util.Arrays;

/**
 * Leetcode455题，分发饼干
 * 关键字：贪心、数组、排序
 * 主要思路：
 * 1. 尽可能的用最小的饼干满足最小胃口的孩子
 * 2. 如果饼干不够大，就逐渐尝试更大的，直到可以满足，进行计数
 */
public class LC455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < g.length && j < s.length) {
            if(s[j] >= g[i]) {
                ans++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return ans;
    }
}
