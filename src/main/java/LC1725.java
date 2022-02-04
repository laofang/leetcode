/**
 * Leetcode1725题，可以形成最大正方形的矩形数目
 * 关键字：数组、哈希
 * 主要思路：
 * 1. 遍历正方形数组
 * 2. 遍历过程中，记录最长边，记录数量
 * 3. 如果有边长更长的，更新长度，更新数量为1
 * 4. 重复之前的过程
 */
public class LC1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int count = 0,max = 0,a=0;
        for (int i = 0; i < rectangles.length; i++) {
            if( (a = Math.min(rectangles[i][0],rectangles[i][1])) < max) continue;
            if (a > max){
                max = a;
                count = 1;
            } else {
                max = a;
                count++;
            }
        }
        return count;
    }
}
