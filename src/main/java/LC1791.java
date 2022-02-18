/**
 * Leetcode1791题，找出星型图的中心结点
 * 关键字：数组、二维数组、图
 * 主要思路：
 * 1. 选择两条边，这两条边共有的点，就是答案
 */
public class LC1791 {
    public int findCenter(int[][] edges) {
        for(int i = 0; i < 2;i++) {
            for (int j = 0; j < 2; j++) {
                if(edges[0][i] == edges[1][j]) return edges[0][i];
            }
        }
        return -1;
    }
}
