package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.StringBuilder;
public class FileIOTest {

    public static void main(String[] args) throws IOException {
        InputStream is = null;
        try {
            is = new FileInputStream("a.txt");
            int temp;
            while ((temp = is.read()) != -1) {
                System.out.println(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        byte[] buffer=new byte[10];
        int len=-1;
        while((len=is.read(buffer))!=-1){
            String str=new String(buffer,0,len);
            System.out.println((str));
        }
//        BufferedInputStream
    }

}
