package com.catchnote.springmvc.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    public User() {

    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Note> userNotes = new ArrayList<Note>();

    @Column(name = "token")
    private int token;

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    @Column(name = "raw_pass")
    private String rawPass;

    public String getRawPass() {
        return rawPass;
    }

    public void setRawPass(String rawPass) {
        this.rawPass = rawPass;
    }

    public void addNoteToList(Note note) {
        userNotes.add(note);
    }

    public void removeNoteFromList(Note note) {
        userNotes.remove(note);
    }

    public void removeNoteFromListById(int id) {
        synchronized (userNotes) {
            for (Note userNote : userNotes) {
                if (userNote.getNote_id() == id) userNotes.remove(userNote);
            }
        }
    }

    public List<Note> getUserNotes() {
        return userNotes;
    }

    public void setUserNotes(ArrayList<Note> userNotes) {
        this.userNotes = userNotes;
    }

    @Size(min = 3, max = 16)
    @Pattern(message = "please, enter a valid username", regexp = "^[A-Za-z0-9_-]{3,16}$")
    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "valid")
    private int valid;

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (rawPass != null ? !rawPass.equals(user.rawPass) : user.rawPass != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (pass != null ? !pass.equals(user.pass) : user.pass != null) return false;
        return email != null ? email.equals(user.email) : user.email == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 30 * result + (rawPass != null ? rawPass.hashCode() : 0);
        result = 29 * result + (name != null ? name.hashCode() : 0);
        result = 28 * result + (pass != null ? pass.hashCode() : 0);
        result = 27 * result + (email != null ? email.hashCode() : 0);
        return result;
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