import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode1138题，字母板上的路径
 * 关键字：哈希表、字符串
 * 主要思路：
 * 1. 记录当前位置，计算下一位置相对当前位置的变化量
 * 2. 根据变化量，来添加相应的字母，要注意字母'z'，如果要移到字母'z'，先左右移动，再上下移动
 */
public class LC1138 {
    public String alphabetBoardPath(String target) {
        Map<Integer,int[]> map = new HashMap<>();
        for(int i = 'a'; i <= 'z';i++) {
            int[] pos = new int[2];
            pos[0] = (i - 'a') / 5;
            pos[1] = (i - 'a') % 5;
            map.put(i,pos);
        }
        int[] cur = new int[]{0,0};
        char[] chs = target.toCharArray();
        StringBuilder ans = new StringBuilder();
        for(char ch : chs) {
            int[] pos = map.get((int)ch);
            int x = pos[0] - cur[0];
            int y = pos[1] - cur[1];
            if(ch != 'z') {
                if(x > 0) {
                    for(int i = 0; i < x; i++) {
                        ans.append('D');
                    }
                } else if(x < 0) {
                    for(int i = 0; i < -x; i++) {
                        ans.append('U');
                    }
                }
            }
            if(y > 0) {
                for(int i = 0; i < y; i++) {
                    ans.append('R');
                }
            } else if(y < 0) {
                for(int i = 0; i < -y; i++) {
                    ans.append('L');
                }
            }
            if(ch == 'z') {
                if(x > 0) {
                    for(int i = 0; i < x; i++) {
                        ans.append('D');
                    }
                } else if(x < 0) {
                    for(int i = 0; i < -x; i++) {
                        ans.append('U');
                    }
                }
            }
            ans.append('!');
            cur = pos;
        }
        return ans.toString();
    }
}
