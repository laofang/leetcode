/**
 * Leetcode836题，矩形重叠
 * 关键字：几何、数学
 * 主要思路：
 * 1. 不重叠的情况只有四种，其余都重叠
 */
public class LC836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[0] >= rec2[2] || rec2[0] >= rec1[2] || rec1[1] >= rec2[3] || rec2[1] >= rec1[3]);
    }
}
