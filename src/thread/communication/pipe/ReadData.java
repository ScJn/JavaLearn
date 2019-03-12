package thread.communication.pipe;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {

    public void readMethod(PipedInputStream in){
        System.out.println("read:");

        byte[] byteArray=new byte[20];
        try {
            int len=-1;
            while((len=in.read(byteArray))!=-1){
                String newData=new String(byteArray,0,len);
                System.out.println("read data"+newData);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
