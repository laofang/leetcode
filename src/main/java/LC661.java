/**
 * Leetcode661题，图片平滑器
 * 关键字：数组、矩阵
 * 主要思路：
 * 1. 循环统计即可
 */
public class LC661 {
    public int[][] imageSmoother(int[][] img) {
        int[] directs = new int[]{0,-1,1};
        int[][] ans = new int[img.length][img[0].length];
        for(int i = 0; i < img.length; i++) {
            for(int j = 0; j < img[0].length;j++) {
                int count = 0;
                int sum = 0;
                for(int x = 0; x < directs.length; x++) {
                    for(int y = 0; y < directs.length; y++) {
                        int nI = i + directs[x];
                        int nJ = j + directs[y];
                        if(nI < 0 || nI >= img.length || nJ < 0 || nJ >= img[0].length) continue;
                        ++count;
                        sum += img[nI][nJ];
                    }
                }
                ans[i][j] = sum / count;
            }
        }
        return ans;
    }

}
