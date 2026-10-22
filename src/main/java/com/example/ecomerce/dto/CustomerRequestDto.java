package com.example.ecomerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerRequestDto {

    @NotBlank(message = "el campo firstName es obligatorio")
    @Size(min=4)
    private String firstName;
    @NotBlank
    @Size(min=2)
    private String lastName;
    @NotBlank
    @Email
    private String email;
    @Size(min=8)
    private String phone;

    private AddressDto address;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AddressDto getAddress() {
        return address;
    }
    public void setAddress(AddressDto addressDto) {
        this.address = addressDto;
    }
}
