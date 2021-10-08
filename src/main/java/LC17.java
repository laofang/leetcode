import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode第十七题，电话号码的字母组合
 *
 */
public class LC17 {
    /**
     * 回溯法
     */
    public List<String> letterCombinations(String digits) {

        LinkedList<String> res = new LinkedList<>();
        if(digits.equals("")) {
            return res;
        }
        backtrack(new StringBuilder(),digits,0,res);
        return res;
    }

    /**
     * 使用队列的方式解决的
     * 一些递归的问题，可以通过队列来解决，例如广度优先搜索等
     */
    public List<String> letterCombinations1(String digits) {

//        LinkedList<String> res = new LinkedList<>();
//        if(digits.equals("")) {
//            return res;
//        }
//        backtrack(new StringBuilder(),digits,0,res);
//        return res;


        LinkedList<String> res = new LinkedList<>();
        if(digits.equals("")) {
            return res;
        }
        char[] digitsChs = digits.toCharArray();
        //先给队列入满第一个数字对应的字符串
        for (char aChar : getChars(digitsChs[0])) {
            res.add(aChar+"");
        }
        //从第二个数字开始组合
        for (int i = 1; i < digitsChs.length; i++) {
            char[] chs = getChars(digitsChs[i]);
            //出队的次数
            int resLen = res.size();
            for (int j = 0; j < resLen; j++) {
                String p = res.pop();
                //每次出队的，和所有的新字符组合，再入队
                for (char ch : chs) {
                    res.add(p + ch);
                }
            }
        }
        return res;

    }

    /**
     * 回溯法
     */
    public void backtrack(StringBuilder sb,String digits,int index,List<String> res) {
        //数字的索引到结尾为止
        if(index == digits.length()) {
            res.add(sb.toString());
        }
        else {
            char ch = digits.charAt(index);
            char[] chars = getChars(ch);
            //遍历每一个字符
            for (int i = 0; i < chars.length; i++) {
                //加入字符，注意此时加入的位置，即使index的位置
                sb.append(chars[i]);
                backtrack(sb,digits,index+1,res);
                //删除字符，准备换下一个字符
                sb.deleteCharAt(index);
            }
        }
    }
    private char[] getChars(char ch){
        switch (ch) {
            case '2':
                return new char[]{'a','b','c'};
            case '3':
                return new char[]{'d','e','f'};
            case '4':
                return new char[]{'g','h','i'};
            case '5':
                return new char[]{'j','k','l'};
            case '6':
                return new char[]{'m','n','o'};
            case '7':
                return new char[]{'p','q','r','s'};
            case '8':
                return new char[]{'t','u','v'};
            case '9':
                return new char[]{'w','x','y','z'};
            default:
                return new char[]{};
        }
    }
}
