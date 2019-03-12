import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class test1 {
    public int reverse(int x) {
        long res=0;
        boolean flag=false;
        if(x<0){
            x=-x;
            flag=true;
        }
        while(x>0) {
            int tail = x % 10;
            x /= 10;
            res = res * 10 + tail;
            if(res>Integer.MAX_VALUE)return 0;
        }
        return flag?(int)(-res):(int)res;
    }
    public static void main(String[] args) {
        System.out.println("2019-02-08 19:45:46".substring(0,16));
    }

}
