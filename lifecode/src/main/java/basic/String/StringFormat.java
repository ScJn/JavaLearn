package basic.String;


import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Struct;

public class StringFormat {

    public static void main(String[] args) {
        String format = String.format("%d[]=%d", 2, 3);
        System.out.println(format);

        byte s = 12;
        String format1 = String.format("%05X", s);
        System.out.println(format1);
    }

    static class StringFormatForHex {

        static void disposal(byte[] data) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                if (i % 16 == 0) {
                    if (i != 0) builder.append("\n");
                    String s = String.format("%05X: ", i);
                    builder.append(s);
                }
                builder.append(String.format("%02X ", data[i]));
            }
            System.out.println(builder);
        }

        public static void main(String[] args) {
            File file = new File("C:\\code\\java code\\ideaSpace\\codeForJob\\src\\basic\\String\\PrintTest.java");
            BufferedInputStream in = null;
            try {
                in = new BufferedInputStream(new FileInputStream(file));
            } catch (Exception e) {
                e.printStackTrace();
            }
            byte[] bytes = new byte[1024];
            try {
                while (in.read() != -1) {
                    in.read(bytes);
                }
            } catch (Exception e) {

            }

            disposal(bytes);
        }
    }
}
