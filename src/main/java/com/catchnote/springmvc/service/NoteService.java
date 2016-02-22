package com.catchnote.springmvc.service;

import com.catchnote.springmvc.model.Note;

public interface NoteService {
    void addNote(Note note);
    void removeNote(Note note);
    void updateNote(Note note);
    Note getNoteById(int id);
    void createAccessKey(Note note);
}
