import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode68题，文本左右对齐
 * 关键字：字符串、模拟
 * 主要思路：
 * 1. 主要就是按要求进行模拟
 * 2. 把整道题分为几个部分
 *      1. 求出每一行可以放几个字符串
 *      2. 每一行的空格有多少，分到每个字符串的间隔有多少
 *      3. 如果空格不能平均分配，余数为m时，前m个间隔的空格要+1
 * 需要注意：
 * 1. 不能平均分空格的情况
 * 2. 行内只有一个字符串的情况
 * 3. 最后一行是左对齐，要特殊处理
 */
public class LC68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int curIndex = 0;
        //最终答案
        List<String> ans = new LinkedList<>();
        //每行的单词数量
        List<String> rows = new LinkedList<>();
        while(curIndex < words.length) {
            //尝试加入时的总长度
            int length = words[curIndex].length();
            //当前行的单词数量
            int wordCount = 0;
            //当前行的单词长度
            int wordLength = 0;
            rows.clear();

            //如果此时已经超过限定长度，则将之前的拼接成一行
            while(length <= maxWidth) {
                rows.add(words[curIndex]);
                //总单词数量+1
                wordCount++;
                //单词长度增加
                wordLength += words[curIndex].length();
                //当前索引后移
                curIndex++;
                //移到最后跳出
                if(curIndex == words.length) {
                    break;
                }
                //尝试加一个空格
                length += 1;
                //再加下一个单词
                length += words[curIndex].length();
            }

            //单词间的空格数量
            int spaceCount = 0;
            //空格总数量
            int spaceTotal = maxWidth - wordLength;
            //余数
            int rem = 0;
            //如果大于一个单词的情况、只有一个单词，只要拼接的时候，空格补齐即可
            if(rows.size() > 1) {
                //空格总数 / 单词间隔数
                spaceCount = spaceTotal / (wordCount - 1);
                //同时求余数
                rem = spaceTotal % (wordCount - 1);
                //只有一个单词
            }

            //拼接每行字符串
            StringBuilder sb = new StringBuilder();
            //暂存下每个单词间隔空格数的原始值
            int spaceCountTemp = spaceCount;
            for(int i = 0; i < rows.size(); i++) {
                spaceCount = spaceCountTemp;
                //如果有余数，要把余数均匀的分到前rem个
                sb.append(rows.get(i));
                if(rem > 0) {
                    spaceCount++;
                    rem--;
                }
                //最后一行的为左对齐，单词间间隔一个空格
                if(curIndex == words.length && spaceTotal > 0) {
                    sb.append(" ");
                    spaceTotal -= 1;
                    //不是最后一行，那就补充spaceCount个空格
                } else {
                    //剩余空格总数比需要的多
                    if(spaceTotal >= spaceCount) {
                        for(int j = 0; j < spaceCount;j++) {
                            sb.append(" ");
                        }
                        //每次填充空格后，空格总数要适当减少
                        spaceTotal -= spaceCount;
                        //剩余空格总数没有需要的多
                    } else {
                        for(int j = 0; j < spaceTotal;j++) {
                            sb.append(" ");
                        }
                        spaceTotal = 0;
                    }
                }

            }
            //最终剩余多少个空格，就补充在最后面
            for(int i = 0; i < spaceTotal;i++) {
                sb.append(" ");
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
