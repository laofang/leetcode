import java.util.*;

/**
 * Leetcode423题，从英文中重建数字
 * 关键字：脑筋急转弯、词频
 * 主要思路：
 * 1. 找到规律，字母与各个数字之间的关系
 * 2. 然后根据字母的频率获取不同数字出现的情况
 */
public class LC423 {
    public String originalDigits(String s) {
        int[] chRate = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chRate[s.charAt(i) - 'a']++;
        }
        int[] numRate = new int[10];
        numRate[0] = chRate['z' - 'a'];
        numRate[2] = chRate['w' - 'a'];
        numRate[4] = chRate['u' - 'a'];
        numRate[6] = chRate['x' - 'a'];
        numRate[8] = chRate['g' - 'a'];
        numRate[1] = chRate['o' - 'a'] - numRate[0] - numRate[2] - numRate[4];
        numRate[3] = chRate['r' - 'a'] - numRate[0] - numRate[4];
        numRate[5] = chRate['f' - 'a'] - numRate[4];
        numRate[7] = chRate['v' - 'a'] - numRate[5];
        numRate[9] = chRate['i' - 'a'] - numRate[5] - numRate[6] - numRate[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRate.length; i++) {
            for (int j = 0; j < numRate[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
//        pre();
//        return "";
    }

    /**
     * 得到字母与数据的关系
     */
    public void pre() {
        String nums[] = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
        Map<Character, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            char[] chs = nums[i].toCharArray();
            for (int j = 0; j < chs.length; j++) {
                Set<Integer> set = map.getOrDefault(chs[j],new TreeSet<Integer>());
                set.add(i);
                map.put(chs[j],set);
            }
        }
        List<Character> keyList = new LinkedList<>();
        keyList.addAll(map.keySet());
        Collections.sort(keyList,(e1,e2) -> {
            return map.get(e1).size() - map.get(e2).size();
        });
        for(Character ch : keyList) {
            System.out.println(ch + " " + map.get(ch));
        }
    }
}
