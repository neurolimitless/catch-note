package com.catchnote.springmvc.service;

import com.catchnote.springmvc.dao.NoteDao;
import com.catchnote.springmvc.dao.UserDao;
import com.catchnote.springmvc.model.Note;
import com.catchnote.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("noteService")
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteDao noteDao;

    @Autowired
    UserDao userDao;

    @Transactional
    public void addNote(Note note) {
        noteDao.addNote(note);
    }

    public void removeNote(Note note) {
        noteDao.deleteNote(note);
    }

    public void updateNote(Note note) {
        noteDao.updateNote(note);

    }

    public Note getNoteById(int id) {
      return noteDao.getNoteById(id);
    }



    public void removeNoteById(User user,int note_id) {
        noteDao.deleteNoteById(note_id);
    }

    public List<Note> getUserNotes(User user) {
        return noteDao.getNotesByUser(user);
    }


}
