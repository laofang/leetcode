/**
 * Leetcode780题，到达终点
 * 关键字：数字
 * 主要思路：
 * 1. 从终点向起点逆推，大的减小的
 * 2. 但相减过慢，会超时，可以用mod运算
 */
public class LC780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx > sx && ty > sy && tx != ty) {
            if(ty > tx) {
                ty %= tx;
            } else {
                tx %= ty;
            }
        }
        if(tx == sx && ty == sy) {
            return true;
        } else if(tx == sx && ty > sy && (ty - sy) % tx == 0) {
            return true;
        } else if(ty == sy && tx > sx && (tx - sx) % ty == 0) {
            return true;
        } else {
            return false;
        }
    }
}
