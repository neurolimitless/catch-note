package com.catchnote.springmvc.model;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Note {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "note_id")
    private int note_id;
    @Column(name = "data")
    private String data;
    @Column(name = "name")
    private String name;
    @Column(name = "access_key")
    private String accessKey;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Note() {
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
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

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (note_id != note.note_id) return false;
        if (data != null ? !data.equals(note.data) : note.data != null) return false;
        if (name != null ? !name.equals(note.name) : note.name != null) return false;
        if (accessKey != null ? !accessKey.equals(note.accessKey) : note.accessKey != null) return false;
        return !(user != null ? !user.equals(note.user) : note.user != null);

    }

    @Override
    public int hashCode() {
        int result = note_id;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (accessKey != null ? accessKey.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
                "note_id=" + note_id +
                ", data='" + data + '\'' +
                ", name='" + name + '\'' +
                ", accessKey='" + accessKey + '\'' +
                ", user=" + user +
                '}';
    }
}