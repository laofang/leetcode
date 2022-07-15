import structure.Node;

/**
 * Leetcode558题，四叉树交集
 * 关键字：树、分治
 * 主要思路：
 * 1. 使用递归分治方法
 * 2. 两个节点有以下几种情况
 *      1. 有一个是叶子节点
 *          1. 如果叶子节点val==1，交集的节点是1
 *          2. 如果叶子节点val==0，返回另一个节点即可
 *      2. 两个都不是叶子节点，那就分治递归
 *          1. 求出四个子节点，对四个子节点进行判断，根据结果返回节点
 */
public class LC558 {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if(quadTree1.isLeaf || quadTree2.isLeaf) {
            Node p = quadTree1.isLeaf ? quadTree1 : quadTree2;
            if(p.val) {
                return new Node(p.val,p.isLeaf,null,null,null,null);
            } else {
                return p == quadTree1 ? quadTree2 : quadTree1;
            }
        } else {
            Node topLeft = intersect(quadTree1.topLeft,quadTree2.topLeft);
            Node topRight = intersect(quadTree1.topRight,quadTree2.topRight);
            Node bottomLeft = intersect(quadTree1.bottomLeft,quadTree2.bottomLeft);
            Node bottomRight = intersect(quadTree1.bottomRight,quadTree2.bottomRight);
            if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                    && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
                return new Node(topLeft.val,topLeft.isLeaf,null,null,null,null);
            } else {
                return new Node(false,false,topLeft,topRight,bottomLeft,bottomRight);
            }
        }
    }
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };
}

