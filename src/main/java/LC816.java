import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode816题，模糊坐标
 * 关键字：字符串、回溯
 * 主要思路：
 * 1. 暴力遍历
 * 2. 数字字符串拆分成小数时，如果小数点前面有 >1 个数字，第一个数字不能为0，如果小数点后面有数字，那最后一个数字不能为0
 * 3. 在上面条件之外，对小数点位置进行遍历，构成坐标
 */
public class LC816 {
    public List<String> ambiguousCoordinates(String s) {
        List<String> ans = new LinkedList<>();
        s = s.substring(1, s.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            String x = s.substring(0, i + 1);

            List<String> xList = new LinkedList<>();
            for (int j = 0; j < x.length(); j++) {
                if (j > 0 && x.charAt(0) == '0') continue;
                if (j < x.length() - 1 && x.charAt(x.length() - 1) == '0') continue;
                StringBuilder sb = new StringBuilder();
                if (j < x.length() - 1) {
                    xList.add(sb.append(x.substring(0, j + 1)).append(".").append(x.substring(j + 1)).toString());
                } else {
                    xList.add(x);
                }
            }

            String y = s.substring(i + 1);
            for (int j = 0; j < y.length(); j++) {
                if (j > 0 && y.charAt(0) == '0') continue;
                if (j < y.length() - 1 && y.charAt(y.length() - 1) == '0') continue;
                for (String xPos : xList) {
                    StringBuilder sb = new StringBuilder();
                    if (j < y.length() - 1) {
                        ans.add(sb.append("(").append(xPos).append(", ").append(y.substring(0, j + 1)).append(".").append(y.substring(j + 1)).append(")").toString());
                    } else {
                        ans.add(sb.append("(").append(xPos).append(", ").append(y).append(")").toString());
                    }
                }

            }
        }
        return ans;
    }
}
