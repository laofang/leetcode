import java.util.Arrays;

/**
 * Leetcode1170题，比较字符产最小字母出现频次
 * 关键字：数组、哈希表、字符串、二分查找、排序
 * 主要思路：
 * 1. 写一个函数f(s)计算字符串s最小字母的频次
 * 2. 算出queries和words中每个字符串最小字母的频次，分别存入两个数组
 * 3. 对每个qCnt，去查找wCnt中大于它的个数（可以使用二分查找，这里未使用）
 */
public class LC1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wCnt = new int[words.length];
        int[] qCnt = new int[queries.length];
        for(int i = 0; i < words.length; i++) {
            wCnt[i] = f(words[i]);
        }
        for(int i = 0; i < queries.length; i++) {
            qCnt[i] = f(queries[i]);
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < qCnt.length; i++) {
            int cnt = 0;
            for(int j = 0; j < wCnt.length; j++) {
                if(qCnt[i] < wCnt[j]) {
                    cnt++;
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }
    public int f(String s) {
        if(s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        int cnt = 0;
        char target = chs[0];
        for(int i = 0; i < chs.length; i++) {
            if(chs[i] != target) break;
            cnt++;
        }
        return cnt;
    }
}
