/**
 * Leetcode48题，旋转图像
 * 关键字：矩阵、旋转
 * 主要思路：
 * 1. 我想的思路是从外圈到内圈，每圈进行旋转，每一圈只要遍历第一行的除最后一个即可
 * 2. 看了题解，上下交换，左对角线交换即可
 */
public class LC48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int k = (n+1) / 2;
        int[] p = new int[2];
        int temp = 0;
        int pre = 0;
        //圈数
        for(int i = 1; i <= k; i++) {
            //每圈对第一行的元素进行遍历，换到底就行（不包括最后一个元素）
            for(int m = i - 1; m < n - i ; m++) {
                p[0] = i - 1;
                p[1] = m;
                temp = matrix[p[0]][p[1]];
                do{
                    pre = temp;
                    p = nextPosition(p[0],p[1],n,i);
                    temp = matrix[p[0]][p[1]];
                    matrix[p[0]][p[1]] = pre;
//                    System.out.println(p[0] + " " + p[1] + " " + pre);

                } while(p[0] != i - 1 || p[1] != m);

            }
        }

    }

    /**
     * 通过当前坐标，获得旋转后的坐标
     * @param i 当前行坐标
     * @param j 当前列坐标
     * @param n 矩阵大小
     * @param count 第几圈
     * @return
     */
    public int[] nextPosition(int i, int j, int n, int count) {
        //行，列起始最小
        int s = 0 + count - 1;
        //行，列起始最大
        int e = n - 1 - (count - 1);
        //上面行的转变
        if(i == s && j != e) {
            i = j;
            j = e;
            //右边列转变
        } else if(j == e && i != e) {
            j = e - (i - s);
            i = e;
            //下面行转变
        } else if(i == e && j != 0) {
            i = j;
            j = s;
            //左边列转变
        } else{
            j = e - (i - s);
            i = s;
        }
        return new int[]{i,j};
    }
    //TODO LC48，旋转图像，上下交换，左对角线交换实现
}
