/**
 * Leetcode2437题，有效时间的数目
 * 关键字：字符串、枚举
 * 主要思路：
 * 1. 前两位的可能情况，彼此相关，如果第一位是0或1,第二位有10种可能，如果是2，第二位有4种可能；如果第二位 > 3，第一位有2种可能，非则第一位有3种可能
 * 2. 后两位都是无关的，第三位有6种可能，第四位有10种可能
 */
public class LC2437 {
    public int countTime(String time) {
        int ans = 1;
        for(int i = 0; i < time.length(); i++) {
            if(time.charAt(i) == '?') {
                if(i == 0) {
                    char ch = time.charAt(1);
                    ans *= ch > '3' ? 2 : 3;
                } else if(i == 1) {
                    char ch = time.charAt(0);
                    if(ch == '2') {
                        ans *= 4;
                    } else if(ch == '?'){
                        ans = 24;
                    } else {
                        ans *= 10;
                    }
                } else if(i == 3) {
                    ans *= 6;
                } else if(i == 4) {
                    ans *= 10;
                }
            }
        }
        return ans;
    }
}
