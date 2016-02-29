package com.catchnote.springmvc.service;

import com.catchnote.springmvc.model.Note;
import com.catchnote.springmvc.model.User;

import java.util.List;

public interface NoteService {
    void addNote(Note note);
    void removeNote(Note note);
    void updateNote(Note note);
    Note getNoteById(int id);
    void removeNoteById(User user,int note_id);
    List<Note> getUserNotes(User user);
}
