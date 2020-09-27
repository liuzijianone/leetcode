package algorithm.others.basic.lesson07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/19 18:39
 */
public class UnionFindSetDemo {
    public static void main(String[] args) {
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();
        Node f = new Node();
        Node[] nodes = {a,b,c,d,e,f};

        UnionFindSet set = new UnionFindSet(Arrays.asList(nodes));
        set.union(a, b);
        set.union(c, d);
//        set.union(b, e);
        set.union(a, c);
        System.out.println(set.isSameSet(a,e));

    }

    public static class Node{

    }

    public static class UnionFindSet{
        private Map<Node, Node> fatherMap;
        private Map<Node, Integer> nodesMap;

        public UnionFindSet(List<Node> list) {
            this.fatherMap = new HashMap<>();
            this.nodesMap = new HashMap<>();
            for (Node node : list) {
                fatherMap.put(node, node);
                nodesMap.put(node, 1);
            }
        }

        public Node findHead(Node node){
            if(node == null){
                return null;
            }
            while(fatherMap.get(node) != node){
                node = fatherMap.get(node);
            }
            return node;
        }

        public boolean isSameSet(Node A, Node B){
            if(A == null || B == null){
                return false;
            }
            return findHead(A) == findHead(B);
        }

        public void union(Node A, Node B){
            if (A == null || B == null ){
                return ;
            }

            Node rootA = findHead(A);
            Node rootB = findHead(B);

            if (rootA != rootB){
                int numA = nodesMap.get(rootA);
                int numB = nodesMap.get(rootB);
                if(numA >= numB){
                    fatherMap.put(rootB, rootA);
                    nodesMap.put(rootA, numA + numB);
                }else {
                    fatherMap.put(rootA, rootB);
                    nodesMap.put(rootB, numA + numB);
                }

            }
        }






    }
}
