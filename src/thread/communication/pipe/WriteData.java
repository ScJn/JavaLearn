package thread.communication.pipe;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {

    public void writeMethod(PipedOutputStream out){
        try{
            System.out.println("write:");
            for(int i=0;i<100;i++){
                String data=""+(i+1);
                out.write(data.getBytes());
                System.out.println("data:"+data);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
