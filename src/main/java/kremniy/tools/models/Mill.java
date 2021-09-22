package kremniy.tools.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Mill {
    private static int millId=1;

    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min=2, max=45, message = "Name should be between 2 and 45 characters!")
    private String name;

    @Min(value = 0, message = "Diameter should be greater than 0!")
    private double diameter;

    @Min(value = 0, message = "Number of flutes should be greater than 0!")
    private int numberOfFlutes;

    @Size(min=1, max=45, message = "Manufacturer name should be between 1 and 45 characters!")
    private String manufacturer;

    @NotEmpty(message = "Vendor code shouldn't be empty!")
    @Size(min=1, max=155, message = "Vendor code should be between 1 and 155 characters!")
    private String vendorCode;

    public Mill(String name, double diameter, int numberOfFlutes, String manufacturer, String vendorCode) {
        this.name = name;
        this.diameter = diameter;
        this.numberOfFlutes = numberOfFlutes;
        this.manufacturer = manufacturer;
        this.vendorCode = vendorCode;
    }

    public Mill(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public int getNumberOfFlutes() {
        return numberOfFlutes;
    }

    public void setNumberOfFlutes(int numberOfFlutes) {
        this.numberOfFlutes = numberOfFlutes;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public static int getMillId() {
        return millId;
    }

    public static void setMillId(int millId) {
        Mill.millId = millId;
    }
}
