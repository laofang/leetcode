/**
 * Leetcode860题，柠檬水找零
 * 关键字：贪心、数组
 * 主要思路：
 * 1. 记录五美元和十美元的数量，找零时优先找10美元，其次再是5美元
 */
public class LC860 {
    public boolean lemonadeChange(int[] bills) {
        //5美元和10美元的数量
        int cnt5 = 0, cnt10 = 0;
        for (int bill : bills) {
            //如果是5美元，直接收
            if (bill == 5) {
                cnt5++;
                //如果是10美元，只有手里有5美元才能找零，找零后收取
            } else if (bill == 10) {
                if (cnt5 == 0) return false;
                cnt5--;
                cnt10++;
                //如果是20美元
            } else {
                //至少得有一张5美元
                if (cnt5 == 0) return false;
                //如果有10美元，一定要先用上，贪心

                if (cnt10 > 0) {
                    cnt10--;
                    cnt5--;
                } else {
                    if (cnt5 < 3) return false;
                    cnt5 -= 3;
                }
            }
        }
        return true;
    }
}
