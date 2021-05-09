package leetcode.xiaozhao.byteDance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class bd2018z_1 {

    static class Node{
        int no;
        int x;
        int y;

        public Node(int no, int x, int y) {
            this.no = no;
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            int hash=0;
            while(x>0){
                hash=31*hash+x%10+y%10;
                x/=10;y/=10;
            }
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if(this==obj)return true;
            if(obj instanceof Node){
                Node node=(Node)obj;
                return node.x==this.x&&node.y==this.y;
            }
            return false;
        }
    }
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        Node[] nodes=new Node[n];
        for(int i=0;i<n;i++){
            int x=in.nextInt();
            int y=in.nextInt();
            nodes[i]=new Node(i,x,y);
        }

        Node[] xSort= Arrays.copyOf(nodes,nodes.length);
        Node[] ySort=Arrays.copyOf(nodes,nodes.length);
        Arrays.sort(xSort,(o1,o2)->o2.x-o1.x);
        Arrays.sort(ySort,(o1,o2)->o2.y-o1.y);

        HashSet<Node> preSet=new HashSet<>();

        Node[] res=new Node[n];
        for(int i=0;i<n;i++){
            res[i]=new Node(0,Integer.MAX_VALUE,0);
        }
        int resIndex=0;
        for(Node node:xSort){
            if(preSet.size()==0) {
                res[resIndex++]=node;
                preSet.add(node);
                continue;
            }
            for(Node nodeY:ySort){
                if(nodeY.x==node.x&&nodeY.y==node.y){
                    res[resIndex++]=node;
                    break;
                }else if(preSet.contains(nodeY)){
                    break;
                }
            }
            preSet.add(node);
        }

        Arrays.sort(res,(o1,o2)->o1.x-o2.x);
        for(int i=0;i<resIndex;i++){
            System.out.println(res[i].x+" "+res[i].y);
        }
    }
}
