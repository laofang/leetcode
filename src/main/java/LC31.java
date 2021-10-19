/**
 * Leetcode31题，下一个排列
 * 关键词：数组
 * 主要思路：
 * 1. 首先从后向前找到相邻的升序数组，记为nums[i-1]和nums[i]
 * 2. 如果i不等于0，说明i~nums.length-1中从后向前至少存在一个比nums[i-1]小的值，至少有一个nums[i]存在
 * 3. 然后把从后向前的第一个大于nums[i-1]进行交换
 * 4. 最后将nums[i]~nums[length-1]所有元素反转
 *
 */
public class LC31 {
    public void nextPermutation(int[] nums) {
        //nums.length 的长度为0或者为1,返回
        if(nums.length == 0 || nums.length == 1) {
            return;
        }
        int i = nums.length - 1;
        //比较相邻元素，找到第一个升序对
        for(; i >= 1; i--) {
            if(nums[i-1] < nums[i]) {
                break;
            }
        }
        int j = nums.length-1;
        if(i!=0){
            //再从后向前找到一个比nums[i-1]大的值，进行交换
            for(; j >= i; j--) {
                if(nums[j] > nums[i-1]) {
                    int temp = nums[j];
                    nums[j] = nums[i-1];
                    nums[i-1] = temp;
                    break;
                }
            }
        }
        //对第i（包括i）之后的部分进行反转
        reserve(nums,i,nums.length - 1);
    }

    /**
     * 一个反转算法
     */
    public void reserve(int[] nums,int start,int end) {
        int len = nums.length;
        if(start < 0 || end >= len || start >= end || len == 1) {
            return;
        }
        while(start < end) {
            int temp = 0;
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
        return;
    }
}
