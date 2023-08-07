import java.util.Arrays;

/**
 * Leetcode1859题，将句子排序
 * 关键字：字符串、排序
 * 主要思路：
 * 1. 先分割排序，再组装成句子
 */
public class LC1859 {
    public String sortSentence(String s) {
        String[] strs = s.split("\\s+");
        Arrays.sort(strs,(e1, e2)->{
            return (e1.charAt(e1.length() - 1) - '0') - (e2.charAt(e2.length() - 1) - '0');
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.length; i++) {
            char[] chs = strs[i].toCharArray();
            for(int j = 0; j < chs.length - 1; j++) {
                sb.append(chs[j]);
            }
            if(i == strs.length - 1) break;
            sb.append(" ");
        }
        return sb.toString();
    }
}
