import java.util.LinkedList;

/**
 * Leetcode388题，文件的最长绝对路径
 * 关键字：栈、深度优先搜索、字符串
 * 主要思路：
 * 1. 主要利用栈和深度优先搜索
 * 2. 按顺序遍历字符串，遇到'\n'，就处理前面的字符串
 * 3. 每个字符串的开头之前，'\t'越多，说明深度越深
 * 4. 如果栈顶节点的深度小于当前字符串的深度，则可以直接入栈，加上这个字符串长度
 * 5. 如果栈顶节点的深度不小于当前字符串的深度，要出栈到小于当前字符串的深度为止，同时减去出栈的长度
 * 6. 遇到'.'说明当前字符串表示文件，这个时候可以尝试是否是更长的长度，如果是就进行记录
 */
public class LC388 {
    public int lengthLongestPath(String input) {
        int ans = 0;
        int curIndex = 0;
        int curLen = 0;
        int topTCnt = -1;
        int curTCnt = 0;
        boolean hasDot = false;

        input += "\n";
        LinkedList<Integer> stack = new LinkedList<>();

        for(int i = 0; i < input.length();i++) {
            //如果有.说明是文件
            if(input.charAt(i) == '.') {
                hasDot = true;
            }
            //遇到'\n'处理之前的字符串
            if(input.charAt(i) == '\n') {
                //当前字符串的t的数量 与 栈顶字符串t的数量相比
                //如果当前的 小于等于 栈顶t的数量，那就要出栈到小于当前字符串t的数量

                if(curTCnt <= topTCnt) {
                    int nums = topTCnt - curTCnt + 1;
                    for(int k = 0; k < nums; k++) {
                        curLen -= stack.pop();
                        topTCnt--;
                    }
                }
                stack.push(i - curIndex + 1);
                curLen += (i - curIndex + 1);
                topTCnt = curTCnt;
                if(hasDot) {
                    ans = Math.max(ans,curLen);
                }


                int tCnt = 0;
                int j = i + 1;
                for(; j < input.length();j++) {
                    if(input.charAt(j) == '\t') {
                        tCnt++;
                    } else {
                        break;
                    }
                }
                curIndex = j;
                i = j;
                curTCnt = tCnt;

                hasDot = false;
            }
        }
        return ans == 0 ? 0 : ans - 1;
    }
}
