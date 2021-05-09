package leetcode.xiaozhao.tencent;

import java.util.*;

public class Tencent07 {


    static int k, a, aNum, b, bNum, sum;
    static int[][] com,A;
    static int mod=1000000007;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
//        k = in.nextInt();
//        a = in.nextInt();
//        aNum = in.nextInt();
//        b = in.nextInt();
//        bNum = in.nextInt();
//        sum = 0;
//        int max = Math.max(aNum,bNum);
//        com = new int[max+5][max+5];
//        A = new int[max+5][max+5];
//        dfs(k, aNum, bNum);
//        System.out.println(sum/2);


        class Node{
            int e;
            int w;
            Node(int e,int w){
                this.e=e;
                this.w=w;
            }
        }
        Map<Integer,List<Node>> map=new HashMap<>();
        ArrayList<List<Node>> arrayList=new ArrayList<>();
        for(int i=0;i<=5;i++){
            int b=in.nextInt();
            int e =in.nextInt();
            int w= in.nextInt();
            map.putIfAbsent(b, new LinkedList<>());
            map.get(b).add(new Node(e,w));
        }
        System.out.println("sd");

    }

    static void dfs(int remain, int aRemain, int bRemain) {
        if(A[aRemain][bRemain]!=0){
            sum+=A[aRemain][bRemain];
            sum%=mod;
            return;
        }
        if (aNum < 0 || bNum < 0) return;
        if (remain == 0) {
            A[aRemain][bRemain]=C(aNum-aRemain,aNum)%mod*C(bNum-bRemain,bNum)%mod;
            sum+=A[aRemain][bRemain];
            sum%=mod;
            return;
        }else if(remain<0)return;
        dfs(remain - a, aRemain-1,bRemain);
        dfs(remain -b,aRemain,bRemain-1);
    }

    static int C(int a,int b){
        if(com[a][b]!=0)return com[a][b]%mod;
        int sum=1,fac=1;
        for(int i=1;i<=b-a;i++){
            sum*=i;
            sum%=mod;
        }
        for(int i=1;i<=b;i++){
            fac*=i;
            fac%=mod;
        }
        com[a][b]=fac/sum;
        return com[a][b];
    }
}
