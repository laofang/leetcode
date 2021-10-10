import java.util.Arrays;

/**
 * Leetcode第5895题，获取单值网格的最小操作数
 * 关键词：贪心，中位数，最小化曼哈顿距离
 * 整体思路：
 * 1. 合并一个队列
 * 2. 排序
 * 3. 获取中位数
 * 4. 所有数到中位数的操作数的和，每次要判断能否整除x，若不能整除则说明无法到达
 */
public class LC5895 {
    public int minOperations(int[][] grid, int x) {
        int[] nums = new int[grid.length * grid[0].length];
        //合并数组
        for(int i = 0; i < grid.length; i++) {
            int[] cols = grid[i];
            for(int j = 0; j < cols.length;j++) {
                nums[i * cols.length + j] = grid[i][j];
            }
        }
        //排序数组
        Arrays.sort(nums);
        //获取中位数
        int medium = nums[nums.length / 2];
        int res = 0;
        //获取每个数到中位数的操作和
        for(int i = 0; i<nums.length;i++) {
            if((nums[i] - medium) % x != 0) {
                return -1;
            }
            res += Math.abs(nums[i] - medium) / x;
        }
        return res;
    }
}
