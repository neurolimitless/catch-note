package com.catchnote.springmvc.service;

import com.catchnote.springmvc.dao.NoteDao;
import com.catchnote.springmvc.model.Note;
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

@Service("noteService")
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteDao noteDao;

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
       Note[] notes = noteDao.getAllNotesById(id);
        if (notes!=null && notes.length>0) return notes[0];
        else return null;
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
}
