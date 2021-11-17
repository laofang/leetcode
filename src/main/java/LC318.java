/**
 * Leetcode318题，最大单词长度乘积
 * 关键字：位运算、位掩码、字符串
 * 主要思路：
 * 1. 将每个单词转化映射成一个掩码，例如'a'对应二进制位第一位，'b'对应第二位，以此类推
 * 2. 这样每个单词就对应了一个掩码
 * 3. 然后对比任意两个单词的掩码，掩码相与，如果结果是0说明没有相同的字母，再求两个字符串长度乘积即可
 * 4. 官方解法还有个优化，就是如果掩码相同，就只存长度更大的那个
 */
public class LC318 {
    public int maxProduct(String[] words) {
        int[] mask = new int[words.length];
        //每个单词转化成掩码
        for (int i = 0; i < words.length; i++) {
            char[] chs = words[i].toCharArray();
            int t = 0;
            for (char ch : chs) {
                t = t | (1 << (ch - 'a'));
            }
            mask[i] = t;
        }
        int max = 0;
        //任意两个掩码对比
        for (int i = 0; i < mask.length; i++) {
            for (int j = i + 1; j < mask.length; j++) {
                if((mask[i] & mask[j]) == 0 ) {
                    max = Math.max(max,words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
