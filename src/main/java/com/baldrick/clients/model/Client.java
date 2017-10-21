package com.baldrick.clients.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "client_details")
public class Client {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Long dateOfBirth;
    private Long dateJoined;
    private Double balance;

    public Client(String id, String username, String password, String email, String firstName, String lastName,
                Long dateOfBirth, Long dateJoined, Double balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateJoined = dateJoined;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getDateOfBirth() {
        return dateOfBirth;
    }

    public Long getDateJoined() {
        return dateJoined;
    }

    public Double getBalance() {
        return balance;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateJoined(Long dateJoined) {
        this.dateJoined = dateJoined;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
