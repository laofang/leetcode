import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Leetcode1797题，设计一个验证系统
 * 关键字：设计、哈希表
 * 主要思路：
 * 1. 哈希表和优先队列，哈希表存储tokenId和终止时间
 * 2. 优先队列按终止时间升序排列
 * 3. 按规则模拟即可
 */
public class LC1797 {
    int liveTime = 0;
    Map<String,Integer> map = new HashMap<>();
    PriorityQueue<Integer> q;
    public LC1797(int timeToLive) {
        this.liveTime =  timeToLive;
        this.q = new PriorityQueue<>( (e1,e2) ->e1-e2);
    }

    public void generate(String tokenId, int currentTime) {
        Integer v = map.get(tokenId);
        if(v != null) {
            q.remove(v);
        }
        map.put(tokenId,currentTime + liveTime);
        q.add(currentTime + liveTime);
    }

    public void renew(String tokenId, int currentTime) {
        Integer v = map.get(tokenId);
        if(v != null && v > currentTime) {
            map.put(tokenId,currentTime + liveTime);
            q.remove(v);
            q.add(currentTime + liveTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int cnt = 0;
        while(!q.isEmpty()) {
            if(q.peek() <= currentTime) {
                q.poll();
            } else {
                break;
            }
        }
        return q.size();
    }
}
