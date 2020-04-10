package leetcode.xiaozhao.ali;

import java.util.Arrays;

public class A1 {


    public static void main(String[] args) {

//        String s=calculate(16,1);
//        System.out.println(s);

        String s ="";
        System.out.println(s.split(".").length);
    }

    static class Node{
        int s;
        int no;

         public Node(int s, int no) {
            this.s = s;
            this.no = no;
        }
    }
    static String calculate(int m, int k) {
        int[] pig = new int[m+2];
        pig[1]=2;pig[2]=3;pig[3]=4;
        Node[] a=new Node[m];
        a[0]=new Node(2,1);
        a[1]=new Node(3,2);a[2]=new Node(4,3);

        int i=4;int ye=0;
        boolean f=true;

        for(;i<=m;i++){
            pig[i]=pig[i-2]+pig[i-3];
            int tem=re(pig[i]);
            a[i-1]=new Node(tem,i);
            if(f&&pig[i]>m){
                ye=i;
                f=false;
            }
        }

        ye+=(2019-4);
        if(m==1)ye=2019;
        if(m==2)ye=2020;
        if(m==3)ye=2021;
        if(m==4)ye=2022;
        Arrays.sort(a,(o1,o2)->o2.s-o1.s);

        int c=a[k-1].no;
        return pig[m]+","+ye+","+c;

    }
    static int re(int x){
        String s=String.valueOf(x);
        StringBuilder ss=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            ss.append(s.charAt(i));
        }
        return Integer.valueOf(ss.toString());
    }
}
