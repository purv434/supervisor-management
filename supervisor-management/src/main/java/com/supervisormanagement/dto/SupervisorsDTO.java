package com.supervisormanagement.dto;

public class SupervisorsDTO {

    private Long id;

    private String phone;

    private String jurisdiction;

    private String identificationNumber;

    private String firstName;

    private String lastName;

    @Override
    public String toString() {
        return "SupervisorsDTO{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", jurisdiction='" + jurisdiction + '\'' +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SupervisorsDTO() {
    }

    public SupervisorsDTO(Long id, String phone, String jurisdiction, String identificationNumber, String firstName, String lastName) {
        this.id = id;
        this.phone = phone;
        this.jurisdiction = jurisdiction;
        this.identificationNumber = identificationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
