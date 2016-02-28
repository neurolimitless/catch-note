package com.catchnote.springmvc.service;

import com.catchnote.springmvc.dao.NoteDao;
import com.catchnote.springmvc.dao.UserDao;
import com.catchnote.springmvc.model.Note;
import com.catchnote.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.transaction.Transactional;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
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

    public void createAccessKey(Note note){
        try {
            Key key = new SecretKeySpec(note.getData().getBytes(),"AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(note.getData().getBytes());
            note.setAccessKey(new String(encrypted));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
    }

    public void removeNoteById(User user,int note_id) {
        noteDao.deleteNoteById(note_id);
    }

    public List<Note> getUserNotes(User user) {
        return noteDao.getNotesByUser(user);
    }
}
