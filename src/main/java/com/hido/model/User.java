package com.hido.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "USERS")
public class User {

  private Long id;
  private String username;
  private String password;
  private String email;
  private boolean confirmedEmail;
  private Date joinDate;
  private String token;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  public Long getId() {
    return id;
  }

  @Column(name = "username", nullable = false)
  public String getUsername() {
    return username;
  }

  @Column(name = "password", nullable = false)
  public String getPassword() {
    return password;
  }

  @Column(name = "email", nullable = false)
  public String getEmail() {
    return email;
  }

  @Column(name = "confirmed_email", nullable = false)
  public boolean isConfirmedEmail() {
    return confirmedEmail;
  }

  @Column(name = "join_date", nullable = false)
  public Date getJoinDate() {
    return joinDate;
  }

  @Column(name = "token", nullable = false)
  public String getToken() {
    return token;
  }

  public void setId(Long id) {
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

  public void setConfirmedEmail(boolean confirmedEmail) {
    this.confirmedEmail = confirmedEmail;
  }

  public void setJoinDate(Date joinDate) {
    this.joinDate = joinDate;
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
    if (username != null ? !username.equals(user.username) : user.username != null) return false;
    if (password != null ? !password.equals(user.password) : user.password != null) return false;
    if (email != null ? !email.equals(user.email) : user.email != null) return false;
    if (joinDate != null ? !joinDate.equals(user.joinDate) : user.joinDate != null) return false;
    return token != null ? token.equals(user.token) : user.token == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (username != null ? username.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (confirmedEmail ? 1 : 0);
    result = 31 * result + (joinDate != null ? joinDate.hashCode() : 0);
    result = 31 * result + (token != null ? token.hashCode() : 0);
    return result;
  }
}
