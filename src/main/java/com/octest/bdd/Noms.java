package com.octest.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.Utilisateur;

public class Noms {
    private Connection connexion;
    
    public List<Utilisateur> recupererUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        Statement statement = null;
        ResultSet resultat = null;
        loadDatabase();
        try {
            statement = connexion.createStatement();
            // Exécution de la requête
            resultat = statement.executeQuery("SELECT num,name,address,phone FROM contact;");
            // Récupération des données
            while (resultat.next()) {
            	int num = resultat.getInt("num");
            	String name = resultat.getString("name");
                String address = resultat.getString("address");
                String phone = resultat.getString("phone");
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setNum(num);
                utilisateur.setAddress(address);
                utilisateur.setName(name);
                utilisateur.setPhone(phone);
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            } } return utilisateurs;
    }
    
    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }
        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();    }    }
    
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        loadDatabase();        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO contact(num,name,address,phone) VALUES(?, ?, ?, ?);");
            preparedStatement.setInt(1, utilisateur.getNum());
            preparedStatement.setString(2, utilisateur.getName());
            preparedStatement.setString(3, utilisateur.getAddress());
            preparedStatement.setString(4, utilisateur.getPhone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}