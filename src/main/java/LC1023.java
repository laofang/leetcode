import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode1023题，驼峰式匹配
 * 关键字：字典树、双指针、字符串、字符串匹配
 * 主要思路：
 * 1. 双指针，只要pattern是query的子序列，且query其余的部分都是小写字母，就匹配，反之不匹配
 */
public class LC1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0; i < queries.length; i++) {
            ans.add(check(queries[i],pattern));
        }
        return ans;
    }
    public boolean check(String query,String pattern) {
        int i = 0;
        int j = 0;
        int m = query.length();
        int n = pattern.length();
        while(i < m && j < n) {
            char q = query.charAt(i);
            char p = pattern.charAt(j);
            if(q == p) {
                i++;
                j++;
            } else if(q >= 'a' && q <= 'z') {
                i++;
            } else {
                return false;
            }
        }
        while(i < m) {
            char q = query.charAt(i);
            if(q >= 'A' && q <= 'Z') return false;
            i++;
        }
        return i == m && j == n;
    }
}
