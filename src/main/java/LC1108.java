/**
 * Leetcode1108题，IP 地址无效化
 * 关键字：字符串
 * 主要思路：
 * 1. 遍历并替换
 */
public class LC1108 {
    public String defangIPaddr(String address) {
        StringBuilder ans = new StringBuilder();
        for(char ch : address.toCharArray()) {
            ans.append(ch == '.' ? "[.]" : ch);
        }
        return ans.toString();
    }
}
