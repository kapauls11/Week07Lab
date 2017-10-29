/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author 698437
 */
public class Note implements Serializable {

    private int noteID;
    private Date dateCreated;
    private String contents;

    public Note() {

    }

    public Note(int noteID, Date dateCreated,String contents) {
        this.noteID=noteID;
        this.dateCreated=dateCreated;
        this.contents=contents;
    }
    public Note(int noteID, String contents) {
        this.noteID=noteID;
        this.contents=contents;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
