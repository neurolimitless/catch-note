package com.hido.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hido.serializers.CustomDateSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "NOTES")
public class Note implements Serializable {

  private int id;

  private String name;

  private String data;

  private Date addingDate;

  private User author;

  public Note() {
  }

  @Id
  @GeneratedValue
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @ManyToOne
  @JoinColumn(name = "author")
  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  @Column(name = "data")
  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  @Column(name = "adding_date")
  @JsonSerialize(using = CustomDateSerializer.class)
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
