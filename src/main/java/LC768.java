/**
 * Leetcode768题，最多能完成排序的块II
 * 关键字：栈、贪心、数组、排序、单调栈
 * 主要思路：
 * 1. 遍历数组，并记录遍历过的最大值
 * 2. 如果当前cur >= preMax，则块数增加
 * 3. 如果当前cur < preMax，则从开始进行遍历，找到第一个大于 cur的值，将cur与这个值之间的数都归属于这个值所属的块
 */
public class LC768 {
    public int maxChunksToSorted(int[] arr) {
        int max = arr[0];
        int[] blockNum = new int[arr.length];
        blockNum[0] = 1;
        for(int i = 1; i < arr.length;i++) {
            if(arr[i] >= max) {
                blockNum[i] = blockNum[i-1]+1;
                max = arr[i];
            } else if(arr[i] < max) {
                for(int j = 0; j < i; j++) {
                    if(arr[j] > arr[i]) {
                        for(int k = j + 1; k <= i; k++) {
                            blockNum[k] = blockNum[j];
                        }
                        break;
                    }
                }
            }
        }
        return blockNum[blockNum.length-1];
    }
}
//TODO LC768，最多能完成排序的块II，困难，当前是暴力循环，可进一步优化