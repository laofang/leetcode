/**
 * Leetcode541题，反转字符串II
 * 关键字：双指针、字符串
 * 主要思路：
 * 1. 按题目的规律，每隔k个进行一次反转
 */
public class LC541 {
    public String reverseStr(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0;
        int cur = 0;
        while(cur < s.length()) {
            if(cnt % 2 == 0) {
                cur += k;
                for(int i = Math.min(cur - 1, s.length()-1); i >= cur - k ; i--) {
                    ans.append(s.charAt(i));
                }
            } else {
                for(int i = cur; i < Math.min(cur + k,s.length()); i++) {
                    ans.append(s.charAt(i));
                }
                cur += k;
            }
            ++cnt;
        }
        return ans.toString();
    }
}
//todo,LC512 反转字符串II,简单题，有优化空间