/**
 * Leetcode1620题，网络信号最好的坐标
 * 关键字：数组、枚举
 * 主要思路：
 * 1. 就大力出奇迹，暴力枚举，算出每个点的信号强度，保留最大的并返回。
 */
public class LC1620 {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] ans = new int[2];
        double max = 0;
        for(int i = 0; i <= 50; i++) {
            for(int j = 0; j <= 50; j++) {
                double val = 0;
                for(int[] tower : towers) {
                    double d = Math.sqrt((tower[0] - i) * (tower[0] - i) + (tower[1] - j) * (tower[1] - j));
                    if( d <= radius) {
                        val += Math.floor(tower[2] / (1 + d));
                    }
                }
                if(val > max) {
                    ans[0] = i;
                    ans[1] = j;
                    max = val;
                }
            }
        }
        return ans;
    }
}
