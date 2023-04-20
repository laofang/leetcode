/**
 * Leetcode832题，反转图像
 * 关键字：双指针、矩阵、数组、模拟
 * 主要思路：
 * 1. 对每一行水平反转，水平反转的同时就进行反转
 */
public class LC832 {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i = 0; i < image.length; i++) {
            int[] vals= image[i];
            int l = 0;
            int r = image[i].length - 1;
            while(l <= r) {
                int temp = vals[r];
                vals[r] = vals[l] == 1 ? 0 : 1;
                vals[l] = temp == 1 ? 0 : 1;
                l++;
                r--;
            }
        }
        return image;
    }
}
//todo, 逃课Leetcode1187题，使数组严格递增，困难