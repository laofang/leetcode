/**
 * Leetcode1769题，移动所有球到每个盒子所需的最小操作数
 * 关键字：数组、字符串
 * 主要思路：
 * 1. 先遍历，求出第一个的右侧有多少球，并且这些球到第一个的位置一共多少步
 * 2. 接下来，求出所有球到下一个位置，要走多少步，这由下一个位置的左侧和右侧的小球数量决定，左侧小球远离当前位置，所以要增加；右侧小球要接近当前位置，所以要减少。
 * 3. 依次求出数量
 */
public class LC1769 {
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        char[] chs = boxes.toCharArray();

        int lCnt = 0;
        int rCnt = 0;
        for(int i = 0; i < chs.length; i++) {
            if(chs[i] == '1') {
                ans[0] += i;
                ++rCnt;
            }
        }
        if(chs[0] == '1') {
            ++lCnt;
            --rCnt;
        }
        for(int i = 1; i < ans.length; i++) {
            ans[i] = ans[i-1] + lCnt - rCnt;
            if(chs[i] == '1') {
                ++lCnt;
                --rCnt;
            }
        }
        return ans;
    }
}
