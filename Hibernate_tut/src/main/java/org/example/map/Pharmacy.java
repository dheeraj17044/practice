package org.example.map;

import javax.persistence.*;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Pharmacy {

    @Id
    @Column(name = "p_id")
    private int pharmacyId;

    @Column(name="p_name")
    private String pharmacyName;

    @ManyToMany(mappedBy = "pharmacies")
    private List<User> users;

    public Pharmacy() {
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "pharmacyId=" + pharmacyId +
                ", pharmacyName='" + pharmacyName + '\'' +
                '}';
    }
}
