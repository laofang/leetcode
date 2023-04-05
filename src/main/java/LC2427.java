/**
 * Leetcode2427题，公因子的数目
 * 关键字：数学、枚举、数论
 * 主要思路：
 * 1. 选两个数字中较小的那个作为n，遍历[1,n]，如果a和b可以和遍历的数字整除，就递增结果记录
 */
public class LC2427 {
    public int commonFactors(int a, int b) {
        int n = Math.max(a,b);
        int ans = 0;
        for(int  i = 1; i <=n; i++) {
            if(a % i ==0 && b % i == 0) {
                ans++;
            }
        }
        return ans;
    }
}
