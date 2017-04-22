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

    @Transient
    //@Column(name="photo")
    //@Type(type="text")
    private String photo;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CantactData that = (CantactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
        if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;
        if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;
        if (home2Phone != null ? !home2Phone.equals(that.home2Phone) : that.home2Phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
        return email3 != null ? email3.equals(that.email3) : that.email3 == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
        result = 31 * result + (home2Phone != null ? home2Phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (email2 != null ? email2.hashCode() : 0);
        result = 31 * result + (email3 != null ? email3.hashCode() : 0);
        return result;
    }

    public File getPhoto() {
        return new File(photo);
    }


}
