/**
 * Leetcode278题，第一个错误版本
 * 关键字：二分查找、交互
 * 主要思路：
 * 1. 简单的二分查找，查找最小索引的true
 */
public class LC278 {
    public int firstBadVersion(int n) {
        long l = 1;
        long r = n;
        while( l <= r) {
            long half = (l + r) / 2;
            if(isBadVersion((int)half)) {
                r = half - 1;
            } else {
                l = half + 1;
            }
        }
        return (int)l;
    }
    private boolean isBadVersion(int n){return true;}
}
