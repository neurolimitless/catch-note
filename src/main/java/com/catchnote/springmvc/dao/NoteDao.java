package com.catchnote.springmvc.dao;

import com.catchnote.springmvc.model.Note;
import com.catchnote.springmvc.model.User;

import java.util.List;

public interface NoteDao {
    Note getNoteById(int id);
    public List<Note> getNotesByUser(User user);
    public void deleteNote(Note note);
    public void addNote(Note note);
    public void updateNote(Note note);
    void deleteNoteById(int id);
}
