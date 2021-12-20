import java.util.Arrays;

/**
 * Leetcode475题，供暖期
 * 关键字：数组、排序、双指针
 * 主要思路：
 * 1. 先将房子和供暖器进行排序
 * 2. 找到每个房子距离最近的那个供暖期
 * 3. 找出这个距离中最大的那个
 */
public class LC475 {
    public int findRadius(int[] houses, int[] heaters) {
        //将房子和供暖期进行排序
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            //当前房子与供暖器的距离
            int curDistance = Math.abs(houses[i] - heaters[j]);
            //如果从左向右的时候，距离不断缩小，就继续向右
            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                //更新最短距离
                curDistance = Math.min(curDistance, Math.abs(houses[i] - heaters[j]));
            }
            //最短距离中最大的那个
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }
}
