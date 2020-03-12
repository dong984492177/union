package com.dong.model;

public class ApplicationAndRoles extends  Application {

    public Roles roles;

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public ApplicationAndRoles() {
    }

    public ApplicationAndRoles(Roles roles) {
        this.roles = roles;
    }
}
