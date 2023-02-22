/**
 * Leetcode657题，机器人能否返回原点
 * 关键字：字符串、模拟
 * 主要思路：
 * 1. 'U'和'D'数量相同，'L'和'R'数量相同，说明可以回到原点
 */
public class LC657 {
    public boolean judgeCircle(String moves) {
        int[] cnt = new int[4];
        char[] chs = moves.toCharArray();
        for(int i = 0; i < chs.length; i++) {
            if(chs[i] == 'U') {
                cnt[0]++;
            } else if(chs[i] == 'D') {
                cnt[1]++;
            } else if(chs[i] == 'L') {
                cnt[2]++;
            } else {
                cnt[3]++;
            }
        }
        return cnt[0] == cnt[1] && cnt[2] == cnt[3];
    }
}


//todo 逃课 LC1140题，石子游戏II，中等题，回溯加记忆化搜索