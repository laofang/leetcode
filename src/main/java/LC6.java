/**
 * Leetcode第六题，Z字形变换
 * 主要思路：
 * 观察规律，除第一行和最后一行外，每一行的最小循环周期是两个数字，n为周期，
 * chars[i + n * (2 * numRows - 2)],
 * chars[(n + 1) * (2 * numRows - 2) - i]
 * 出现的问题：
 * 1. 审题不清，开始是打印出示例图形，导致错误
 * 2. 观察规律有问题，导致下标频繁越界
 * 3. 使用StringBuilder比String的效率明显提高
 */
public class LC6 {
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();
        //只有一行，直接返回
        if(numRows == 1) {
            return s;
        }
        //构造每一行
        for (int i = 0; i < numRows; i++) {
            //构造每一行的每一周期
            for(int n = 0; n < chars.length; n++){
                //每一周期的第一个数字
                int startNumIndex = i + n * (2 * numRows - 2);
                //第一个数字下标越界判断
                if(startNumIndex >= chars.length ){
                    break;
                }
                result.append(chars[startNumIndex]);
                //每一周期的第二个数字（第一行和最后一行没有）
                if(i != 0 && i != numRows - 1) {
                    int nextNumIndex = startNumIndex + (2 * numRows - 2) - 2 * i;
                    //第二个数字下标越界判断
                    if(nextNumIndex >= chars.length) {
                        break;
                    }
                    result.append(chars[nextNumIndex]);
                }
            }
        }
        return result.toString();
    }
}
