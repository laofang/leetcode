import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode1805题，字符串中不同整数的数目
 * 关键字：哈希表、字符串
 * 主要思路：
 * 1. 循环，跳过干扰的，获取有价值的，存入Set，来查看是否存在
 */
public class LC1805 {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        char[] chs = word.toCharArray();
        int i = 0;
        int ans = 0;
        while (i < chs.length) {
            //排除非数字
            while(i < chs.length && (chs[i] < '0' || chs[i] > '9')) i++;
            //跳过前导0
            while(i < chs.length && chs[i] == '0') ++i;
            if(i == chs.length && chs[i-1] != '0') break;
            StringBuilder sb = new StringBuilder();
            while(i < chs.length && chs[i] >= '0' && chs[i] <= '9') {
                sb.append(chs[i]);
                ++i;
            }
            System.out.println(sb.toString());
            if(!set.contains(sb.toString())) {
                set.add(sb.toString());
                ++ans;
            }
            ++i;
        }
        return ans;
    }
}
