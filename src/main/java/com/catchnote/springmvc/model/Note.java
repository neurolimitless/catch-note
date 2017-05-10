package com.catchnote.springmvc.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NOTES")
public class Note {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "data")
  private String data;

  @Column(name = "adding_date")
  private Date date;

  public Note() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Note note = (Note) o;

    if (id != note.id) return false;
    if (name != null ? !name.equals(note.name) : note.name != null) return false;
    if (data != null ? !data.equals(note.data) : note.data != null) return false;
    return date != null ? date.equals(note.date) : note.date == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (data != null ? data.hashCode() : 0);
    result = 31 * result + (date != null ? date.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Note{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", data='" + data + '\'' +
        ", date=" + date +
        '}';
  }
}