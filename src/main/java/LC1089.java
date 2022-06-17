/**
 * Leetcode1089题，复写零
 * 关键字：数组、双指针
 * 主要思路：
 * 1. 第一种方式是统计0的数量，然后从后向前，每个元素移到i+cnt个位置，0特殊处理
 * 2. 第二种方式是用双指针，之后再从后向前复写
 */
public class LC1089 {
    public void duplicateZeros(int[] arr) {
        int zeroCnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) zeroCnt++;
        }
        for(int j = arr.length - 1; j >= 0 && zeroCnt > 0; j--) {
            int index = 0;
            if(arr[j] != 0) {
                if((index = j + zeroCnt)< arr.length) {
                    arr[index] = arr[j];
                }
            } else {
                zeroCnt--;
                if((index = j + zeroCnt) < arr.length) {
                    arr[index] = arr[j];
                    if(++index < arr.length) arr[index] = 0;
                }
            }
        }
    }

    public void duplicateZeros1(int[] arr) {
        int i = -1, j = -1;
        while(j < arr.length) {
            i++;
            if( i>= arr.length) {
                i--;
                break;
            }
            j = arr[i] > 0 ? j + 1 : j + 2;
        }
        if(i == j) return;
        while(j > 0) {
            if(arr[i] > 0) {
                if(j < arr.length) arr[j] = arr[i];
            } else {
                if(j < arr.length) {
                    arr[j--] = arr[i];
                    arr[j] = arr[i];
                } else {
                    if(--j < arr.length) {
                        arr[j] = arr[i];
                    }
                }
            }
            i--;
            j--;
        }
    }
}
