/**
 * Leetcode1748题，唯一元素的和
 * 关键字：数组、哈希
 * 主要思路：
 * 1. 数字范围是1~100，所以可以用一个长度100的数组记录数字出现的次数
 * 2. 将出现次数为1的相加即可
 */
public class LC1748 {
    public int sumOfUnique(int[] nums) {
        int[] arrays = new int[100];
        for(int num : nums) {
            arrays[num-1]++;
        }
        int sum = 0;
        for (int i = 0; i < arrays.length; i++) {
            if(arrays[i] == 1) {
                sum += i+1;
            }
        }
        return sum;
    }
}
