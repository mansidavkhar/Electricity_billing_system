package user;
import java.util.*;

//in this class we will declare the attributes of the user
//also used setters and getters
//achieved Constructor Overloading
//added the method to calculate bill

public class User {

    public String name;
    public long EYC;
    public String address;
    public String email;
    public long aadharNo;
    public float noOfUnits;


    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setEYC(int EYC) {
        this.EYC = EYC;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setEmail_id(String email) {
        this.email = email;
    }
    public void setNo_of_units(float no_of_units) {
        this.noOfUnits = no_of_units;
    }
    public void setAadhar_no(long aadhar_no) {
        this.aadharNo = aadhar_no;
    }


    // Getter methods for all attributes
    public String getName() {
        return name;
    }

    public long getEYC() {
        return EYC;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public long getAadharNo() {
        return aadharNo;
    }

    public float getNoOfUnits() {
        return noOfUnits;
    }


    // Constructor with all parameters
    public User(String name, long EYC, String address, String email, long aadharNo, float noOfUnits) {
        this.name = name;
        this.EYC = EYC;
        this.address = address;
        this.email = email;
        this.aadharNo = aadharNo;
        this.noOfUnits = noOfUnits;
    }

    //constructor overloading achieved here
    // Constructor with basic parameters
    public User(String name, String address, String email) {
        this(name, 0, address, email, 0, 0.0f); // Call the full-parameter constructor with default values
    }


    public float billed_amount_domestic() {
        float money ;
        float num = noOfUnits;

        if(num <= 150 ){
            money = num * 2.75f ;
        }else if (num >150 && num<400){
            money = num  * 4.80f ;
        }else {
            money = num * 5.20f ;
        }
        System.out.println(money);
        return money ;
    }

    public float totalUnits(){
        return 0;
    }


    public String toString() {
        return "Name: " + name + "\nEYC Number: " + EYC + "\nAddress: " + address + "\nEmail: " + email +
                "\nAadhar Number: " + aadharNo + "\nNo. of Units: " + noOfUnits;
    }

}