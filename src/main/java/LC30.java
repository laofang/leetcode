import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode30题，串联所有单词的子串
 * 关键字：字符串，Map
 * 主要思路：
 * 1. 一共使用两个Map，一个记录待匹配单词的个数，另一个用来存匹配中间结果
 * 2. 第一个Map记录每个单词，以及单词出现的次数
 * 3. 遍历字符串，每个子串，如果Map中有，就存再第二个Map中，并记数，如果不存在，或计数大于本有的，则跳到下个位置继续
 */
public class LC30 {
    public List<Integer> findSubstring(String s, String[] words) {
        if(words.length == 0) {
            return Collections.emptyList();
        }
        int wLen = words[0].length();
        HashMap<String,Integer> wordMap = new HashMap<>();

        LinkedList<Integer> resL = new LinkedList();
        //都存入第一个map，并计数
        for (String word : words) {
            int value = wordMap.getOrDefault(word,0);
            wordMap.put(word,value + 1);
        }
        //遍历到字符串剩余的长度大于word中单词的总长度结束
        for(int i = 0; i < s.length() - words.length * wLen + 1 ; i++) {
            HashMap<String,Integer> testWordMap = new HashMap<>();
            //命中次数
            int num = 0;
            while(num < words.length) {
                //字符串截取，每命中一个，都要往后面跳一个
                String str = s.substring(i + num * wLen,i+ (num+1) * wLen);
                //匹配到
                if(wordMap.containsKey(str)) {
                    //计数map对应加1
                    int testNum = testWordMap.getOrDefault(str,0);
                    testWordMap.put(str,testNum + 1);
//                    System.out.println(i + " "  + testNum + " " + str);
                    //如果测试的数量大于words中单词原本的数量，则跳出
                    if(testNum + 1 > wordMap.get(str)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            //命中数和words中的单词数相等，说明完成一次匹配
            if(num == words.length) {
                resL.add(i);
            }
        }
        return resL;
    }
}
