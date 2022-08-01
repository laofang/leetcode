/**
 * Leetcode1374题，生成每种字符都是奇数个的字符串
 * 关键字：字符串
 * 主要思路：
 * 1. n是奇数，就生成n个'a'的字符串
 * 2. n是偶数，就生成1个'a'和n-1个'b'的字符串
 */
public class LC1374 {
    public String generateTheString(int n) {
        StringBuilder ans = new StringBuilder();
        if(n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                ans.append('a');
            }
        } else {
            ans.append('a');
            for(int i = 0; i < n - 1; i++) {
                ans.append('b');
            }
        }
        return ans.toString();
    }
}
