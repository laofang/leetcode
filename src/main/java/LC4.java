/**
 * Leetcode第四题，寻找两个正序数数组的中位数
 * 基本是看了解析代码后默写下来的，自己尝试用二分法来写有些问题
* 自己实现二分法时的问题：
* 1. 想用一个方法求解第k 与 k + 1小的数，造成判断嵌套过多，逻辑不清的问题
* 2. 要明确下标索引和元素个数之前的区别，要做到心中有数
* 这道题之后还要重点关注一下，logN时间复杂度还是有一定难度的，这道题花了很久的思考时间
 */
public class LC4 {
    /**
     * 根据总数是奇数还是偶数分为两种情况
     * 1. 奇数是求第 n / 2 + 1小的数
     * 2. 偶数是求第 n / 2 和 n / 2 + 1小的数的平均数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if(totalLength % 2 == 1) {
            int medium = totalLength / 2 + 1;
            return getKthElement(nums1,nums2,medium);
        } else {
            int medium1 = totalLength / 2;
            int medium2 = totalLength / 2 + 1;
            return ((getKthElement(nums1,nums2,medium1) + getKthElement(nums1,nums2,medium2)) / 2.0);
        }

    }

    /**
     * 求两个有序序列的第k小的数，二分法实现
     */
    public int getKthElement(int nums1[],int nums2[],int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while(true) {
            //第一数组的全部数已经被淘汰
            if(index1 == nums1.length) {
                return nums2[index2 + k -1];
            }
            //第二数组的全部被淘汰
            if(index2 == nums2.length) {
                return nums1[index1 + k -1];
            }
            //比较到求第一小的数
            if(k == 1) {
                return Math.min(nums1[index1],nums2[index2]);
            }

            //一般情况，每个数组比较当前索引后的第（half - 1）个元素
            int half = k / 2;
            //重点，获取比较的索引，若index + half >= length1 说明数组长度已不足，使用最后一个元素比较即可
            int newIndex1 = Math.min(index1 + half,length1) - 1;
            int newIndex2 = Math.min(index2 + half,length2) - 1;
            //比较，小的对应数组newindex以及之前的元素被排除，下一次比较从newindex + 1开始
            if(nums1[newIndex1] >= nums2[newIndex2]) {
                //更新k值，每次排除掉较小数组那里的newindex - index2 + 1 个数
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
            else {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }
        }
    }
}
