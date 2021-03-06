package com.EntityClasses;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by DAMMA on 8/31/2017.
 */

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "Supplier")
public class Supplier extends RecursiveTreeObject<Supplier> {


    private SimpleIntegerProperty supId;
    private SimpleStringProperty supname;
    private SimpleStringProperty email;
    private SimpleStringProperty contactNumber;
    private SimpleStringProperty address;
    private SimpleStringProperty type;



    public Supplier() {
        this.supId = new SimpleIntegerProperty();
        this.supname = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.contactNumber = new SimpleStringProperty();
        this.address = new SimpleStringProperty();
        this.type = new SimpleStringProperty();
    }

    @Id
    @Column(name = "pID")
    @GeneratedValue
    public int getSupId() {
        return supId.get();
    }

    public SimpleIntegerProperty supIdProperty() {
        return supId;
    }

    public void setSupId(int supId) {
        this.supId.set(supId);
    }

    @Column(name = "supname")
    public String getSupname() {
        return supname.get();
    }

    public SimpleStringProperty supnameProperty() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname.set(supname);
    }

    @Column(name = "email")
    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    @Column(name = "contactNumber")
    public String getContactNumber() {
        return contactNumber.get();
    }

    public SimpleStringProperty contactNumberProperty() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber.set(contactNumber);
    }


    @Column(name = "Address")
    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }


    @Column(name= "Type")
    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }


    @Override
    public String toString() {
        return supname.get();
    }
}
