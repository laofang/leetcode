import java.util.HashMap;

/**
 * Leetcode第十二题，整数转罗马数字
 * 这道题要点：
 * 1. 罗马数字是和的形式，没有进位
 * 2. 注意特殊的符号
 * 3. 当前的这个算法效率不够高，还需要看下解析
 */
public class LC12 {
    public String intToRoman(int num) {
        HashMap<Integer,String> hm = new HashMap<>();

        hm.put(1,"I");
        hm.put(4,"IV");
        hm.put(5,"V");
        hm.put(9,"IX");
        hm.put(10,"X");
        hm.put(40,"XL");
        hm.put(50,"L");
        hm.put(90,"XC");
        hm.put(100,"C");
        hm.put(400,"CD");
        hm.put(500,"D");
        hm.put(900,"CM");
        hm.put(1000,"M");

        int[] keys = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < keys.length; i++) {

            int count = num / keys[i];
            if(count > 0) {
                num -= count * keys[i];
            }
            for (int j = 0; j < count; j++) {
                sb.append(hm.get(keys[i]));
            }
        }
        return sb.toString();
    }
}
