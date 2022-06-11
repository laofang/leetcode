/**
 * Leetcode926题，将字符串翻转到单调递增
 * 关键字：字符串、动态规划
 * 主要思路：
 * 1. 依次得出从当前变为00000000、00000001、00000011……11111111所需要的次数
 * 2. 后一个转换目标的结果，可以从前一个得到，是动态规划的思路
 */
public class LC926 {
    public int minFlipsMonoIncr(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') cnt++;
        }
        int ans = cnt;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                cnt++;
            } else {
                cnt--;
            }
            ans = Math.min(ans,cnt);
        }
        return ans;
    }
}
