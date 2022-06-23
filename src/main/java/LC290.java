import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode290题，单词规律
 * 关键字：哈希表、字符串
 * 主要思路：
 * 1. 双向映射
 */
public class LC290 {
    public boolean wordPattern(String pattern, String s) {
        String[] chToStr = new String[26];
        Map<String,Character> strToCh = new HashMap<>();
        String[] words = s.split("\\s+");
        if(pattern.length() != words.length) return false;
        char[] chs = pattern.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            String key = chToStr[chs[i] - 'a'];
            if(!words[i].equals(key)) {
                if(key == null && strToCh.get(words[i]) == null) {
                    chToStr[chs[i] - 'a'] = words[i];
                    strToCh.put(words[i],chs[i]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
