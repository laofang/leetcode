import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode784题，字母大小写全排列
 * 关键字：位运算、字符串、回溯
 * 主要思路：
 * 1. 简单的回溯，在当前是字母的情况下，当前层次有两种方案
 */
public class LC784 {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new LinkedList<>();
        traceBack(s.toCharArray(),0,ans);
        return ans;
    }
    public void traceBack(char[] chs, int cur, List<String> ans) {
        while(cur < chs.length && (chs[cur] < 'A' || chs[cur] > 'z')) ++cur;
        if(cur == chs.length) {
            ans.add(new String(chs));
            return;
        }
        traceBack(chs,cur+1,ans);
        chs[cur] = chs[cur] >= 'A' && chs[cur] <= 'Z' ? (char)(chs[cur] + 32) : (char)(chs[cur] - 32);
        traceBack(chs,cur+1,ans);
    }
}
