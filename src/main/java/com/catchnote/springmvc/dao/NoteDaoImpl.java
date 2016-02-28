package com.catchnote.springmvc.dao;

import com.catchnote.springmvc.model.Note;
import com.catchnote.springmvc.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("noteDao")
public class NoteDaoImpl extends AbstractDao<Integer, Note> implements NoteDao {

    public Note getNoteById(int id){
        getSession().beginTransaction();
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("note_id",id));
        Note note = (Note) criteria.uniqueResult();
        getSession().getTransaction().commit();
        return note;
    }

    public List<Note> getNotesByUser(User user) {
        getSession().beginTransaction();
        Criteria criteria = createEntityCriteria();
//        criteria.add(Restrictions.eq("id",));
        List<Note> notes = (List<Note>) criteria.list();
        getSession().getTransaction().commit();
        return notes;
    }

    public Note[] getAllNotesByUsername(String username) {
        return new Note[0];
    }

//    public Note[] getAllNotesByUsename(String username) {
//        getSession().beginTransaction();
//        Criteria criteria = createEntityCriteria();
//        criteria.add(Restrictions.eq("owner"))
//        List<Note> notes = (List<Note>) criteria.list();
//        getSession().getTransaction().commit();
//    }

    public void deleteNote(Note note) {
        getSession().beginTransaction();
       delete(note);
        getSession().getTransaction().commit();
    }

    public void addNote(Note note) {
        getSession().beginTransaction();
        persist(note);
        getSession().getTransaction().commit();
    }

    public void updateNote(Note note) {
        getSession().beginTransaction();
        getSession().merge(note);
        getSession().getTransaction().commit();
    }

    public void deleteNoteById(int note_id) {
        getSession().beginTransaction();
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("note_id", note_id));
        Note note = (Note) criteria.uniqueResult();
        delete(note);
        getSession().getTransaction().commit();
    }
}
