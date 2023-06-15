import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode1177题，构建回文串检测
 * 关键字：位运算、数组、哈希表、字符串、前缀和
 * 主要思路：
 * 1. 求每个字母的数量前缀和，偶数的能配成对，奇数的数量互相配对，看k能否满足
 */
public class LC1177 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[][] cnt = new int[26][n + 1];
        for (int i = 0; i < 26; i++)
            cnt[i][0] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < 26; j++)
                cnt[j][i] = s.charAt(i - 1) - 'a' == j ? cnt[j][i - 1] + 1 : cnt[j][i - 1];
        List<Boolean> ans = new ArrayList<>();

        for (int[] query: queries) {
            int tot = 0;
            for (int i = 0; i < 26; i++) {
                tot += (cnt[i][query[1] + 1] - cnt[i][query[0]]) % 2;
            }
            ans.add(tot / 2 <= query[2]);
        }
        return ans;
    }
}
