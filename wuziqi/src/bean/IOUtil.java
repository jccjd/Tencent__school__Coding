package bean;

import java.io.*;

public class IOUtil {

    public static void writeObject(Object obj, OutputStream os) {
        try {

            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(obj);
            oos.flush();
        } catch (IOException e) {

        }
    }
    /*读对象*/
    public static Object readObject(InputStream is) {
        Object obj = null;

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(is);
            obj = ois.readObject();

        } catch (IOException e) {
            System.out.println("用户下线");
            try {
                ois.close();
            } catch (IOException e1) {

            }

        } catch (ClassNotFoundException e) {
            System.out.println("col");
        }
        return obj;
    }
}
