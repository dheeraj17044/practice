package org.example;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
//import java.sql.Date;

@Entity
@Table(name="student_address")
public class StudentAdress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 50,name = "address_id")
    private int addressId;
    @Column(length = 30)
    private String street;
    private String city;
    private String state;
    @Temporal(TemporalType.DATE)
    @Column(name = "added_date")
    private Date addedDate;
    private String pinCode;
    @Column(name = "image")
    @Lob
    private byte[] addressImage;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public byte[] getAddressImage() {
        return addressImage;
    }

    public void setAddressImage(byte[] addressImage) {
        this.addressImage = addressImage;
    }

    public StudentAdress() {
    }

    @Override
    public String toString() {
        return "StudentAdress{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", addedDate=" + addedDate +
                ", pinCode='" + pinCode + '\'' +
                ", addressImage=" + Arrays.toString(addressImage) +
                '}';
    }
}
