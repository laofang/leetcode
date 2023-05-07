/**
 * Leetcode1010题，总持续时间可被60整除的歌曲
 * 关键字：数组、哈希表、计数
 * 主要思路：
 * 1. 求出每一个时长模60的余数，任意两个余数和等于60的就时长和，就是60的整数倍（特殊的余数0和余数0的时长和为60的整数倍）
 * 2. 当前的和左侧已计算出的所需余数个数组合，就对答案进行增加更新
 */
public class LC1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        int[] modVal = new int[60];
        for(int i = 0; i < time.length; i++) {
            int val = time[i] % 60;
            ans += val == 0 ? modVal[0] : modVal[60 - val];
            modVal[val]++;
        }
        return ans;
    }
}
