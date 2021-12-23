import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode1044题，最长重复子串
 * 关键字：字符串hash、后缀数组、二分法、字符串匹配
 * 主要思路：
 * 1. 二分法去看每一个长度的子串是否能构成重复子串
 * 2. 比较用字符串hash进行比较
 * 3. 效率更高的做法有后缀数组
 */
public class LC1044 {
    long[] p;
    long[] h;
    public String longestDupSubstring(String s) {
        int n = s.length(), P = 13131;
        p = new long[n + 1];
        h = new long[n + 1];
        p[0] = 1;
        for(int i = 1; i <= n; ++i){
            p[i] = p[i - 1] * P;
            h[i] = h[i - 1] * P + s.charAt(i - 1);//长度为I字符串哈希值
        }

        String ans = "";
        int left = 0, right = n;
        while(left <= right){
            int mid = ((right - left) >> 1) + left;
            String tmp = check(s, mid);
            if(tmp.length() != 0){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            ans = tmp.length() > ans.length() ? tmp : ans;
        }
        return ans;
    }
    private String check(String s, int len){
        int n = s.length();
        Set<Long> set = new HashSet<>();
        for(int i = 0; i + len <= n; ++i){
            int j = i + len;
            long hash = h[j] - h[i] * p[j - i];
            if(set.contains(hash)){
                return s.substring(i, j);
            }
            set.add(hash);
        }
        return "";
    }
    //TODO 1044，最长重复子串，困难题，题目涉及字符串hash、后缀数组需要仔细学习一下
}
