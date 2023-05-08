/**
 * Leetcode914题，卡牌分组
 * 关键字：数组、哈希表、数学、计数、数论
 * 主要思路：
 * 1. 求出所有数字个数的公约数
 */
public class LC914 {
    public boolean hasGroupsSizeX(int[] deck) {
        int min = Integer.MAX_VALUE;
        int[] table = new int[10000];
        for(int val : deck) {
            table[val]++;
        }
        int ans = 0;
        for(int i = 0; i < table.length; i++) {
            if(table[i] == 0) continue;
            if(ans == 0) ans = table[i];
            ans = gcd(ans,table[i]);
        }
        return ans >= 2;
    }
    public int gcd(int a, int b) {
        if(a == b) return a;
        return gcd(Math.min(a,b),Math.abs(a-b));
    }
}
