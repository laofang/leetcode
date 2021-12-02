import java.util.TreeMap;

/**
 * Leetode506题，相对名次
 * 关键字：哈希、数组
 * 主要思路：
 * 1. 需要一个分数到索引的映射
 * 2. 再对score进行排序即可
 */
public class LC506 {
    public String[] findRelativeRanks(int[] score) {
        String[] ans = new String[score.length];
        TreeMap<Integer,Integer> map = new TreeMap<>((e1, e2)->e2-e1);
        //分数到index的哈希
        for (int i = 0; i < score.length; i++) {
            map.put(score[i],i);
        }
        int count = 0;
        for(Integer key : map.keySet()) {
            count++;
            switch (count) {
                case 1:
                    ans[map.get(key)] = "Gold Medal";
                    break;
                case 2:
                    ans[map.get(key)] = "Silver Medal";
                    break;
                case 3:
                    ans[map.get(key)] = "Bronze Medal";
                    break;
                default:
                    ans[map.get(key)] = String.valueOf(count);
            }
        }
        return ans;
    }
}
