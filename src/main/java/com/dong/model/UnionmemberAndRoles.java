package com.dong.model;

public class UnionmemberAndRoles extends Unionmember {
    public Roles roles;

    public UnionmemberAndRoles(Roles roles) {
        this.roles = roles;
    }

    public UnionmemberAndRoles() {
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
