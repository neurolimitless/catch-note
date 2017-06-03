package com.hido.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "NOTES")
public class Note implements Serializable {

  @Id
  @GeneratedValue
  private int id;
  @Column(name = "name")
  private String name;
  @Column(name = "data")
  private String data;
  @Column(name = "adding_date")
  private Date addingDate;

  @ManyToOne
  @JoinColumn(name = "author")
  private User author;

  public Note() {
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
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
