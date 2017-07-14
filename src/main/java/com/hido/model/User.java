package com.hido.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;
import com.hido.serializers.CustomDateSerializer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User implements Serializable, UserDetails {

  private Long id;
  private String name;
  private String password;
  private String email;
  private boolean confirmedEmail;
  private Date joinDate;
  @JsonIgnore
  private List<Note> noteList;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "role")
  private Roles role;

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

  @Override
  @Transient
  public String getUsername() {
    return name;
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

  @Column(name = "join_date")
  @JsonSerialize(using = CustomDateSerializer.class)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(Date joinDate) {
    this.joinDate = joinDate;
  }

  @Override
  @JsonIgnore
  @Transient
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> authorities = new ArrayList<>();
    Roles userRoles = this.getRole();
    if (userRoles != null) {
      SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRoles.toString());
      authorities.add(authority);
    }
    return authorities;
  }

  @Transient
  @Override
  @JsonIgnore
  public boolean isAccountNonExpired() {
    return true;
  }

  @Transient
  @Override
  @JsonIgnore
  public boolean isAccountNonLocked() {
    return true;
  }

  @Transient
  @Override
  @JsonIgnore
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Transient
  @Override
  @JsonIgnore
  public boolean isEnabled() {
    return true;
  }

  @Transient
  @Override
  @JsonIgnore
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null)
      return false;

    if (o instanceof User) {
      final User other = (User) o;
      return Objects.equal(getId(), other.getId())
          && Objects.equal(getUsername(), other.getUsername())
          && Objects.equal(getPassword(), other.getPassword())
          && Objects.equal(getRole().toString(), other.getRole().toString())
          && Objects.equal(isEnabled(), other.isEnabled());
    }
    return false;
  }

  public Roles getRole() {
    return role;
  }

  public void setRole(Roles role) {
    this.role = role;
  }

  @Transient
  @Override
  public int hashCode() {
    return Objects.hashCode(getId(), getUsername(), getPassword(), getRole().toString(), isEnabled());
  }


}
