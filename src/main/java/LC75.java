/**
 * Leetcode75题，颜色分类
 * 关键字：排序、双指针、荷兰国旗
 * 主要思路：
 * 1. 双指针，分别指向数组的两侧端点
 * 2. 然后遍历，如果当前元素是0，和左指针交换，如果当前元素是2，和右指针交换
 */
public class LC75 {
    public void sortColors(int[] nums) {
        //左指针从0开始
        int l = 0;
        //右指针最后一个元素位置
        int r = nums.length - 1;
        //i是当前的元素位置
        for (int i = 0; i < nums.length; i++) {
            if(i > r) break;
            //如果i==0，i和l位置交换，l向右移动
            if(nums[i] == 0) {
                nums[i] = nums[l];
                nums[l] = 0;
                l++;
                //如果i==2，i和r的位置元素交换，同时i不移动，r向左移动
            } else if(nums[i] == 2) {
                nums[i] = nums[r];
                nums[r] = 2;
                r--;
                i--;
            }
        }
    }
}
