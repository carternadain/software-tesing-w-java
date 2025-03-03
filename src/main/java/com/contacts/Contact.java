package com.contacts;

import java.util.HashMap;
import java.util.Map;

// Contact class
public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID cannot be null or longer than 10 characters");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First Name cannot be null or longer than 10 characters");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last Name cannot be null or longer than 10 characters");
        }
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be null or longer than 30 characters");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters with validation
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First Name cannot be null or longer than 10 characters");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last Name cannot be null or longer than 10 characters");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be null or longer than 30 characters");
        }
        this.address = address;
    }
}
