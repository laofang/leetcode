/**
 * Leetcode1742题，盒子中小球的最大数量
 * 关键字：哈希表、数学、计数
 * 主要思路：
 * 1. 计算每个数的各个位之和，使用hash表存储，并对记录进行累加，同时刷新出现次数的记录
 */
public class LC1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int max = 0;
        int[] boxes = new int[46];
        for(int i = lowLimit; i <= highLimit; i++) {
            int num = i;
            int sum = 0;
            while(num > 0) {
                sum += num % 10;
                num /= 10;
            }
            max = Math.max(max,++boxes[sum]);
        }
        return max;
    }
}
