import java.util.Random;

/**
 * Leetcode384题，打乱数组
 * 关键字：数组、随机
 * 主要思路：
 * 1. 洗牌算法，我记得在大学的《数据结构与算法》的书里见过，并实践过；
 * 2. Java的随机算法需要复习一下；
 * 3. System.arraycopy方法需要掌握一下。
 */
public class LC384 {
    //用来随机的数组变量
    int[] nums;
    //用来记录原始值的数组变量
    int[] original;
    //初始化方法
    public LC384(int[] nums) {
        this.original = nums;
        this.nums = new int[original.length];
        System.arraycopy(original,0,this.nums,0,original.length);
    }
    //将记录原始数组复制给随机数组就是重置
    public int[] reset() {
        System.arraycopy(original,0,nums,0,original.length);
        return nums;
    }
    //洗牌算法，在当前范围内生成一个随机索引index，index∈[0,nums.length-1],然后将index与当前范围内的最后一个元素交换，排除最后一个元素，缩小范围，重复这一过程
    public int[] shuffle() {
        Random random = new Random();
        for(int i = 0; i < nums.length; i++) {
            int index = random.nextInt(nums.length - i);
            int temp = nums[nums.length - i -1];
            nums[nums.length - i - 1] = nums[index];
            nums[index] = temp;
        }
        return nums;
    }
}
