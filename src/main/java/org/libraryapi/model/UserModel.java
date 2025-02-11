package org.libraryapi.model;

import org.springframework.hateoas.RepresentationModel;

public class UserModel extends RepresentationModel<UserModel> {
    private String username;
    private String email;
    private String name;
    private String surname;

    protected UserModel() {}

    public UserModel(String username, String email, String name, String surname) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


}
