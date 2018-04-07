package pro.phoenix.coursecenter;

/**
 * Created by ANNAS on 3/24/2018.
 */

public class Customer {
    String customerName;
    String customerPhone;

    public Customer() {
    }

    public Customer(String customerName, String customerPhone) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }
}
