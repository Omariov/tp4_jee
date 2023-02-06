package com.octest.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;


/**
 * Servlet implementation class Test
 */
@WebServlet("/addContact")
public class AddContact extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
       
    public AddContact() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Noms tableNoms = new Noms();
        request.setAttribute("utilisateurs", tableNoms.recupererUtilisateurs());
        this.getServletContext().getRequestDispatcher("/WEB-INF/addContact.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
      
    }
    
    

}