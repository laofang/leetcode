/**
 * Leetcode1356题，根据数字二进制下1的数目排序
 * 关键字：位运算、数组、计数、排序
 * 主要思路：
 * 1. 位运算 和 冒泡排序
 */
public class LC1356 {
    public int[] sortByBits(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                int val = compareTo(arr[j],arr[j+1]);
                if(val > 0) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }
    public int compareTo(int num1, int num2) {
        int test = 1;
        int i = 0;
        int val1 = 0;
        int val2 = 0;
        while ( i < 32) {
            if( ( (test << i) & num1) > 0) {
                val1++;
            }
            if( ( (test << i) & num2) > 0) {
                val2++;
            }
            i++;
        }
        return val1 == val2 ? num1 - num2 : val1 - val2;
    }
}
