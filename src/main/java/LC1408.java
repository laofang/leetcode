import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode1408题，数组中的字符串匹配
 * 关键字：字符串、字符串匹配
 * 主要思路：
 * 1. 双重循环，使用String index方法
 */
public class LC1408 {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words.length; j++) {
                if(i == j) continue;
                if(words[j].indexOf(words[i]) != -1) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
