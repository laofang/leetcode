import java.util.*;

/**
 * Leetcode1604题，警告一小时内使用相同员工卡大于等于三次的人
 * 关键字：数组、哈希表、字符串、排序
 * 主要思路：
 * 1.哈希存储，数据按名称分组，时间转为分钟
 * 2.名称对应的时间按时间排序
 * 3.依次检查，如果比前两个时间差小于等于60，添加到返回值
 * 4.结果按照字典排序返回
 */
public class LC1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        Map<String,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.computeIfAbsent(keyName[i],o->new ArrayList<>()).add(time(keyTime[i]));
        }

        List<String> ans = new ArrayList<>();
        for(String name:map.keySet()) {
            List<Integer> list = map.get(name);
            Collections.sort(list);
            boolean flag = false;
            for(int i = 2;i < list.size() && !flag; i++) {
                if(list.get(i) - list.get(i - 2) <= 60){
                    flag = true;
                }
            }
            if(flag) ans.add(name);
        }
        Collections.sort(ans);
        return ans;
    }
    private int time(String strTime){
        String[] ts = strTime.split(":");
        int hour = Integer.parseInt(ts[0]);
        int min = Integer.parseInt(ts[1]);
        return hour*60+min;
    }
}
