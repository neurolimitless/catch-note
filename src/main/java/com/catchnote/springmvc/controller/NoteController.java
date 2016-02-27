package com.catchnote.springmvc.controller;

import com.catchnote.springmvc.model.Note;
import com.catchnote.springmvc.model.User;
import com.catchnote.springmvc.service.NoteService;
import com.catchnote.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@EnableTransactionManagement
@Transactional
@Controller
public class NoteController {

    @Autowired
    NoteService noteService;
    @Autowired
    UserService userService;

    @Transactional
    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String getNotes(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        if (request.getSession(false) != null && request.isRequestedSessionIdValid()) response.sendRedirect("/");
        System.out.println(request.getSession().getAttribute("user"));
        User user = (User) request.getSession().getAttribute("user");
        List<Note> notes = user.getUserNotes();
        model.addAttribute("notes", notes);
        return "notes";
    }

    @RequestMapping(value = "/newnote", method = RequestMethod.GET)
    public String model(ModelMap modelMap) {
        modelMap.addAttribute("note", new Note());
        return "/";
    }

    @RequestMapping(value = {"/delete-{note_id}-note"}, method = RequestMethod.GET)
    public String deleteNote(@PathVariable int note_id,ModelMap model, HttpServletRequest request) throws IOException {
        User sessionUser = (User) request.getSession().getAttribute("user");
        noteService.removeNoteById(sessionUser,note_id);
        userService.refresh(sessionUser);
        List<Note> list = sessionUser.getUserNotes();
        model.addAttribute("notes",list);
//        request.getSession().setAttribute("user",);
        return "redirect:/notes";
    }

    @RequestMapping(value = "/newnote", method = RequestMethod.POST)
    public String createNote(@RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "data", required = true) String data,
                             HttpServletResponse response,
                             ModelMap model,
                             HttpServletRequest request) throws IOException {
        System.out.println("qq");
        Note note = new Note();
        note.setName(name);
        note.setData(data);
        User sessionUser = (User) request.getSession().getAttribute("user");
        note.setUser(sessionUser);
        sessionUser.addNoteToList(note);
//        noteService.createAccessKey(note);
        System.out.println(note);

        noteService.addNote(note);
        model.addAttribute("note", new Note());
        response.sendRedirect("/main");
        return "/main";
    }

}
