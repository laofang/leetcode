/**
 * Leetcode74题，搜索二维矩阵
 * 关键字：二维矩阵、二分法、二维数组
 * 主要思路：
 * 1. 将二维数组的元素的序数，转化为二维数组的坐标，使用二分法搜索
 */
public class LC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        //右界是数字的个数
        int right = matrix.length * matrix[0].length ;
        int n = matrix[0].length;
        while(left < right) {
            int half = (left + right) / 2;
            //转换为二维坐标
            int i = half / n;
            int j = half % n;
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] < target) {
                left = half + 1;
            } else {
                right = half;
            }
        }
        return false;
    }
}
