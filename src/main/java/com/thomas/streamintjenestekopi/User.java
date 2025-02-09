package com.thomas.streamintjenestekopi;

public class User {

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String subscriptionType;

    public User(int userId, String firstName, String lastName, String email, String subscriptionType){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.subscriptionType = subscriptionType;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }
    @Override
    public String toString() {
        return ("Id: " + userId + " First Name: " + firstName + " Last Name: " + lastName + " Email: " + email + " Subscription Type: " + subscriptionType);
    }
}