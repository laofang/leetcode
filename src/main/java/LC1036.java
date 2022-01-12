import java.util.*;

/**
 * Leetcode1036题，逃离大迷宫
 * 关键字：回溯、数组、广度优先搜索、哈希表
 * 主要思路：
 * 1. 检测开始位置和目标位置，是否被完全封锁
 * 2. 通过封锁块的个数n。可以算出n个封锁块，最大可以围成n*(n-1) / 2块
 * 3. 如果源和目标块广度优先搜索，搜索的块数超过了封锁块可以围成的面积，那就说明封锁不住
 * 4. 反之，则可以封锁
 */
public class LC1036 {
    int[] directions = new int[]{-1,0,1,0,-1};
    public boolean isEscapePossible(int[][] blocked, int[] s, int[] t) {
        //封锁块数量
        int n = blocked.length;
        //最大可围的空间
        int max = n * (n-1) / 2;
        //记录坐标是否已经被访问过
        Map<Pair,Boolean> map = new HashMap<>();
        //广度优先搜索使用的队列
        Queue<Pair> q = new LinkedList<>();
        //封锁块map
        Map<Pair,Boolean> blockMap = new HashMap<>();
        //
        for (int[] ints : blocked) {
            blockMap.put(new Pair(ints[0],ints[1]),true);
        }


        int count = 1;
        //广度搜索源块四周
        map.put(new Pair(s),true);
        q.offer(new Pair(s));
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            //当前块的四个方向
            for(int i = 0; i < directions.length - 1;i++) {
                Pair temp = new Pair(cur.x + directions[i],cur.y + directions[i+1]);
                //如果是障碍、或者已访问、或者超出边界，都不进行访问
                if(blockMap.get(temp) != null || map.get(temp) != null || temp.x >= 1e6 || temp.y >= 1e6 || temp.x < 0 || temp.y < 0) continue;
                //走到了目标位置返回true;
                if(temp.equals(new Pair(t))) return true;
                //记录已访问过
                map.put(temp,true);
                //加入队列
                q.offer(temp);
                count++;
            }
            //说明没有封锁住源位置
            if(count >max) {
                break;
            }
        }
        //封锁住源位置
        if(count <= max) return false;

        count = 1;
        q.clear();
        //从目标位置开始回溯
        q.offer(new Pair(t));
        map.clear();
        map.put(new Pair(t),true);
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for(int i = 0; i < directions.length - 1;i++) {
                Pair temp = new Pair(cur.x + directions[i],cur.y + directions[i+1]);
                //如果是障碍、或者已访问、或者超出边界，都不进行访问
                if(blockMap.get(temp) != null || map.get(temp) != null || temp.x > 1e6 || temp.y > 1e6 || temp.x < 0 || temp.y < 0) continue;
                if(temp.equals(new Pair(s))) return true;
                map.put(temp,true);
                q.offer(temp);
                count++;
            }
            if(count > max) {
                return true;
            }
        }
        return false;
    }

    class Pair {
        public final int x;
        public final int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(int[] num) {
            this.x = num[0];
            this.y = num[1];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
