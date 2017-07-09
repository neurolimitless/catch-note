package com.hido.model;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Roles")
public class Role implements Serializable {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private int id;
  @NotNull
  @NotEmpty
  @Size(max = 50)
  @Column(name = "name", length = 50)
  private String name;
  @OneToMany
  @JoinTable(name = "user_roles",
      joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
  )
  @ElementCollection(targetClass = Role.class)
  private Set<Role> userRoles;

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

  public Set<Role> getUserRoles() {
    return userRoles;
  }

  public void setUserRoles(Set<Role> userRoles) {
    this.userRoles = userRoles;
  }

  @Override
  public String toString() {
    return String.format("%s(id=%d, rolename='%s')",
        this.getClass().getSimpleName(),
        this.getId(), this.getName());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null)
      return false;

    if (o instanceof Role) {
      final Role other = (Role) o;
      return Objects.equal(getId(), other.getId())
          && Objects.equal(getName(), other.getName());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getId(), getName());
  }

}