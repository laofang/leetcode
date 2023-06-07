import java.util.Arrays;

/**
 * Leetcode2611题，老鼠和奶酪
 * 关键字：贪心、数组、排序、堆
 * 主要思路：
 * 1. 先将reward2和reward1对应位置做差，存为数组，同时假设奶酪都被第二只老鼠吃掉，计算得分
 * 2. 将差数组进行排序，差越小，换为第一只老鼠吃越满足题目要求，安排好序的顺序换k个即可
 */
public class LC2611 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int[] cha = new int[reward1.length];
        int ans = 0;
        for(int i = 0; i < reward1.length; i++) {
            cha[i] = reward2[i] - reward1[i];
            ans += reward2[i];
        }
        Arrays.sort(cha);
        for(int i = 0; i < k; i++) {
            ans -= cha[i];
        }
        return ans;
    }
}
