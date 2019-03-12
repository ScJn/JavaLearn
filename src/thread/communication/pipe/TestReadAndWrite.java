package thread.communication.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TestReadAndWrite {

    public static void main(String[] args) throws IOException {

        ReadData readData = new ReadData();
        WriteData writeData = new WriteData();

        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();

        in.connect(out);
        Thread t1 = new Thread(() -> {
            while (true)
                readData.readMethod(in);
        });

        Thread t2=new Thread(()->{
            while(true)
                writeData.writeMethod(out);
        });
        t1.start();
        t2.start();
    }
}
