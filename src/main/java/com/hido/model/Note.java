package com.hido.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "NOTES")
public class Note {

  @Id
  @GeneratedValue
  private int id;
  @JoinColumn(name = "name")
  private String name;
  @JoinColumn(name = "data")
  private String data;
  @JoinColumn(name = "adding_date")
  private Date addingDate;

  public Note() {
  }

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

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Date getAddingDate() {
    return addingDate;
  }

  public void setAddingDate(Date addingDate) {
    this.addingDate = addingDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Note note = (Note) o;

    return id == note.id;
  }

  @Override
  public int hashCode() {
    return id;
  }
}
