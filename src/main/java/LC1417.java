/*
 * Leetcode1417题，重新格式化字符串
 * 关键字：字符串
 * 主要思路：
 * 1. 先求出数字和字母的数量，如果差的绝对值大于1，不能格式化
 * 2. 如果不大于1，将较多的一个放在偶数索引下，另一个放在奇数索引下即可
 */
public class LC1417 {
    public String reformat(String s) {
        char[] chs = new char[s.length()];
        char[] ss = s.toCharArray();
        int nCount = 0;
        int sCount = 0;
        int odd = 0;
        int even = 1;
        for(int i = 0; i < ss.length; i++) {
            if(ss[i] >= '0' && ss[i] <= '9') 
                nCount++;
            else 
                sCount++;          
        }
        if(Math.abs(nCount - sCount) <= 1) {
            if(nCount < sCount) {
                odd = 1;
                even = 0;
            }
        } else {
            return "";
        }
        for(int i = 0; i < ss.length; i++) {
            if(ss[i] >= '0' && ss[i] <= '9') {
                if(odd >= ss.length) return "";
                chs[odd] = ss[i];
                odd += 2;
            } else {
                if(even >= ss.length) return "";
                chs[even] = ss[i];
                even += 2;
            }
        }
        return new String(chs);
    }
}
