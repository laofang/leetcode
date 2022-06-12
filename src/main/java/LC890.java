import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode890题，查找和替换模式
 * 关键字：数组、哈希表、字符串
 * 主要思路：
 * 1. 两个字符串的字母互相映射
 * 2. 映射完全唯一的，是需要的字符串，加入答案列表
 */
public class LC890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            int[] wMap = new int[27];
            int[] pMap = new int[27];
            int j = 0;
            for(; j < words[i].length(); j++) {
                int wIndex = words[i].charAt(j)-'a' + 1;
                int pIndex = pattern.charAt(j) - 'a' + 1;
                if(wMap[wIndex] == 0 && pMap[pIndex] == 0) {
                    wMap[wIndex] = pIndex;
                    pMap[pIndex] = wIndex;
                } else if(wMap[wIndex] != pIndex || pMap[pIndex] != wIndex){
                    break;
                }
            }
            if(j == words[i].length()) ans.add(words[i]);
        }
        return ans;
    }
}
