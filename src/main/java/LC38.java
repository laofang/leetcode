/**
 * Leetcode38题，外观数列
 * 关键字：递归
 * 主要思路：
 * 1. 递归的方法，第n个数是对第n-1个数的描述，即f(n) = f(n-1) + 对f(n-1)的描述
 */
public class LC38 {
    public String countAndSay(int n) {
        //递归结束条件，当n=1,结果就是1
        if(n == 1) {
            return String.valueOf(n);
        }
        //获取n-1的字符串
        String preStr =  countAndSay(n-1);
        //对n-1的字符串串进行描述
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < preStr.length(); i++) {
            //相等计数相加
            if(preStr.charAt(i) == preStr.charAt(i-1)) {
                count++;
            } else {
                //一旦当前与前面的不等，可以对前一个字符（可能是字符串）进行描述
                sb.append(count).append(preStr.charAt(i-1));
                count = 1;
            }
        }
        //最后不会走到else，所以要对最后的字符（也可能是字符串）进行描述
        sb.append(count).append(preStr.charAt(preStr.length()-1));
        //用while循环，一样的逻辑
//        int k = 0;
//        int c = 0;
//        int i = 0;
//        while(k < preStr.length() && i<preStr.length()) {
//            i = k;
//            while(i<preStr.length()) {
//                if(preStr.charAt(i) == preStr.charAt(k)) {
//                    c++;
//                    i++;
//                } else {
//                    sb.append(c).append(preStr.charAt(k));
//                    k = i;
//                    c = 0;
//                }
//            }
//        }
//        sb.append(c).append(preStr.charAt(i-1));
        return sb.toString();
    }
}
