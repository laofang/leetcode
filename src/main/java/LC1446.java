/**
 * Leetcode1446题，连续字符
 * 关键字：字符串、重复字符
 * 主要思路：
 * 1. 类似的题目做过不少，记录每一个字符重复的数量，然后求其中最大的
 * 2. 注意的地方有一个，就是最后如果始终重复，在出循环之前没有进行比较，循环之后，要再比较一次
 */
public class LC1446 {
    public int maxPower(String s) {
        //答案
        int ans = 0;
        //记录每一个重复的长度
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            //如果和前一个字符相等，count++
            if(i > 0 && s.charAt(i) == s.charAt(i-1)) {
                count++;
            //不相等（包括第0个）count重置为1
            } else {
                count = 1;
            }
            //ans答案
            ans = Math.max(ans,count);
        }
        //如果s后缀是重复的，那需要比较最后一次
        ans = Math.max(ans,count);
        return ans;
    }
}
