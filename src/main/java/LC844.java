/**
 * Leetcode844题，比较含退格的字符串
 * 关键字：栈、双指针、字符串、模拟
 * 主要思路：
 * 1. 相当于把StringBuilder当作栈来用，遇到‘#’出栈
 */
public class LC844 {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(ch != '#') {
                sb1.append(ch);
            } else {
                if(sb1.length() > 0) sb1.deleteCharAt(sb1.length() - 1);
            }
        }
        for(char ch : t.toCharArray()) {
            if(ch != '#') {
                sb2.append(ch);
            } else {
                if(sb2.length() > 0) sb2.deleteCharAt(sb2.length() - 1);
            }
        }
        return sb1.toString().equals(sb2.toString());
    }
}
