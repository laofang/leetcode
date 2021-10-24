/**
 * Leetcode41题，缺失的第一个正数
 * 关键字：哈希，数组
 * 主要思路：
 * 1. 按这道题的要求，时间复杂度要O(n),空间复杂度要O(1),我实在想不到，看了解题思路，感觉就像下面评论说得那样，妙蛙种子吃着妙脆角回到了米奇妙妙屋，真是妙到家了，
 * 2. 这题的主要思路我称作原地hash，如果nums[i]的值在[1~nums.length]之间，则 nums[nums[i]-1] = nums[i],例如nums[0] = 1,nums[1] = 2这样
 * 3. 放好之后，只要遍历一次，哪个位置和值不匹配，如果都没有，那就是nums.length+1,所以最后返回i+1即可
 * 比较困难的地方在于，交换位置的时候，待交换的两个元素，有一个在自己的位置，那就不需要交换，不然要不停的交换
 */
public class LC41 {
    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
//            int index = nums[i] - 1;
//            if(index < 0 || index >= nums.length || nums[index] - 1 == index || nums[i] - 1 == i) {
//                continue;
//            }
            //如果当前的位置就是要找的，或者他的值不在这个范围，那就不需要交换
            while(nums[i] - 1 != i && nums[i] > 0 && nums[i] <= nums.length) {
                //要交换的位置
                int index = nums[i] - 1;
                //交换的原位置和目标位置有一个在自己应在的位置，那就不用换
                if(nums[index] - 1 == index || nums[i] - 1 == i) {
                    break;
                }
                //进行交换
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }

        }
        //遍历如果当前数字和位置不符合hash规则，那缺少的就是i+1这个数字
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1) {
                return i+1;
            }
        }
        //1~nums.length都在，那说明下一个就是最小的正整数，即nums.length+1
        return nums.length+1;
    }
}
