/**
 * Leetcode693题，交替位二进制数
 * 关键字：位运算
 * 主要思路：
 * 1. 可以按位检查
 * 2. 可以让目标数错位异或，形成形如00001111这样的数
 * 3. 将获得的数 + 1 与 原本的数相与，结果是0，说明是交替二进制数，否则不是
 */
public class LC693 {
    public boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);
        if( (x & (x + 1)) == 0) return true;
        return false;
    }
}
