package basic.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class StringReadTest {
    public static void main(String[] args) throws IOException {

        BufferedReader stringReader = new BufferedReader(new StringReader("hehehe dd2"));
        String s = stringReader.readLine();
        System.out.println(s);


    }
}
