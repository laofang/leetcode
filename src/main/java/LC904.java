/**
 * Leetcode904题，水果成篮
 * 关键字：数组、哈希表、滑动窗口
 * 主要思路：
 * 1. 这道题就是求含有两个不同元素的最长子序列
 * 2. 使用滑动窗口的方式，求出每个[l,r]中只包含两个元素的最长匹配，更新结果
 */
public class LC904 {
    public int totalFruit(int[] fruits) {
        int l = 0;
        int r = 0;
        int series = 0;
        int ans = 0;
        int[] sToCnt = new int[fruits.length];
        while(r < fruits.length) {
            while(series < 3 && r < fruits.length) {
                sToCnt[fruits[r]]++;
                if(sToCnt[fruits[r]] == 1) ++series;
                if(series > 2) break;
                r++;
            }
            ans = Math.max(ans,r - l);
            while(series > 2) {
                sToCnt[fruits[l]]--;
                if(sToCnt[fruits[l]] == 0) --series;
                l++;
                if(series == 2) break;
            }
            r++;
        }
        return ans;
    }
}
