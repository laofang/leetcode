/**
 * Leetcode1796题，字符串中第二大的数字
 * 关键字：哈希表、字符串
 * 主要思路：
 * 1. 如果当前数字大于最大的，更新第二大的和最大的，如果当前数字小于最大，又大于第二大的就更新第二大的
 */
public class LC1796 {
    public int secondHighest(String s) {
        char[] chs = s.toCharArray();
        int max = -1;
        int ans = -1;
        for(char ch : chs) {
            if(ch >= '0' && ch <='9') {
                int value = Integer.valueOf(ch-48);
                if(value > max) {
                    ans = max;
                    max = value;
                } else if(value > ans && value != max) ans = value;
            }
        }
        return ans;
    }
}
