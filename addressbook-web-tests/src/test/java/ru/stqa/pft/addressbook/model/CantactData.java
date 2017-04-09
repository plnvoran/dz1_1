package ru.stqa.pft.addressbook.model;

public class CantactData {
    private  int id=0;
    private  String firstname;
    private  String lastname;
    private  String address;
    private  String homePhone;
    private  String mobilePhone;
    private  String workPhone;

    private  String home2Phone;

    private  String allPhones;
    private  String email;


    public String getAllPhones() {
        return allPhones;
    }

    public CantactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }





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



    @Override
    public String toString() {
        return "CantactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
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
}
