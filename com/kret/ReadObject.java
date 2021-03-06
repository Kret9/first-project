package com.kret;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {

    protected void readOrder() throws IOException, ClassNotFoundException {
        try(FileInputStream fis = new FileInputStream("order.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)){
            Order order = (Order) ois.readObject();
            System.out.println(order);
        }
    }
}

//try {
//        FileInputStream fis = new FileInputStream("order.txt");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        Order order = (Order) ois.readObject();
//        System.out.println(order);
//        ois.close();
//        } catch (IOException | ClassNotFoundException e) {
//        e.printStackTrace();
//        }