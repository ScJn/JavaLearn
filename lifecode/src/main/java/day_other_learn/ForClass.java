package day_other_learn;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;
import java.util.*;

public class ForClass extends ArrayList implements Serializable, Runnable {

    private String isString;
    public int isInt;
    private ArrayList<String> arrayList = null;

    private LinkedList<String> linkedList;
    private TreeMap<String, String> treeMap;
    private HashSet<Object> objects;
    private TreeSet<Object> objectTreeSet;

    @Override
    public void run() {

        File dest = new File("dest");
        OutputStream out = null;
        try {
            out = new FileOutputStream(dest, false);//if append set true
            String msg = "come on!";
            byte[] data = msg.getBytes();
            out.write(data, 0, data.length);
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private String fReString(int a, String b) {
        int c = a;
        c += 1;
        String cc = String.valueOf(c);
        return b + cc;
    }

    public int aa(int a, int b) {
        return a + b;
    }

    public static void copyFile(String srcPath, String destPath) {
        InputStream is = null;
        OutputStream out = null;

        try {
            is = new FileInputStream(srcPath);
            int len = -1;
            byte[] buffer = new byte[1024 * 10];
            out = new FileOutputStream(destPath, true);//if append set true
            while ((len = is.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close the last open one, then the first one
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static byte[] picToByte(String picPath) throws IOException {
        InputStream in = new FileInputStream(picPath);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = in.read(buffer)) != -1) {
            bout.write(buffer, 0, len);
        }
        bout.flush();
        bout.close();
        in.close();
        return bout.toByteArray();
    }

    public static void byteToPic(String picPath, String destPath) throws IOException {
        OutputStream out = new FileOutputStream(destPath);
        ByteArrayInputStream bin = new ByteArrayInputStream(picToByte(picPath));
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = bin.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        out.flush();
        out.close();
        bin.close();
    }

    public static void main(String[] args) throws IOException {
//        copyFile("D:\\javas\\java_learning\\src\\leetcode\\ForClass.java","aa.txt");
//        byteToPic("D:\\javas\\java_learning\\src\\leetcode\\03.png", "dd.png");

        s();
    }

    public static class Emm implements Serializable{
        private String a;
        private int c;
        Emm(){}

    }
    public static void objectIO() throws IOException {
        ByteArrayOutputStream bout=new ByteArrayOutputStream();
        ObjectOutputStream oout=new ObjectOutputStream(new BufferedOutputStream(bout));
        oout.writeObject("asdd");
        Emm emm=new Emm();
        oout.writeObject(emm);
        byte[] data=bout.toByteArray();

        ObjectInputStream oin=new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(data)));

    }
    public static void s() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            String msg="";
            while(!msg.equals("exit")){
                msg=reader.readLine();
                writer.write(msg);
                writer.newLine();
                writer.flush();
            }

        } catch (Exception e) {

        }
    }
}

