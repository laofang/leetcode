import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode929题，独特的电子邮件地址
 * 关键字：数组、哈希表、字符串
 * 主要思路：
 * 1. 主要对@前的本地名进行解析
 * 2. substring截取+号之前的部分，replace用""代替"."，
 * 3. 最终本地名 + @ + 域名，看是否存在，不存在就加入集合，同时加一
 */
public class LC929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        int ans = 0;
        for (String s : emails) {
            String[] strs = s.split("@");
            int plusIndex = strs[0].indexOf("+");
            String localName = strs[0];
            if(plusIndex > 0) {
                localName = strs[0].substring(
                        0,plusIndex);
            }
            localName = localName.replace(".","");
            String finalEmail = new StringBuilder().append(localName)
                    .append("@").append(strs[1]).toString();
            if(!emailSet.contains(finalEmail)) {
                emailSet.add(finalEmail);
                ans++;
            }
        }
        return ans;
    }
}
