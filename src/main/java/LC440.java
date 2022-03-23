/**
 * Leetcode440题，字典序的第k小数字
 * 关键字：前缀树
 * 主要思路：
 * 1. 可以把前缀树看成是一个十叉树
 * 2. 比较当前节点子节点的数量和k
 *      1. 如果k更大，说明k出现在当前节点的兄弟节点上，移动到兄弟节点，同时k = k - nodes
 *      2. 如果k<=子节点数量，说明在当前节点的子节点上，向下移，也就是cur *= 10，--k;
 */
public class LC440 {
    public int findKthNumber(int n, int k) {
        long cur = 1;
        //如果当前节点不是最终稿节点
        while(k > 1) {
            //看当前节点的子节点数量
            long childNodes = getCount(cur,n);
            if(k > childNodes) {
                //cur向右移，同时k跨过上一个节点的所有子节点
                k -= childNodes;
                ++cur;
            } else {
                //cur向下移动，k减少1
                --k;
                cur *= 10;
            }
        }
        return (int) cur;
    }
    //获取子节点数量
    public long getCount(long cur,int n) {
        long ans = 0;
        long next = cur + 1;
        //分别加上每一层的数量
        //当前节点的下一层数量 = 当前节点的后一个兄弟节点的左边界 - 当前节点下一层的左边界
        while(cur <= n) {
            //如果next 超过 n ，就用n - cur
            ans += Math.min(next - cur,n - cur + 1);
            next *= 10;
            cur *= 10;
        }
        return ans;
    }
}
