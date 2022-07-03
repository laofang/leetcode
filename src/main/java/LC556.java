/**
 * Leetcode556题，下一个更大元素III
 * 关键字：数学、双指针、字符串
 * 主要思路：
 * 1. 可以参考31.下一个排列
 * 2. 从后向前遍历找到第一个chs[i] > chs[i-1]的位置
 * 3. 再[i,length-1]中从后向前，找到第一个>chs[i-1]的元素，与chs[i-1]交换
 * 4. 最后将[i,length-1]翻转
 */
public class LC556 {
    public int nextGreaterElement(int n) {
        char[] chs = String.valueOf(n).toCharArray();
        for(int i = chs.length-1; i > 0; i--){
            if(chs[i] > chs[i-1]) {
                for(int j = chs.length-1; j >=i;j--) {
                    if(chs[j] > chs[i-1]) {
                        char temp = chs[j];
                        chs[j] = chs[i-1];
                        chs[i-1] = temp;
                        reverse(chs,i,chs.length-1);
                        try {
                            return Integer.valueOf(String.valueOf(chs));
                        } catch (Exception e) {
                            return -1;
                        }
                    }
                }
            }
        }
        return -1;
    }
    public void reverse(char[] chs,int left,int right) {
        while(left < right) {
            char temp = chs[left];
            chs[left] = chs[right];
            chs[right] = temp;
            left++;
            right--;
        }
    }
}
