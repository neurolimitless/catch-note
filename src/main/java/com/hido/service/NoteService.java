package com.hido.service;

import com.hido.model.Note;
import com.hido.repo.NoteServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("noteService")
public class NoteService {

  @Autowired
  NoteServiceDao dao;

  public Iterable<Note> getAll() {
    return dao.findAll();
  }

  public Note getNoteById(int id) {
    return dao.findById(id);
  }

  public Note save(Note note) {
    return dao.save(note);
  }
}
