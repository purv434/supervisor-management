package com.supervisormanagement.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class NotificationRequestDTO {
    @NotBlank(message = "supervisor must be required!!")
    private String supervisor;

    @Pattern(regexp="(^$|[0-9]{10})",message = "please add valid phone number")
    private String phoneNumber;

    @Pattern(regexp = "(^$|^.*@.*\\..*$)" ,message = "please add valid email id")
    private String email;

    @NotBlank(message = "firstName must be required!!")
    @Pattern(regexp = "[a-zA-Z]*",message = "firstName only contain letter")
    private String firstName;

    @NotBlank(message = "lastName must be required!!")
    @Pattern(regexp = "[a-zA-Z]*",message = "lastName only contain letter")
    private String lastName;

    @Override
    public String toString() {
        return "NotificationRequestDTO{" +
                "supervisor='" + supervisor + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public NotificationRequestDTO() {
    }

    public NotificationRequestDTO(String supervisor, String phoneNumber, String email, String firstName, String lastName) {
        this.supervisor = supervisor;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
