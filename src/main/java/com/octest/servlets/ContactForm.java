package com.octest.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;
import com.octest.beans.Utilisateur;


/**
 * Servlet implementation class Test
 */
@WebServlet("/contactForm")
public class ContactForm extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
       
    public ContactForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/contactForm.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNum(Integer.parseInt(request.getParameter("num")) );
        utilisateur.setName(request.getParameter("name"));
        utilisateur.setAddress(request.getParameter("address"));
        utilisateur.setPhone(request.getParameter("phone"));
        
        Noms tableNoms = new Noms();
        tableNoms.ajouterUtilisateur(utilisateur);
        
        request.setAttribute("utilisateurs", tableNoms.recupererUtilisateurs());
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/addContact.jsp").forward(request, response);
    }
    
    

}