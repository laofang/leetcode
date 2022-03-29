/**
 * Leetcode2024题，考试的最大困扰度
 * 关键字：字符串、二分查找、前缀和、滑动窗口
 * 主要思路：
 * 1. 窗口滑动，让窗口保持有k个'T'或者k个'F'
 * 2. 获得的最大窗口就是答案
 */
public class LC2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left = 0,right = 0;
        int ans = 0;
        int count = 0;
        while(right < answerKey.length()) {
            if(answerKey.charAt(right) == 'T') {

                ++count;
            }
            if(count > k) {
                if(answerKey.charAt(left) == 'T') {
                    --count;
                }
                ++left;
            }
            ++right;
        }
        ans = right - left;
        left = 0;
        right = 0;
        count = 0;
        while(right < answerKey.length()) {
            if(answerKey.charAt(right) == 'F') {

                ++count;
            }
            if(count > k) {
                if(answerKey.charAt(left) == 'F') {
                    --count;
                }
                ++left;
            }
            right++;
        }
        ans = Math.max(ans,right-left);
        return ans;
    }
}
