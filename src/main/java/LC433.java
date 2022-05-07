import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Leetcode433题，最小基因变化
 * 关键字：广度优先搜索、哈希表、字符串
 * 主要思路：
 * 1. 广度优先搜索，将start加入队列
 * 2. 队列出队，尝试修改每个部分，如果在bank中，则加入队列
 * 3. 重复2，直到找到end，或最后未找到end
 */
public class LC433 {
    final char[] base = new char[]{'A','C','G','T'};
    public int minMutation(String start, String end, String[] bank) {
        Map<String, String> map = new HashMap<>();
        for (String s : bank) {
            map.put(s,s);
        }
        Queue<String> queue = new LinkedList<>();
        Map<String,Integer> logMap = new HashMap<>();
        queue.offer(start);

        while(!queue.isEmpty()) {
            String s = queue.poll();
            int cnt = logMap.getOrDefault(s,0);
            if(s.equals(end)) return cnt;
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char ch = chs[i];
                for(int j = 0; j < base.length; j++) {
                    if(ch != base[j]) {
                        chs[i] = base[j];
                        String temp = new String(chs);
                        if(map.get(temp) != null) {
                            map.remove(temp);
                            logMap.put(temp,cnt + 1);
                            queue.offer(temp);
                        }
                    }
                }
                chs[i] = ch;
            }
        }
        return -1;
    }
}
