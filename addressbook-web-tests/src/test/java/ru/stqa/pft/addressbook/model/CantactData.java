package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
@XStreamAlias("contact")
@Entity
@Table(name="addressbook")

public class CantactData {
    @XStreamOmitField
    @Id
    @Column(name="id")
    private  int id=0;

    @Column(name="firstname")
    private  String firstname;

    @Column(name="lastname")
    private  String lastname;

    @Transient
    private  String group;

    @Column(name="address")
    @Type(type="text")
    private  String address;

    @Column(name="home")
    @Type(type="text")
    private  String homePhone;

    @Column(name="mobile")
    @Type(type="text")
    private  String mobilePhone;

    @Column(name="work")
    @Type(type="text")
    private  String workPhone;

    @Override
    public String toString() {
        return "CantactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Column(name="phone2")
    @Type(type="text")
    private  String home2Phone;

    @Transient
    private  String allPhones;

    @Column(name="email")
    @Type(type="text")
    private  String email;

    @Column(name="email2")
    @Type(type="text")
    private  String email2;

    @Column(name="email3")
    @Type(type="text")
    private  String email3;

    @Transient
    private  String allEmail;

    @Transient
    private  String withAllText;

    @Column(name="photo")
    @Type(type="text")
    private String photo;






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CantactData that = (CantactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    public CantactData withId(int id) {
        this.id = id;
        return this;
    }

    public CantactData withtFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public CantactData withLastname(String lastname) {
        this.lastname = lastname;

        return this;
    }

    public CantactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public CantactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }


    public CantactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }
    public CantactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }


    public CantactData withEmail(String email) {
        this.email = email;
        return this;
    }
    public CantactData withHome2Phone(String home2Phone) {
        this.home2Phone = home2Phone;
        return this;
    }

    public CantactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }
    public CantactData withAllEmail(String allEmail) {
        this.allEmail = allEmail;
        return this;
    }

    public CantactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }
    public CantactData withEmail3(String email3) {
        this.email3= email3;
        return this;
    }

    public CantactData withAllText(String withAllText) {
        this.withAllText = withAllText;
        return this;
            }

    public CantactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;

    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getMobilePhone() {

        return mobilePhone;
    }

    public String getHome2Phone() {
        return home2Phone;
    }
    public String getAllPhones() {
        return allPhones;
    }

    public String getAllEmail() {
        return allEmail;
    }

    public String getEmail2() {
        return email2;
    }
    public String getEmail3() {
        return email3;
    }

    public String getAllText() {
        return withAllText;
    }
    public File getPhoto() {
        return new File(photo);
    }


}
