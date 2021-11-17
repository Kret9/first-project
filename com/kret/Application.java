package com.kret;

import java.io.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println("Please enter first name");
        Customer customer = new Customer();
        customer.setFirstName(setFirstAndLastName());
        System.out.println("Please enter last name");
        customer.setLastName(setFirstAndLastName());
        System.out.println("Please enter your phone number or e-mail");
        customer.setPhoneNumber(setPhoneOrEmail());

        Device device = new Device();
        System.out.println("Please enter your device type:");
        device.setType(chooseDeviceType());
        System.out.println("Please enter vendor:");
        device.setVendor(enterInfo());
        System.out.println("Please enter model:");
        device.setModel(enterInfo());
        System.out.println("Please enter problem:");
        device.setProblem(enterInfo());

        Order order = new Order();
        order.setCustomer(customer);
        List<Device> devices = new ArrayList<>();
        devices.add(device);
        order.setDevices(devices);

        System.out.println("Do you want write information to the file?");
        System.out.println("Please enter Y if Yes");
        System.out.println("Please enter N if No");
        writeObject(order);



//        ObjectWriter writer = new ObjectWriter();         //////// Тут багато exceptions в main
//        writer.writeOrder(order);

        ReadObject reader = new ReadObject();          //////// Тут багато exceptions в main
        reader.readOrder();

        close();

    }

    private static String setFirstAndLastName() {
        String info;
        do {
            info = enterInfo();
            if (!validatedInputOnlyLetters(info)) {
                System.out.println("!!!Wrong enter!!!");
            }
        } while (!validatedInputOnlyLetters(info));
        return info;
    }

    private static String enterInfo() {

        return sc.nextLine();
    }

    private static boolean validatedInputOnlyLetters(String s) {
        return s.matches("[a-zA-Z]+");
    }

    private static boolean validatedInputDevice(String s) {                       // зробив цей метод
        return s.equals("1") || s.equals("2") || s.equals("3");
    }

    private static void close() {
        sc.close();
    }

    private static DeviceType chooseDeviceType() {
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

    public static boolean validateEmailAndPhone(String s){
       return s.matches("^[A-Za-z0-9+_.-]+@(.+)$") || s.matches("[0-9]+");
    }

    public static String setPhoneOrEmail(){
        String info;
        do {
            info = enterInfo();
            if(!validateEmailAndPhone(info)){
                System.out.println("!!!Wrong enter!!!");
            }
        } while (!validateEmailAndPhone(info));
        return info;                                        ////////////////////?????????????????? NULL?????????
    }

    public static void writeObject (Order a) throws IOException {
        String info = enterInfo();
        if(info.equalsIgnoreCase("y")){
            ObjectWriter writer = new ObjectWriter();
            writer.writeOrder(a);
        }
    }
}