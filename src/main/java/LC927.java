/**
 * Leetcode927题，三等分
 * 关键字：数组、数学
 * 主要思路：
 * 1. 三等分的三个部分的含有的1的数量一定是相同的
 * 2. 每一部分第一个1到最后一个1所构成的二进制数是相同的
 * 3. 最后一部分的后缀零是固定的，第一部分的后缀0和第二部分的后缀0的数量>=最后一部分后缀0的数量
 * 4. 保证2和3，就能三等分
 */
public class LC927 {
    public int[] threeEqualParts(int[] arr) {
        int cnt1 = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) ++cnt1;
        }
        if(cnt1 == 0) return new int[]{0,arr.length - 1};
        if(cnt1 % 3 != 0) return new int[]{-1,-1};
        int pCnt = cnt1 / 3;
        int i = 0;
        int j = 0;


        while(arr[i] == 0) i++;
        int s0 = i;
        while(j < pCnt) {
            if(arr[i] == 1) ++j;
            ++i;
        }
        int e0 = i;

        while(arr[i] == 0) i++;
        int s1 = i;
        while(i - s1 < e0 - s0) {
            if(arr[i] != arr[s0+(i-s1)]) return new int[]{-1,-1};
            i++;
        }
        int e1 = i;

        while(arr[i] == 0) i++;
        int s2 = i;
        while(i - s2 < e0 - s0) {
            if(arr[i] != arr[s0 + (i - s2)]) return new int[]{-1,-1};
            i++;
        }
        int e2 = i;

        int last0Cnt = arr.length - e2;

        if(s1 - e0 >= last0Cnt && s2 - e1 >= last0Cnt) return new int[]{(e0 - 1) + last0Cnt,e1+ last0Cnt};
        return new int[]{-1,-1};
    }
}
