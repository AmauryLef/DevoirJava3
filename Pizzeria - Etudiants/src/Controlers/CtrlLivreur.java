package Controlers;

import Entities.Pizza;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlLivreur
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlLivreur() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<String> getAllLivreurs()
    {
        ArrayList<String> lesLivreurs = new ArrayList<>();

        try {
            ps = cnx.prepareStatement("SELECT * FROM livreurs WHERE numLiv = ?");
            rs = ps.executeQuery();
            while (rs.next()) {

            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlPizza.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lesLivreurs;
    }
    public int getIdLivreurByName(String nomLiv)
    {
        int numLiv = 0;

        // A vous de jouer
        try {
            ps = cnx.prepareStatement("SELECT nomLiv FROM livreurs WHERE numLiv =");
            ps.setString(1, nomLiv);
            rs = ps.executeQuery();
            while (rs.next()) {

            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlLivreur.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numLiv;
    }
}
