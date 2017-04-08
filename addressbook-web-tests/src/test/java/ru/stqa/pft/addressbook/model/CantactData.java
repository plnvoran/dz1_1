package ru.stqa.pft.addressbook.model;

public class CantactData {
    private  int id=0;
    private  String firstname;
    private  String lastname;
    private  String address;
    private  String phone;
    private  String email;


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

    public CantactData withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public CantactData withEmail(String email) {
        this.email = email;
        return this;
    }




    @Override
    public String toString() {
        return "CantactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CantactData that = (CantactData) o;

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
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

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
}
