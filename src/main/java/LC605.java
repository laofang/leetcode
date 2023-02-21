/**
 * Leetcde605题，种花问题
 * 关键字：贪心、数组
 * 主要思路：
 * 1. 假设连续的0有n个，可以放置(n-1)/2个花（两侧的0都紧挨着1）
 * 2. 要考虑两侧的0在花坛两端的情况，这个时候在端点相当于在左或右又加了一个0
 */
public class LC605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        int l = 0;
        int r = 0;
        int m = flowerbed.length;
        if(m == 1 && flowerbed[0] == 0) return true;
        while(l < m && r < m) {
            while(l < m &&flowerbed[l] != 0) l++;
            r = l + 1;
            while(r < m && flowerbed[r] != 1) r++;
            int v = 0;
            if(l == 0) v++;
            if(r == m) v++;
            cnt += (r - l + v - 1) / 2;
            l = r;
        }
        return n <= cnt;
    }
}
