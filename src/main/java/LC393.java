/**
 * Leetcode393题，UTF-8编码验证
 * 关键字：位运算
 * 主要思路：
 * 1. 先通过位运算，得到第一个0之前有几个1，来确定是几字节的字符编码
 * 2. 之后再验证每个字符，第二个字节开始，是否是01开头
 */
public class LC393 {
    public boolean validUtf8(int[] data) {

        int testOther = 2;

        for (int i = 0; i < data.length; i++) {
            int testOne = 1 << 7;
            int k = 0;
            while((testOne & data[i])!= 0) {
                testOne = testOne >>>1;
                k++;
            }

            if(k > 4 || k == 1) return false;

            if(k > 0) k--;

            if(data.length - i - 1 < k) return false;

            for(int j = i + 1; j <= i + k; j++) {
                int temp = (data[j] >>> 6) & testOther;
                if(temp != 2) {
                    return false;
                }
            }
            i = i + k;
        }
        return true;
    }
}
