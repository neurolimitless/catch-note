package com.hido.repo;

import com.hido.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteServiceDao extends JpaRepository<Note, Long> {

  @Override
  List<Note> findAll();

  Note findById(int id);

  Note save(Note note);

}
