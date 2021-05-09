package leetcode.xiaozhao.byteDance;

import java.util.*;

public class B2 {

    public static void main(String[] args) {

        class Node {
            int x;
            int y;

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return x == node.x &&
                        y == node.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m;
        for (int i = 0; i < n; i++) {
            List<Map<Node, Integer>> list = new ArrayList<>();
            Map<Node, Integer> map = new HashMap<>();
            m = in.nextInt();
            Node ansNode;
            int ans=-1;
            int k;
            for (int j = 0; j < m; j++) {
                k = in.nextInt();
                HashMap<Node,Integer>map1 = new HashMap<>();
                list.add(map1);
                for (int p = 0; p < k; p++) {
                    int x = in.nextInt();
                    int y = in.nextInt();
                    Node cur = new Node(x,y);
                    if(j==0){
                        list.get(0).put(cur,1);
                    }else {
                        int num =list.get(j-1).getOrDefault(cur,0);
                        list.get(j).put(cur,num+1);
                        if(map.getOrDefault(cur,0)<num+1){
                            map.put(cur,num+1);
                            if(ans<num+1){
                                ans=num+1;
                                ansNode=cur;
                            }
                        }
                    }



                }
            }

            System.out.println(ans<=2?1:ans);
        }
    }
}
