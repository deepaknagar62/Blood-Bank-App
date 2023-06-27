// user Dao for donate activity

package com.example.bloodbank;

public class Member {
    private String name;
    private String phone;
    private String Blood_Group;
    private String address;

    Member(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBlood_Group() { return Blood_Group; }

    public void setBlood_Group(String Blood_Group) {
        this.Blood_Group = Blood_Group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
