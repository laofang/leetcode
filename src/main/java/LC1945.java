/**
 * Leetcode1945题，字符串转化后的各位数字之和
 * 关键字：字符串、模拟
 * 主要思路：
 * 1. 模拟
 */
public class LC1945 {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            sb.append(ch-'a' + 1);
        }
        int ans = 0;
        for (int i = 0;i < sb.length(); i++) {
            ans += Integer.valueOf(sb.charAt(i) - '0');
        }
        for(int i = 1; i < k; i++) {
            int sum = 0;
            if(ans < 10) return ans;
            while(ans != 0) {
                sum += ans % 10;
                ans /= 10;
            }
            ans = sum;
        }
        return ans;
    }
}
