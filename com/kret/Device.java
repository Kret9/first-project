package com.kret;

import java.io.Serializable;
import java.util.Objects;


public class Device implements Serializable {
    private String vendor;
    private String model;
    private String problem;
    private DeviceType type;

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    @Override
    public String toString() {
        return "Device:" + '\n' +
                "type = " + type +'\n' +
                "vendor = " + vendor + '\n' +
                "model = " + model + '\n' +
                "problem = " + problem + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device that = (Device) o;
        return Objects.equals(vendor, that.vendor) && Objects.equals(model, that.model) && Objects.equals(problem, that.problem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendor, model, problem);
    }
}
