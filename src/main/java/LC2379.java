/**
 * Leetcode2379题，得到K个黑块的最少涂色次数
 * 关键字：
 * 主要思路：
 * 1. 简单的滑动窗口，统计每次移动后，窗口内白块数量，取最小
 */
public class LC2379 {
    public int minimumRecolors(String blocks, int k) {
        int l = 0;
        int r = 0;
        int ans = 1000;
        int chCnt = 0;
        for(r = 0; r < k; r++) {
            if(blocks.charAt(r) == 'W') ++chCnt;
        }
        ans = chCnt;
        while(r < blocks.length()) {
            if(blocks.charAt(l) == 'W') --chCnt;
            if(blocks.charAt(r) == 'W') ++chCnt;
            ans = Math.min(chCnt,ans);
            ++l;
            ++r;
        }
        return ans;
    }
}
