package com.kret;

import java.io.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {


    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("Please enter first name");
        Customer customer = new Customer();
        customer.setFirstName(getInfo());
        System.out.println("Please enter last name");
        customer.setLastName(getInfo());
        System.out.println("Please enter your phone number or e-mail");
        customer.setPhoneNumber(setPhoneEmail());
////////////////////////////////////////////////////////////////////////////////////////
        Device device = new Device();
        System.out.println("Please enter your device type:");
        device.setType(chooseDeviceType());
        System.out.println("Please enter vendor:");
        device.setVendor(enterInfo());
        System.out.println("Please enter model:");
        device.setModel(enterInfo());
        System.out.println("Please enter problem:");
        device.setProblem(enterInfo());
    ////////////////////////////////////////////////////////////////////////////////////
        Order order = new Order();
        order.setCustomer(customer);
        List<Device> devices = new ArrayList<>();
        devices.add(device);
        order.setDevices(devices);
        writeObject(order);



        close();

    }

    private static String getInfo() {
        String info;
        do {
            info = enterInfo();
            if (!validatedInput(info)) {                         //доробив оце
                System.out.println("!!!Wrong enter!!!");        //доробив оце
            }
        } while (!validatedInput(info));
        return info;
    }

    private static String enterInfo() {

        return sc.nextLine();
    }

    private static boolean validatedInput(String s) {
        return s.matches("[a-zA-Z]+");
    }

    private static boolean validatedInputDevice(String s) {                       // зробив цей метод
        return s.equals("1") || s.equals("2") || s.equals("3");
    }


    private static void close() {
        sc.close();
    }

    private static DeviceType chooseDeviceType() {                     //зробив цей метод
        System.out.println("Enter 1 if your device is smartphone");
        System.out.println("Enter 2 if your device is laptop");
        System.out.println("Enter 3 if your device is tablet");

        String info;
        do {
            info = enterInfo();
            try {
                return getDeviceType(info);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            //System.out.println("Wrong option");
        } while (!validatedInputDevice(info));

        return null;                                            //???????????????? NULL
    }

    private static DeviceType getDeviceType(String info) {
        if (info.equals("1")) {
            return DeviceType.SMARTPHONE;
        } else if (info.equals("2")) {
            return DeviceType.LAPTOP;
        } else if (info.equals("3")) {
            return DeviceType.TABLET;
        } else {
            throw new IllegalArgumentException("Illegal device type");
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////
    public static void writeObject( Object a) {
        try {
            FileOutputStream fos = new FileOutputStream("order.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a);

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean validateEmailPhone(String s){
       return s.matches("^[A-Za-z0-9+_.-]+@(.+)$") || s.matches("[0-9]+");

    }
    public static String setPhoneEmail(){
        String info;
        do {
            info = enterInfo();
            if(!validateEmailPhone(info)){
                System.out.println("!!!Wrong enter!!!");
            }
        } while (!validateEmailPhone(info));
        return info;                                        ////////////////////?????????????????? NULL?????????
    }
}