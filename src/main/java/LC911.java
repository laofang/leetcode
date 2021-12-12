import java.util.HashMap;

/**
 * Leetcode911题，在线选举
 * 关键字：二分查找
 * 主要思路：
 * 1. 每一次投票时刻，都计算当前得票人得票数是否超记录得最大的，如果超过更新记录
 * 2. 将时间和对应最大的值
 */
public class LC911 {
    private int maxPerson = -1;
    private int maxTicket = -1;
    //key：时间  value:对应时间票数最多的人
//    private TreeMap<Integer,Integer> tToMaxPMap;
    //key：人  value：对应票数
    private HashMap<Integer,Integer> pToTicket;
    //    private int[] pToTicket;
    private int[] times;
    private int[] tToMaxPMap;
    public LC911(int[] persons, int[] times) {
        tToMaxPMap = new int[times.length];
//        pToTicket = new HashMap<>();
        pToTicket = new HashMap<>();
        this.times = times;
        for (int i = 0; i < times.length; i++) {
            int count = pToTicket.getOrDefault(persons[i],0);
            pToTicket.put(persons[i],++count);
            if(count >= maxTicket) {
                maxTicket = count;
                maxPerson = persons[i];
            }
//            tToMaxPMap.put(times[i],maxPerson);
            tToMaxPMap[i] = maxPerson;
        }
    }

    public int q(int t) {
//        return tToMaxPMap.floorEntry(t).getValue();
        int left = 0;
        int right = times.length - 1;
        while (left <= right) {
            int half = (left + right) / 2;
            if(times[half] == t) {
                return tToMaxPMap[half];
            } else if(times[half]  <= t) {
                left = half + 1;
            } else {
                right = half - 1;
            }
        }
        return tToMaxPMap[right];
    }
}
