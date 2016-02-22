package com.catchnote.springmvc.dao;

import com.catchnote.springmvc.model.Note;
import com.catchnote.springmvc.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository("noteDao")
public class NoteDaoImpl extends AbstractDao<Integer, Note> implements NoteDao {

    private EntityManager entityManager;

    public Note[] getAllNotesById(int id) {
        return new Note[0];
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
       entityManager.remove(note);
        getSession().getTransaction().commit();
    }

    public void addNote(Note note) {
        getSession().beginTransaction();
        persist(note);
        getSession().getTransaction().commit();
    }

    public void updateNote(Note note) {
        getSession().beginTransaction();
        entityManager.merge(note);
        getSession().getTransaction().commit();
    }
}
