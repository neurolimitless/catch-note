package com.hido.dao;

import com.hido.model.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteServiceDao extends CrudRepository<Note, Long> {

  @Override
  Iterable<Note> findAll();

  Note findById(int id);

}
