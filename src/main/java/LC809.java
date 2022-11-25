import java.util.ArrayList;

/**
 * Leetcode809题，情感丰富的数字
 * 关键字：数组、双指针、字符串
 * 主要思路：
 * 1. 先记录原字符串，按顺序，每个字符的相对位置，和连续出现的数量
 * 2. 每个匹配的字符串，如果满足条件，相对位置一定是相同的，同时每个对应的字符的数量有一定的要求
 */
public class LC809 {
    public int expressiveWords(String s, String[] words) {
        ArrayList<int[]> list = new ArrayList<>();
        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length; i++) {
            if(list.size() == 0 || list.get(list.size() - 1)[0] != chs[i]) {
                list.add(new int[]{chs[i],1});
            } else {
                list.get(list.size() - 1)[1]++;
            }
        }

        int ans = 0;
        for(int i = 0; i < words.length; i++) {
            int curIndex = 0;
            int j = 0;
            int cnt = 1;
            char[] word = words[i].toCharArray();
            while(j < word.length) {
                if(j > 0 && word[j] == word[j-1]) {
                    cnt++;
                } else if(j != 0){
                    if(curIndex >= list.size()) break;
                    int[] value = list.get(curIndex);
                    if(value[0] != word[j-1]) break;
                    if(cnt > value[1] || (cnt != value[1] && value[1] < 3)) break;

                    cnt = 1;
                    curIndex++;
                }
                j++;
            }
            if(j != word.length || curIndex != list.size()- 1) continue;
            int[] lastV = list.get(curIndex);
            if(lastV[0] != word[word.length - 1]) continue;
            if(cnt > lastV[1] || (cnt != lastV[1] && lastV[1] < 3)) continue;
            ans++;

        }
        return ans;
    }
}
