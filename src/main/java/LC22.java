import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode22题，括号生成
 * 关键字：回溯，动态规划
 * 主要思路：
 * 1. 回溯算法，主要的地方是，左括号数量要小于等于n，右括号数量要小于等于左括号的功能
 * 这道题让我想到上楼梯，每次上1，2台阶，上n阶台阶有多少种可鞥
 */
public class LC22 {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        LinkedList<String> res = new LinkedList<>();
        backTrack(res,sb,0,0,n);
        return res;
    }
    public void backTrack(List<String> res, StringBuilder cur,int open,int close,int max) {
        if(cur.length() == 2 * max) {
            res.add(cur.toString());
            return;
        }
        if(open < max) {
            cur.append('(');
            backTrack(res,cur,open+1,close,max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if(close < open) {
            cur.append(')');
            backTrack(res,cur,open,close+1,max);
            cur.deleteCharAt(cur.length() - 1);
        }

    }
}
