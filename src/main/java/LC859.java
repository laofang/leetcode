/**
 * Leetcode895题，亲密字符串
 * 关键字：字符串
 * 主要思路：
 * 1. 分析满足亲密字符串有几种情况：
 *      1. 前提，长度必定相同
 *      2. 第一种可能：只有两个位置的字母不同，且s[i] == g[j] && s[j] == g[i];
 *      3. 第二种可能：完全相同，且字符串中有至少一对重复字符
 */
public class LC859 {
    public boolean buddyStrings(String s, String goal) {
        //长度不等，则不可能是亲密字符串
        if(s.length() != goal.length()) {
            return false;
        }
        int n = s.length();
        char[] sChs = s.toCharArray();
        char[] gChs = goal.toCharArray();
        //两个不同的位置
        int x = -1;
        int y = -1;
        //不同的数量
        int count = 0;
        //重复的数量
        int repeat = 0;
        int[] m = new int[26];
        for(int i = 0; i < n; i++){
            //已存在，重复数量增加
            if(m[sChs[i] - 'a'] > 0) {
                repeat++;
                //不存在，就++
            } else {
                m[sChs[i] - 'a']++;
            }
            //同位置不等的情况
            if(sChs[i] != gChs[i]) {
                //不等的数量增加
                count++;
                //两个不同位置的坐标
                if(x == -1) {
                    x = i;
                } else if(y == -1) {
                    y = i;
                }
            }

        }
        //完全相同，且字符串中有重复字母
        if(count == 0 && repeat > 0) {
            return true;
        }
        //有两个位置不同，且两个不同的位置满足s[i] == g[j] && s[j] == g[i];
        if(count == 2 && sChs[x] == gChs[y] && sChs[y] == gChs[x]) {
            return true;
        }
        //其他情况都是false;
        return false;

    }
}
