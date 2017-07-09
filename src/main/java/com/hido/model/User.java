package com.hido.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hido.serializers.CustomDateSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

  private Long id;
  private String name;
  private String password;
  private String email;
  private boolean confirmedEmail;
  private Date joinDate;
  private String token;
  @JsonIgnore
  private List<Note> noteList;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = CascadeType.ALL)
  public List<Note> getNoteList() {
    return noteList;
  }

  public void setNoteList(List<Note> noteList) {
    this.noteList = noteList;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "name", nullable = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "password", nullable = false)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Column(name = "email", nullable = false)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column(name = "confirmed_email", nullable = false)
  public boolean isConfirmedEmail() {
    return confirmedEmail;
  }

  public void setConfirmedEmail(boolean confirmedEmail) {
    this.confirmedEmail = confirmedEmail;
  }

  @Column(name = "join_date", nullable = false)
  @JsonSerialize(using = CustomDateSerializer.class)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(Date joinDate) {
    this.joinDate = joinDate;
  }

  @Column(name = "token", nullable = false)
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    if (confirmedEmail != user.confirmedEmail) return false;
    if (id != null ? !id.equals(user.id) : user.id != null) return false;
    if (name != null ? !name.equals(user.name) : user.name != null) return false;
    if (password != null ? !password.equals(user.password) : user.password != null) return false;
    if (email != null ? !email.equals(user.email) : user.email != null) return false;
    if (joinDate != null ? !joinDate.equals(user.joinDate) : user.joinDate != null) return false;
    if (token != null ? !token.equals(user.token) : user.token != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (confirmedEmail ? 1 : 0);
    result = 31 * result + (joinDate != null ? joinDate.hashCode() : 0);
    result = 31 * result + (token != null ? token.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Name: " + name + ", email: " + email + "";
  }
}
