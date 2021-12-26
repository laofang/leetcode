import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode1078题，Bigram分词
 * 关键字：字符串
 * 主要思路：
 * 1. 从第三个词开始遍历
 * 2. 如果当前词的前两个，分别与first和second相等，当前词就是其中一个答案
 */
public class LC1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] texts = text.split(" ");
        List<String> l = new LinkedList<>();
        for(int i = 2; i < texts.length; i++) {
            if(texts[i - 2].equals(first) && texts[i-1].equals(second)) {
                l.add(texts[i]);
            }
        }
        String[] ans = new String[l.size()];
        for(int i = 0; i < l.size();i++) {
            ans[i] = l.get(i);
        }
        return ans;
    }
}
