package br.senac.sp.authorization.core.domain;

public class UserDomain {

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public UserDomain setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

}
