import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode1128题，等价多米诺骨牌对的数量
 * 关键字：数组、哈希表、计数
 * 主要思路：
 * 1. 假设key为dominoes[i][0]和dominoes[i][1]中较小的一个*10+较大的一个，对key计数
 * 2. 假设相同的key的数量为n，则这个key的对数为(n-1 + 1) * (n-1) / 2
 */
public class LC1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < dominoes.length; i++) {
            int temp = 0;
            if(dominoes[i][0] > dominoes[i][1]) {
                temp = dominoes[i][0];
                dominoes[i][0] = dominoes[i][1];
                dominoes[i][1] = temp;
            }
            int sum = dominoes[i][0] * 10 + dominoes[i][1];
            int cnt = map.getOrDefault(sum,0);
            map.put(sum,cnt + 1);
        }
        int ans = 0;
        for (int i = 0; i < dominoes.length; i++) {
            int cnt = map.getOrDefault(dominoes[i][0] * 10 + dominoes[i][1],0);
            ans += (cnt - 1 + 1) * (cnt - 1) / 2;
            map.put(dominoes[i][0] * 10 + dominoes[i][1],0);
        }
        return ans;
    }
}
