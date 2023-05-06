/**
 * Leetcode1419题，数青蛙
 * 关键字：字符串、计数
 * 主要思路：
 * 1. 满足croak后面的字符数量，小于前面的
 * 2. 在遍历的过程中，'c'的数量与'k'的数量差值的最大值就是答案
 */
public class LC1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int ans = 0;
        int[] cnt = new int[5];
        char[] chs = croakOfFrogs.toCharArray();
        for(int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if(ch == 'c') cnt[0]++;
            else if(ch == 'r') cnt[1]++;
            else if(ch == 'o') cnt[2]++;
            else if(ch == 'a') cnt[3]++;
            else if(ch == 'k') cnt[4]++;
            if(cnt[1] > cnt[0] || cnt[2] > cnt[1] || cnt[3] > cnt[2] || cnt[4] > cnt[3]) return -1;
            ans = Math.max(ans,cnt[0] - cnt[4]);
        }
        return cnt[0] == cnt[4] ? ans : -1;
    }
}
