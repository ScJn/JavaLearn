package classLoad;

import java.io.*;

public class FileClassLoader extends ClassLoader {

    private String rootDir;

    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        Class<?> clazz = findLoadedClass(name);

        if (clazz != null) {
            return clazz;
        } else {
            try {
                clazz = getParent().loadClass(name);
            } catch (Exception e) {
            }
            if (clazz != null) return clazz;
            else {
                byte[] data = getClassData(name);
                if (data != null) clazz = defineClass(name, data, 0, data.length);
                else throw new ClassNotFoundException();

            }
        }
        return clazz;
    }

    private byte[] getClassData(String name) {
        String path = rootDir + "/" + name.replace(".", "/") + ".class";
        InputStream in = null;
        ByteArrayOutputStream bout = null;
        try {
            in = new FileInputStream(path);


            bout = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int temp=-1;
            while ((temp=in.read(buffer)) != -1) {
                bout.write(buffer,0,temp);
            }
            bout.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return bout.toByteArray();
    }
}
