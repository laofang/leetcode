/**
 * Leetcode392题，判断子序列
 * 关键字：双指针、字符串、动态规划
 * 主要思路：
 * 1. 两个指针，分别指向两个字符
 * 2. 短串每个字符，去和长串当前指针位置，向后对比，长串指针向后移动
 * 3。如果匹配成功，短串指针后移，重复上面步骤
 * 4. 如果短串指针遍历完毕，返回true
 * 5. 如果长传指针遍历完毕，返回false
 */
public class LC392 {
    public boolean isSubsequence(String s, String t) {
        char[] sChs = s.toCharArray();
        char[] tChs = t.toCharArray();
        int i = 0;
        for(char ch : sChs) {
            while(i < tChs.length) {
                if(ch == tChs[i]) break;
                i++;
            }
            if(i == tChs.length) return false;
            i++;
        }
        return true;
    }
}
