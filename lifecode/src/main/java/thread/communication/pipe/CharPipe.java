package thread.communication.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

public class CharPipe {

    public void readMethod(PipedReader in){
        System.out.println("read:");
 
        char[] byteArray=new char[20];
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

    public void writeChar(PipedWriter writer){

        try {
            writer.write("你好");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
