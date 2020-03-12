package com.dong.model;

public class UnionmemberAndRoles extends Unionmember {
    public Roles roles;
    public Position position;

    public UnionmemberAndRoles(Roles roles, Position position) {
        this.roles = roles;
        this.position = position;
    }

    public UnionmemberAndRoles(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

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
