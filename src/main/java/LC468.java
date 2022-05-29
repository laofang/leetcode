/**
 * Leetcode468题，验证IP地址
 * 关键字：字符串
 * 主要思路：
 * 1. 按照规则模拟即可
 */
public class LC468 {
    public String validIPAddress(String queryIP) {
        if(queryIP.length() == 0) return "Neither";
        int index = queryIP.indexOf(':');
        if(index < 0) {
            return isIPv4(queryIP);
        } else {
            return isIPv6(queryIP);
        }
    }

    public String isIPv4(String queryIP) {
        if(queryIP.charAt(0) == '.' || queryIP.charAt(queryIP.length()-1) == '.') return "Neither";
        String[] strs = queryIP.split("\\.");
        if(strs.length != 4) {
            return "Neither";
        }
        for(String str : strs) {
            if(!isIPv4Part(str)) return "Neither";
        }
        return "IPv4";
    }

    public String isIPv6(String queryIP) {
        if(queryIP.charAt(0) == ':' || queryIP.charAt(queryIP.length()-1) == ':') return "Neither";
        String[] strs = queryIP.split("\\:");
        if(strs.length != 8) {
            return "Neither";
        }
        for(String str : strs) {
            if(!isIPv6Part(str)) return "Neither";
        }
        return "IPv6";
    }

    public boolean isIPv4Part(String part) {
        if(part.length() > 3 || part.length() == 0) return false;
        if(part.length() > 1 && part.startsWith("0")) return false;
        int num = 0;
        for(int i = 0; i < part.length();i++) {
            if(!Character.isDigit(part.charAt(i))) return false;
            num = num * 10 + part.charAt(i) - '0';
        }
        if(num >=0 && num <=255) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isIPv6Part(String part) {
        if(part.length() > 4 || part.length() == 0) return false;
        for (int i = 0; i < part.length(); i++) {
            char ch = part.charAt(i);
            if( (ch >='0' && ch <= '9') || (ch >= 'a' && ch <='f') || (ch >= 'A' && ch <= 'F')) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
