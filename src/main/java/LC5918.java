import java.util.HashSet;
import java.util.Set;

/**
 * LC5918题，统计字符串中的元音子字符串
 * 子字符串 是字符串中的一个连续（非空）的字符序列。
 *
 * 元音子字符串 是 仅 由元音（'a'、'e'、'i'、'o' 和 'u'）组成的一个子字符串，且必须包含 全部五种 元音。
 *
 * 给你一个字符串 word ，统计并返回 word 中 元音子字符串的数目 。
 *
 * 关键字：字符串、Set
 * 主要思路：
 * 1. 从每一个元音字母开始向后遍历
 * 2. 如果是元音字母，加入set，当Set.size() == 5时，每遇到元音字母结果加1，否则跳出当前循环
 */
public class LC5918 {
    public int countVowelSubstrings(String word) {
        int ans = 0;
        char[] chs = word.toCharArray();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < word.length() ;i++) {
            set.clear();
            //如果chas[i]是元音字母才开始
            if(isVowel(chs[i])) {
                for(int j = i; j < word.length(); j++) {
                    if(isVowel(chs[j])) {
                        set.add(chs[j]);
                    } else {
                        break;
                    }
                    //当有五个元音，结果增加
                    if(set.size() >= 5) {
                        ans++;
                    }
                }
            }

        }
        return ans;

    }

    public boolean isVowel(char ch) {
        switch(ch) {
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
