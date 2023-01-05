/**
 * Leetcode482题，密钥格式化
 * 关键字：字符串
 * 主要思路：
 * 1. 先将全部的'-'进行替换，第一组特殊处理，当前字符串长度 % k，就是第一组的长度
 * 2. 从第二组开始，每组长度为k，注意字符要转换为大写
 */
public class LC482 {
    public String licenseKeyFormatting(String s, int k) {
        String str = s.replaceAll("-","");
        StringBuilder ans = new StringBuilder();
        int firstLen = str.length() % k;
        char[] chs = str.toCharArray();
        for(int i = 0; i < firstLen; i++) {
            ans.append(Character.toUpperCase(chs[i]));
        }
        if(firstLen < chs.length && firstLen != 0) ans.append("-");
        int i = firstLen;
        while(i < chs.length) {
            for(int j = 0; j < k; j++) {
                ans.append(Character.toUpperCase(chs[i]));
                i++;
            }
            if(i < chs.length) ans.append("-");
        }
        return ans.toString();
    }
}
//todo 逃课LC1083，统计异或值在范围内的数对有多少，困难题，需要使用前缀树