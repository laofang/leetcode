/**
 * Leetcode1629题，按键持续时间最长的键
 * 关键字：数组
 * 主要思路：
 * 1. 每次按键的时间，与记录比较
 * 2. 如果大于更新记录，如果等于，看字母顺序
 */
public class LC1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char key = keysPressed.charAt(0);
        int maxTimes = releaseTimes[0];
        int n = releaseTimes.length;
        for(int i = 1; i < n; i++) {
            int times = releaseTimes[i] - releaseTimes[i-1];
            if(times > maxTimes) {
                key = keysPressed.charAt(i);
                maxTimes = times;
            } else if(times == maxTimes && ((keysPressed.charAt(i) - key) > 0)) {
                key = keysPressed.charAt(i);
                maxTimes = times;
            }

        }
        return key;
    }
}
