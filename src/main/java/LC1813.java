import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode1813题，句子相似性 III
 * 关键字：数组、双指针、字符串
 * 主要思路：
 * 1. 如果字符串一样长，只有相等才会相似
 * 2. 如果字符串长度不一样，一定是长度较小的那个被插入
 * 3. 尝试将较小的字符串按每个空格分为前后两个部分，如果前部分是较长字符串的前缀（同时满足这个前缀是较长字符串的空格分割），且后部分类似的满足后缀就是相似的
 */
public class LC1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.equals(sentence2)) return true;
        Set<Integer> preLen = new HashSet<>();
        Set<Integer> lastLen = new HashSet<>();
        String a;
        String b;
        if(sentence1.length() > sentence2.length()) {
            a = sentence1;
            b = sentence2;
        } else {
            a = sentence2;
            b = sentence1;
        }
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == ' ') {
                preLen.add(i);
                lastLen.add(a.length() - i - 1);
            }
        }

//        if(b.indexOf(' ') < 0) {
//            String[] strs = a.split("\\s+");
//            if(b.equals(strs[0]) || b.equals(strs[strs.length-1])) return true;
//            else return false;
//        }

        if(a.startsWith(b) && preLen.contains(b.length())
                || a.endsWith(b) && lastLen.contains(b.length())) return true;
        for(int i = 0; i < b.length(); i++) {
            if(b.charAt(i) == ' ') {
                String pre = b.substring(0,i);
                String last = b.substring(i+1);
                if(a.startsWith(b.substring(0,i))
                        && a.endsWith(b.substring(i+1))
                        && preLen.contains(pre.length())
                        && lastLen.contains(last.length())) {
                    return true;
                }
            }
        }
        return false;
    }
}
