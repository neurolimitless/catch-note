package com.catchnote.springmvc.dao;

import com.catchnote.springmvc.model.Note;

public interface NoteDao {
    public Note[] getAllNotesById(int id);
    public Note[] getAllNotesByUsername(String username);
    public void deleteNote(Note note);
    public void addNote(Note note);
    public void updateNote(Note note);

}
