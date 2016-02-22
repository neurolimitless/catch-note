package com.catchnote.springmvc.controller;

import com.catchnote.springmvc.model.Note;
import com.catchnote.springmvc.model.User;
import com.catchnote.springmvc.service.NoteService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Set;

@EnableTransactionManagement
@Transactional
@Controller
public class NoteController {

    @Autowired
    NoteService noteService;

    @Transactional
    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String getNotes(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        if (request.getSession(false) != null && request.isRequestedSessionIdValid()) response.sendRedirect("/");
        System.out.println(request.getSession().getAttribute("user"));
            User user = (User) request.getSession().getAttribute("user");
        Set<Note> notes = user.getUserNotes();
        model.addAttribute("notes", notes);
        return "notes";
    }
    @RequestMapping(value = "/newnote",method = RequestMethod.GET)
    public String model(ModelMap modelMap){
        modelMap.addAttribute("note",new Note());
        return "/";
    }

    @RequestMapping(value = "/newnote",method = RequestMethod.POST)
    public String createNote(@RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "data", required = true) String data,
                                HttpServletResponse response,
                             HttpServletRequest request) throws IOException {
        System.out.println("qq");
        Note note = new Note();
        note.setName(name);
        note.setData(data);
        note.setUser((User)request.getSession().getAttribute("user"));
//        noteService.createAccessKey(note);
        System.out.println(note);
        noteService.addNote(note);
        response.sendRedirect("/");
        return "";
    }

}
