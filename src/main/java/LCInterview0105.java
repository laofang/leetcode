/**
 * Leetcode 面试题 01.05，一次编辑
 * 关键字：双指针、字符串
 * 主要思路：
 * 1. 如果字符串长度差>1，返回false;
 * 2. 两字符串长度相等时，如果不同的字符数量不多于1个，返回true，否则返回false
 * 3. 如果两字符串长度相差为1：
 *      1. 两字符串从左相比
 *      2. 如果不同，再从右开始对比
 *      3. 最后如果较短字符串全部比较成功，返回true，否则返回false
 */
public class LCInterview0105 {
    public boolean oneEditAway(String first, String second) {
        int fl = first.length();
        int sl = second.length();
        if(fl == sl) {
            int count = 0;
            for(int i = 0; i < fl;i++) {
                if(first.charAt(i) != second.charAt(i)) count++;
            }
            return count <= 1;
        } else if(Math.abs(fl - sl) > 1) {
            return false;
        } else {
            String a;
            String b;
            if(fl < sl) {
                a = first;
                b = second;
            } else {
                a = second;
                b = first;
            }
            int l = 0;
            int r = a.length() - 1;
            while(l < a.length()) {
                if(a.charAt(l) != b.charAt(l)) break;
                l++;
            }
            while(l <= r) {
                if(a.charAt(r) != b.charAt(r+1)) break;
                r--;
            }
            return l > r;
        }
    }
}
