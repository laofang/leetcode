import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Leetcode2049题，统计最高分的节点数目
 * 关键字：二叉树，DFS
 * 主要思路：
 * 1. 移除每个元素后，可能将树分为几个部分（1. 整棵树-当前结点为根的树(root结点除外); 2. 左子树（如果存在）; 3. 右子树（如果存在））;
 * 2. 计算各个部分的树的结点数
 * 3. 比较移除每个元素后的各部分结点树的乘积并计数
 * 需要注意的地方：
 * 1. 最开始，我没有缓存每次计算出的数目，每次计算都会深度递归，然后超时；
 * 2. 开始的时候，乘积用的int类型，第204测试用例会溢出，改为long类型就好了。
 *
 */
public class LC2049 {
    public int countHighestScoreNodes(int[] parents) {
        //key：一个结点，value：key的直接子节点
        Map<Integer, List<Integer>> m = new HashMap<Integer,List<Integer>>();
        //key：一个结点，value：以key为根的树的结点数目，（就是一个缓存，最开始开始没这个会超时）
        Map<Integer,Integer> mNodeCount = new HashMap<Integer,Integer>();
        //构造 结点key-> 直接子结点List
        for(int i = 0; i < parents.length;i++) {
            List l = m.getOrDefault(parents[i],new LinkedList<Integer>());
            l.add(i);
            m.put(parents[i],l);
        }
        //当前最大值的数量
        int count = 0;
        //当前最大值（最开始int类型，测试用例204的时候溢出了）
        long max = 0;
        for(int i = 0; i < parents.length; i++) {
            //移除二叉树中第i个元素后的各部分乘积
            long product = removeKProduct(m,i,parents,mNodeCount);
            //乘积和最大值相等，计数加一
            if(product == max) {
                count++;
                //如果有更大的乘积，就更新max，同时从1计数
            } else if(product > max) {
                count = 1;
                max = product;
            }
        }

        return count;
    }

    //计算以每个结点为根的树的结点数
    public int nodeCount( Map<Integer,List<Integer>> m, int k,int[] parents,Map<Integer,Integer> mNodeCount) {
        //如果缓存中有，直接用缓存的
        if(mNodeCount.get(k) != null) {
            return mNodeCount.get(k);
        }
        //如果当前结点没有子结点，则返回1
        List<Integer> l = m.get(k);
        if(l == null) {
            return 1;
        }
        int count = 1;
        //当前结点的数量加上以每个子结点为根的树的结点数量
        for(Integer i : l) {
            count = count + nodeCount(m,i,parents,mNodeCount);
        }
        //存入缓存
        mNodeCount.put(k,count);
        return count;
    }
    //计算移除K元素后，各部分的乘积。乘积可能包含三部分，
    //1. 整棵树除去以当前结点为根的树，剩余的结点数量
    //2. 当前结点的左子树结点数量
    //3. 当前结点的右子树结点数量
    public long removeKProduct(Map<Integer,List<Integer>> m, int k,int[] parents,Map<Integer,Integer> mNodeCount) {
        //当前结点的父结点
        int parentIndex = parents[k];
        //当前结点的子结点
        List<Integer> l = m.get(k);
        //乘数的第一部分：整棵树除去以当前结点为根的树，剩余的结点数量
        long parentCount = 1;
        //两个子结点为根的树的结点数，初始为1，1
        long[] sonCount = new long[]{1,1};
        //当前结点不是根结点
        if(parentIndex != -1) {
            //乘数的第一部分：整棵树除去以当前结点为根的树，剩余的结点数量
            parentCount = nodeCount(m,0,parents,mNodeCount) - nodeCount(m,k,parents,mNodeCount);
        }
        //当前结点的子结点不为空
        if(l!=null) {
            //各个子节点为根的树的结点数
            for(int i = 0 ; i < l.size();i++) {
                sonCount[i] = nodeCount(m,l.get(i),parents,mNodeCount);
            }
            //计算最后的乘积
            return parentCount * sonCount[0] * sonCount[1];
        }
        //如果没有子结点，说明是叶子结点，直接返回余下的结点数即可
        return (long)parents.length - 1;
    }
}
//TODO 2049题，中等题，统计最高分的节点数目，图解法需要再理解一下