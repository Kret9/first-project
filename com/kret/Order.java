package com.kret;

import jdk.jshell.spi.SPIResolutionException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order implements Serializable {

    private Customer customer;
    private List<Device> devices;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(customer, order.customer) && Objects.equals(devices, order.devices);
    }

    @Override
    public String toString() {
        return "Order info:" + '\n'
                 + customer + '\n'
                + devices;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, devices);
    }

}
