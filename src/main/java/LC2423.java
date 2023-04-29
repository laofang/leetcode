/**
 * Leetcode2423题，删除字符使用频率相同
 * 关键字：哈希表、字符串、计数
 * 主要思路：
 * 1. 先统计字符频率
 * 2. 再对出现的频率进行统计
 */
public class LC2423 {
    public boolean equalFrequency(String word) {
        int[] map = new int[26];
        char[] chs = word.toCharArray();
        for(int i = 0; i < chs.length; i++) {
            map[chs[i] - 'a']++;
        }
        int[] tab = new int[100];
        //满足条件的map的三种种种情况：
        //1. 除0外，一个1，其余为x(也可以x==1)
        //2. 除0外，一个x+1，其余为x
        //3. 除0外，只有一个元素
        int firstCnt = 0;
        int secontCnt = 0;
        int first = 0;
        int sencond = 0;
        int typeCnt = 0;
        for(int i = 0; i < map.length; i++) {
            if(map[i] == 0) continue;
            typeCnt++;
            if(first == 0) first = map[i];
            else if(first != map[i] && sencond == 0) sencond = map[i];
            if(map[i] != first && map[i] != sencond) return false;
            if(map[i] == first) firstCnt++;
            if(map[i] == sencond) secontCnt++;
        }
        return first == 1 && (firstCnt == 1 || firstCnt == chs.length) ||
                sencond == 1 && (secontCnt == 1 || secontCnt == chs.length) ||
                firstCnt == 1 && first - 1 == sencond || secontCnt == 1 && sencond - 1 == first ||
                typeCnt == 1;
    }
}
