package leetcode.xiaozhao.tencent;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Tencent05 {

    public static void main(String[] args) {

        PriorityQueue<Integer>queue=new PriorityQueue<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            int t = in.nextInt();
            queue.add(-t);
        }
        long res= 0;
        int flag=1;
        while(!queue.isEmpty()){
            int top = -queue.poll();
            res+=flag==1?top:-top;
            flag=(flag+1)%2;
        }
        System.out.println(res);
    }
}
