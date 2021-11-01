import java.util.Arrays;

/**
 * Leetcode575题，分糖果
 * 关键字：数组、去重、贪心
 * 主要思路：
 * 1. 一共有多少种糖，如果种类的数量>=糖的一半，那就最多有length/2种
 * 2. 如果小于一半，那就是种类的数量
 */
public class LC575 {
    public int distributeCandies(int[] candyType) {
        int k = candyType.length / 2;
        int sisType = 1;
        //排序
        Arrays.sort(candyType);
        //再看糖果的种类数量
        for (int i = 1; i < candyType.length; i++) {
            if (sisType >= k) {
                break;
            }
            if (candyType[i] != candyType[i - 1]) {
                sisType++;
            }
        }
        return sisType;
    }
}
