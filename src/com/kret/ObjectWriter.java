package com.kret;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriter {
    public static void writeObject( Object a) {
        try {
            FileOutputStream fos = new FileOutputStream("order.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a);

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
