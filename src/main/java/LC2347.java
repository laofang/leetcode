/**
 * Leetcode2347题，最好的扑克手牌
 * 关键字；数组、哈希表、计数
 * 主要思路：
 * 1. 主要就是哈希计数，按好牌的优先级顺序，进行判断
 */
public class LC2347 {
    public String bestHand(int[] ranks, char[] suits) {
        int index = 1;
        int[] cnt = new int[14];
        String[] types = new String[]{"Flush","High Card","Pair","Three of a Kind"};
        if(isFlush(suits)) {
            return types[0];
        };
        for(int i = 0; i < ranks.length;i++) {
            cnt[ranks[i]]++;
            if(index != 3  && cnt[ranks[i]] == 2) index = 2;
            if(cnt[ranks[i]] == 3) index = 3;
        }
        return types[index];
    }
    public boolean isFlush(char[] suits) {
        for(int i = 1; i < suits.length; i++) {
            if(suits[0] != suits[i]) return false;
        }
        return true;
    }
}
