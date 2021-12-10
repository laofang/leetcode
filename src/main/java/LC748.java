/**
 * Leetocde748题，最短补全词
 * 关键字：哈希、字符串、词频、数组
 * 主要思路：
 * 1. 首先就考虑数组，字符频率
 * 2. 对需要补全的词，进行字符频率统计
 * 3. 再对要匹配的词进行统计，然后将此统计结果，对上面的结果进行覆盖，如果能完全覆盖（每个字符频次做差，结果<=0，说明覆盖），说明可以是补全此词
 * 4. 可以覆盖的如果小于之前的记录，更新记录
 * 优化：
 * 1. 如果当前待匹配字符串长度不小于已记录的字符串的长度，就不用再进行匹配
 * 2. 如果当前匹配的字符串的长度，和原字符串的实际长度相同，那直接退出匹配
 */
public class LC748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] times = new int[26];
        int minLength = Integer.MAX_VALUE;
        int realLength = 0;
        String ans = "";
        //统计字符频次
        for (int i = 0; i < licensePlate.length(); i++) {
            int n = Character.toLowerCase(licensePlate.charAt(i)) - 'a';
            if(n >= 0 && n <26) {
                times[n]++;
                realLength++;
            }
        }
        //对每个待匹配的补全词进行尝试
        for(String str : words) {
            //字符串长度比记录的结果长，不需要再尝试
            if(str.length() >= minLength) continue;
            int[] target = new int[26];
            //待匹配不全词的词频统计
            for (int i = 0; i < str.length(); i++) {
                target[str.charAt(i) - 'a']++;
            }
            int j = 0;
            //覆盖测试
            for(j = 0; j < 26;j++) {
                if(times[j] - target[j] > 0) {
                    break;
                }
            }
            //完成覆盖
            if(j == 26 && str.length() < minLength) {
                ans = str;
                minLength = str.length();
            }
            //如果匹配的字符串长度和原字符串的真实长度相等，不用再匹配
            if(ans.length() == realLength) break;
        }
        return ans;
    }
}
