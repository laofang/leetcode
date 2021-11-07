/**
 * LC5919，所有子字符串中的元音
 * 关键字：字符串，子串
 * 给你一个字符串 word ，返回 word 的所有子字符串中 元音的总数 ，元音是指 'a'、'e'、'i'、'o' 和 'u' 。
 *
 * 子字符串 是字符串中一个连续（非空）的字符序列。
 *
 * 注意：由于对 word 长度的限制比较宽松，答案可能超过有符号 32 位整数的范围。计算时需当心。
 *
 * 主要思路：
 * 1. 观察，如果当前字符是元音字母，它会出现在多少个子串中？
 * 2. (i+1) * (array.length - 1)
 * 3. 假设i = 0时， s[0,0,n-1] 这一共是n个子字符串
 *      假设i = 1时，s[1,1~n-1] 这一共时n-1个字符串，同时还是有s[0~1,1~n-1]这又是一个n-1个子字符串
 *      这就可以看出规律，当前元素前面没多一个字符，那么就会多一个（n - i)个字符串
 *
 */
public class LC5919 {
    public long countVowels(String word) {
        long ans = 0;
        char[] chs = word.toCharArray();
        for(int i = 0; i < chs.length; i++ ) {
            if(isO(chs[i])){
                //本题的关键，当前字符，会在多少个子串中，(i+1) * (array.length - 1);
                ans+= (long)(i+1) * (chs.length - i);
            }
        }
        return ans;
    }
    public boolean isO(char ch) {
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}
