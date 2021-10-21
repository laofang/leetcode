/**
 * Leetcode33题，搜索旋转排序数组
 * 关键字：数组，排序，查找，二分法
 * 主要思路：
 * 1. 按题目的进阶要求（logn）复杂度，那就要使用二分法
 * 2. 我们可以找到中间位置，判断中间位置和两端的关系，即可知道左部分还是右部分是有序的
 * 3. 左半部分完全大于右半部分
 * 4. 对有序部分进行二分查找，如果没有，就对非有序部分重复步骤2
 */
public class LC33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (right + left) / 2;
            //这说明左部分是有序的，对左部分二分查找
            if(nums[mid] >= nums[left]) {
                //左边二分查找
                int lLeft = left;
                int lRight = mid;
                //二分查找要注意边界
                while(lLeft <= lRight) {
                    int lMid = (lRight + lLeft) / 2;
                    if(nums[lMid] == target) {
                        return lMid;
                    } else if(nums[lMid] > target) {
                        lRight = lMid - 1;
                    } else {
                        lLeft = lMid + 1;
                    }
                }
                //左边没找到，那就对右半部分重复查找
                left = mid + 1;
            } else {
                //右边二分查找，与上面基本相同
                int rLeft = mid;
                int rRight = right;
                while(rLeft <= rRight) {
                    int rMid = (rRight + rLeft) / 2;
                    if(nums[rMid] == target) {
                        return rMid;
                    } else if(nums[rMid] > target) {
                        rRight = rMid - 1;
                    } else {
                        rLeft = rMid + 1;
                    }
                }
                //再将左边的二分
                right = mid - 1;
            }
        }
        return -1;
    }
}
