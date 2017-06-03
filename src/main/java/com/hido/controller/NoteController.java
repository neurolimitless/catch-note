package com.hido.controller;

import com.hido.model.Note;
import com.hido.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@RequestMapping("/notes")
public class NoteController {

  @Autowired
  NoteService noteService;

  @RequestMapping("/{id}")
  public Note findNoteById(@PathVariable int id) {
    return noteService.getNoteById(id);
  }

  @RequestMapping("/all")
  public Iterable<Note> findAll() {
    return noteService.getAll();
  }

}
