/**
 * Leetocode540题，有序数组中的单一元素
 * 关键字：数组、二分法
 * 主要思路：
 * 1. 题目要求时间复杂度O(logn)，空间复杂度O(1)，因为有序，所以首先想到二分法
 * 2. 在二分的时候，如果当前元素是第一个元素，或最后一个元素，则当前元素必然是答案
 * 3. 如果当前元素与左右元素不等，当前元素是答案
 * 4. 如果当前元素只与左侧元素，或只与右侧元素不等，则分情况，将数组分为左右两部分
 * 5. 哪一部分是奇数，说明目标元素在其中，则对奇数长度的部分进行二分
 */
public class LC540 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length;

        while(l < r) {
            int half = (l + r) / 2;
            if(half == 0 || half == nums.length - 1) return nums[half];
            if(nums[half-1] != nums[half] && nums[half+1] != nums[half]) {
                return nums[half];
                //cur和左相等
            } else if(nums[half - 1] == nums[half]){
                //左侧为偶数
                if( ( half - 0 + 1) % 2 == 0) {
                    l = half + 1;
                } else {
                    r = half;
                }
                //cur和右相等
            } else {
                if((nums.length - half) % 2 == 0) {
                    r = half;
                } else {
                    l = half + 1;
                }
            }
        }
        return -1;
    }
}
