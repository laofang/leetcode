import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode1592题，重新排列单词间的空格
 * 关键字：字符串
 * 主要思路：
 * 1. 计算出空格的数量spcCnt，单词的数量wdCnt
 * 2. 同时记录下单词，最后再根据空格数量和单词数量进行拼接
 */
public class LC1592 {
    public String reorderSpaces(String text) {
        int n = text.length();
        int spcCnt = 0;
        int wdCnt = 0;
        char ch;
        int i = 0;
        List<String> list = new ArrayList<>();
        while(i < n) {
            ch = text.charAt(i);
            if(ch == ' ') {
                i++;
                spcCnt++;
            } else {
                wdCnt++;
                StringBuilder sb = new StringBuilder();
                while(ch != ' ') {
                    sb.append(ch);
                    if(++i >= n) break;
                    ch = text.charAt(i);
                }
                list.add(sb.toString());
            }
        }
        if(spcCnt == 0) return text;
        int eachCnt = wdCnt == 1 ? spcCnt : spcCnt / (wdCnt - 1);
        int lastCnt = wdCnt == 1 ? spcCnt : spcCnt % (wdCnt - 1);
        StringBuilder ans = new StringBuilder();
        for(i = 0; i < list.size(); i++) {
            String t = list.get(i);
            ans.append(t);
            if(i == list.size() - 1) break;
            for(int j = 0;j < eachCnt;j++) {
                ans.append(" ");
            }
        }
        for(i = 0; i < lastCnt; i++) {
            ans.append(" ");
        }
        return ans.toString();
    }
}
