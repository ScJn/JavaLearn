package leetcode.xiaozhao.tencent;

import java.util.ArrayList;
import java.util.Scanner;

public class Tencent03 {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=2;i<=1000;i++){
            int factorNum = 0;
            for(int j=2;j*j<=i;j++){
                if(i%j==0){
                    factorNum++;
                    break;
                }
            }
            if(factorNum==0)list.add(i);
        }

        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int sum=0;
        for(int i=0,j=list.size()-1;i<=j;){

            int temp = list.get(i)+list.get(j);
            if(temp<input)i++;
            else if(temp>input)j--;
            else {
                sum++;
                i++;j--;
            }


        }
        System.out.println(sum);
    }
}
