/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import businesslogic.NoteService;
import domainmodel.Note;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 698437
 */
public class NoteServlet extends HttpServlet {
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         NoteService ns = new NoteService();
        String action = request.getParameter("action");
        if (action != null && action.equals("view")) {
            String selectedUsername = request.getParameter("selectedUsername");
            try {
                Note note = ns.get(Integer.parseInt((selectedUsername)));
                request.setAttribute("selectedUser", note);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ArrayList<Note> notes = null;        
        try {
            notes= (ArrayList<Note>) ns.getAll();
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("notes", notes);
        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        String action = request.getParameter("action");
        String noteID = request.getParameter("noteID");
        String dateCreated = request.getParameter("dateCreated");
        String contents = request.getParameter("contents");
        int noteID1=Integer.parseInt(noteID);
        try {
        Date date = in.parse(dateCreated);
        NoteService ns = new NoteService();

            if (action.equals("delete")) {
                ns.delete(noteID1);
            } else if (action.equals("edit")) {
                ns.update(noteID1,contents);
            } else if (action.equals("add")) {
                ns.insert(noteID1,date,contents);
            }
        
        ArrayList<Note> notes = null;
        notes = (ArrayList<Note>) ns.getAll();
        request.setAttribute("notes", notes);
        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);
        }
        catch(Exception e){
           e.printStackTrace(); 
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
