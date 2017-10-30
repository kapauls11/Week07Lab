/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import dataaccess.NoteDB;
import dataaccess.NotesDBException;
import domainmodel.Note;
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

     public int delete(Long noteID) throws Exception{
        Note deletedNote = noteDB.getNote(noteID);
        return noteDB.delete(deletedNote);
    }


    public int insert(String contents) throws Exception {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Note note = new Note(0, sqlDate, contents);
        return noteDB.insert(note);
    }
    
}
