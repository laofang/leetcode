/**
 * Leetcode400题，第N位数字
 * 关键字：数学、二分查找
 * 主要思路：
 * 1. 主要就是找规律
 * 2. 如果数字的长度为len，则len位的数字总长度为 len * 9 * 10^len-1
 * 3. 找到n在那个位数总长度范围内
 * 4. 当前len位最小的数是10^len-1，算出n相对它的偏移
 * 5. 就可以知道对应的数字是多少
 * 6. 再根据对于位数的余数，就可以得到这个位数
 */
public class LC400 {
    public int findNthDigit(int n) {
        int len = 1;
        int sum = 0;
        //确定位数对应数字的位数
        while(true) {
            sum += (int)(len * 9 * Math.pow(10,len-1));
            if(n < len * 9 * Math.pow(10,len-1) || n <= sum) {
                break;
            }
            len++;
        }
        //相对于位数最小数字的偏移位数
        for(int i =1; i < len ; i++) {
            n -= (int)(i * 9 * Math.pow(10,i-1));
        }
        //相对于最小位数的偏移数
        int k =  (n - 1) / len +1;
        //位数 余0是最后一位，其余是从左向右的位数
        int b = n % len;
        //n对应的数字
        int num = (int)(Math.pow(10,len-1) + k - 1);
        int ans = 0;
        //获取对应的位
        for(int i = 1; i <= b; i++) {
            ans = num / (int)(Math.pow(10,len-i));
            num %= (int)(Math.pow(10,len-i));
            if(i == b) {
                return ans;
            }
        }
        return num % 10;
    }
}
