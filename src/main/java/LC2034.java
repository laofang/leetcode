import java.util.HashMap;
import java.util.TreeMap;

/**
 * Leetcode2034题，股票价格波动
 * 关键字：股票，TreeSMap,HashMap，优先队列
 * 整体思路：
 * 1. HashMap存储时间戳和价格
 * 2. TreeMap存储价格和价格出现的次数，由于TreeMap存储的数据是有序的，可以获取最大和最小值
 */
public class LC2034 {
    class StockPrice {
        //时间戳-股票价
        private HashMap<Integer,Integer> hm;
        //股价-数量
        private TreeMap<Integer,Integer> tm;
        //当前时间戳
        private int currentTime;

        public StockPrice() {
            hm = new HashMap<Integer,Integer>();
            tm = new TreeMap<Integer,Integer>();
        }
        //更新价格
        public void update(int timestamp, int price) {
            if(timestamp >= currentTime) {
                currentTime = timestamp;
            }
            //如果时间戳相等，就修改股价
            if(hm.containsKey(timestamp)) {
                //获取旧价格和旧价格出现的次数
                Integer oldPrice = hm.get(timestamp);
                Integer oldPirceCount = tm.get(oldPrice);
                //如果旧价格出现一次，则删除
                if(oldPirceCount == 1) {
                    tm.remove(oldPrice);
                    //如果旧价格出现多次，减少一次
                } else {
                    tm.put(oldPrice,--oldPirceCount);
                }
            }
            //向TreeMap中加入新价格，如果存在+1，不存在则为1
            Integer pirceCount = tm.get(price);
            pirceCount = pirceCount == null ? 0 : pirceCount;
            tm.put(price,++pirceCount);
            //更新HashMap内容
            hm.put(timestamp,price);
        }
        //获取当前股价
        public int current() {
            return hm.get(currentTime);
        }
        //获取最大股价，即TreeMap的末尾
        public int maximum() {
            return tm.lastKey();
        }
        //获取最小股价，即TreeMap的起始
        public int minimum() {
            return tm.firstKey();
        }
    }

}
