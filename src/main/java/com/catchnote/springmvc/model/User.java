package com.catchnote.springmvc.model;

import org.hibernate.validator.constraints.Email;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {

    public User() {

    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

   @OneToMany(mappedBy = "user")
    private Set<Note> userNotes = new HashSet<Note>(0);

    public Set<Note> getUserNotes() {
        return userNotes;
    }

    public void setUserNotes(Set<Note> userNotes) {
        this.userNotes = userNotes;
    }

    @Size(min = 3, max = 16)
    @Pattern(message = "please, enter a valid username", regexp = "^[A-Za-z0-9_-]{3,16}$")
    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

//    @NotNull
//    @Column(name = "JOINING_DATE", nullable = false)
//    private String joiningDate;

    @NotNull
    @Size(min = 6, max = 64)
    @Column(name = "PASS", nullable = false)
    private String pass;

    @NotNull
    @Email
    @Column(name = "EMAIL", unique = true)
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getJoiningDate() {
//        return joiningDate;
//    }
//
//    public void setJoiningDate(String joiningDate) {
//        this.joiningDate = joiningDate;
//    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (id != other.id)
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}