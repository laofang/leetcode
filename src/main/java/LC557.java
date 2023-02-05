/**
 * Leetcode557题，反转字符串中的单词
 * 关键字：双指针、字符串
 * 主要思路：
 * 1. 每个单词反转，再按空格分割
 */
public class LC557 {
    public String reverseWords(String s) {
        String[] strs = s.split("\\s+");
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < strs.length;i++) {
            String cur = new StringBuilder(strs[i]).reverse().toString();
            ans.append(cur);
            if(i < strs.length - 1) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}
