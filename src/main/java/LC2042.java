/**
 * Leetcode2042题，检查句子中的数字是否递增
 * 关键字：字符串
 * 主要思路：
 * 1. 分割字符串，判断字符串是否数字，当前数字是否大于前一个
 * 2. 遍历结束，返回true，否则返回false
 */
public class LC2042 {
    public boolean areNumbersAscending(String s) {
        String[] strs = s.split("\\s+");
        int pre = -1;
        for(String str : strs) {
            char ch = str.charAt(0);
            if(ch <= '9' && ch >= '0') {
                int val = Integer.valueOf(str);
                if(pre >= val) return false;
                pre = val;
            }
        }
        return true;
    }
}
