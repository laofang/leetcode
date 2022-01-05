/**
 * Leetcode1576题，替换所有的问号
 * 关键字：字符串、字符数组
 * 主要思路：
 * 1. 遍历字符串
 * 2. 如果当前是问号，就选择一个和前后不同的字符加入答案
 */
public class LC1576 {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length; i++) {
            char pre = '0';
            char next = '0';
            char t = chs[i];
            if(chs[i] == '?') {
                if(i > 0) {
                    pre = chs[i-1];
                }
                if(i < chs.length-1) {
                    next = chs[i+1];
                }
                t = 'a';
                while(t == pre || t == next) {
                    t = (char)(t + 1);
                }
            }
            chs[i] = t;
            sb.append(t);
        }
        return sb.toString();
    }
}
