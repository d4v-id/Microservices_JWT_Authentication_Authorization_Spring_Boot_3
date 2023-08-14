package com.bmhrdk.mitra.mitra.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tbl_mitra")
public class MitraEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mtr_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "mitra_name")
    private String mitraName;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private Long phoneNumber;

    public MitraEntity() {
    }

    public MitraEntity(Long id, String name, String mitraName, String email, String address, Long phoneNumber) {
        this.id = id;
        this.name = name;
        this.mitraName = mitraName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMitraName() {
        return mitraName;
    }

    public void setMitraName(String mitraName) {
        this.mitraName = mitraName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
