/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import dataaccess.NoteDB;
import dataaccess.NotesDBException;
import domainmodel.Note;
import domainmodel.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 698437
 */
public class NoteService {
    
    private NoteDB noteDB;

    public NoteService() {
        noteDB = new NoteDB();
    }

    public Note get(int noteID) throws Exception {
        return noteDB.get(noteID);
    }

    public List<Note> getAll() throws Exception {
        return noteDB.getAll();
    }

    public int update(int noteID, String contents) throws NotesDBException{
        Note note = new Note(noteID,contents);
        return noteDB.update(note);
    }

    public int delete(int noteID) throws Exception {
        Note deletedNote = noteDB.get(noteID);
        return noteDB.delete(deletedNote);
    }

    public int insert(int noteID,Date dateCreated,String contents) throws Exception {
        Note note = new Note(noteID,dateCreated,contents);
        return noteDB.insert(note);
    }
    
}
