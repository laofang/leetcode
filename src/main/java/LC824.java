/**
 * Leetcode824题，山羊拉丁文
 * 关键字：字符串
 * 主要思路：
 * 1. 按空格分割字符串
 * 2. 对每个字符串进行处理
 */
public class LC824 {
    public String toGoatLatin(String sentence) {
        String[] strs = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if(isYuan(strs[i])) {
                sb.append(strs[i]).append("ma");
            } else{
                sb.append(strs[i].substring(1)).append(strs[i].charAt(0)).append("ma");
            }
            for(int j = 0; j < i + 1; j++) {
                sb.append('a');
            }
            sb.append(" ");
        }
        return sb.toString().substring(0,sb.length()-1);
    }
    private boolean isYuan(String s) {
        if (s == null || s.isBlank()) return false;
        char ch = s.charAt(0);
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }
}
