/**
 * Leetcode868题，二进制间距
 * 关键字：位运算、数学
 * 主要思路：
 * 1. 标志移位与运算
 * 2. 记录前一个1的位置，与当前1的位置相减，与记录相比，如果更大就更新
 */
public class LC868 {
    public int binaryGap(int n) {
        int preIndex = -1;
        int i = 0;
        int flag = 1;
        int ans = 0;
        while(flag != 0) {
            if((flag & n) != 0) {
                if(preIndex != -1) {
                    ans = Math.max(ans,i - preIndex);
                }
                preIndex = i;
            }
            flag = flag << 1;
            i++;
        }
        return ans;
    }
}
