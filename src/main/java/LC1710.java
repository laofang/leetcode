import java.util.Arrays;

/**
 * Leetcode1710题，卡车上的最大单元数
 * 关键字：贪心、数组、排序
 * 主要思路：
 * 1. 要让每个箱子，有尽可能多的装载单元数量，所以要先进行排序，按单位箱子装载单元数量从大到小排序，
 * 2. 按顺序选择箱子，直到装满卡车
 */
public class LC1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(e1, e2)->e2[1] - e1[1]);
        int ans = 0;
        int i = 0;
        while(i < boxTypes.length) {
            if(boxTypes[i][0] < truckSize) {
                ans += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else {
                ans += truckSize * boxTypes[i][1];
                break;
            }
            i++;
        }
        return ans;
    }
}
