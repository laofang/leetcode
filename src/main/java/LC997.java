/**
 * Leetcode997题，找到小镇的法官
 * 关键字：数组、图、出度、入度
 * 主要思路：
 * 1. 每个人是一个节点，信任关系就是一个有向的边
 * 2. 法官被其他所有人信任，所以法官的入度是n-1,法官不信任任何人，法官的出度是0
 */
public class LC997 {
    public int findJudge(int n, int[][] trust) {
        if(n == 1) {
            return 1;
        }
        int[][] log = new int[n+1][2];
        //统计每个人的出度和入度
        for(int i = 0; i < trust.length;i++) {
            //出度
            log[trust[i][0]][0]++;
            //入度
            log[trust[i][1]][1]++;
        }
        //满足法官出度入度关系的人
        for(int i = 0; i < log.length;i++) {
            if(log[i][0] == 0 && log[i][1] == n-1) {
                return i;
            }
        }
        return -1;
    }
}
