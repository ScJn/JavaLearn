package thread.communication.pipe;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class TestCharPipe {

    public static void main(String[] args) throws IOException {

        PipedReader reader=new PipedReader();

        PipedWriter writer=new PipedWriter();

        reader.connect(writer);
        CharPipe charPipe=new CharPipe();

        Thread t1=new Thread(()-> {
            while(true)charPipe.writeChar(writer);
        });

        Thread t2=new Thread(()-> {
            while(true)charPipe.readMethod(reader);
        });

        t1.start();
        t2.start();
    }
}
