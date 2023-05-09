package Controlers;

import Tools.ConnexionBDD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlCommande
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlCommande() {
        cnx = ConnexionBDD.getCnx();
    }

    public int getDernierNumeroDeCommande() {
        int maxNumero = 0;

       try {
            ps = cnx.prepareStatement("SELECT MAX(numCde) FROM commandes ");
            ps.setInt(maxNumero, 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                maxNumero++;
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maxNumero;
    }

    public void InsertConsultation(int numCde, int numClient,int numLivreur)
    {
        if (numCde!=0)
        {
            JOptionPane.showMessageDialog(null,"Client: " +numClient + " \n" + "Livreur: " + numLivreur + " \n" /*+ "Commande: " + numClient + " \n" */);
        } else if (numClient !=0) {
            JOptionPane.showMessageDialog(null,"Commande: " +numCde + " \n" + "Livreur: " + numLivreur + " \n" );
        }
        else if (numLivreur !=0) {
            JOptionPane.showMessageDialog(null,"Commande: " +numCde + " \n" + "Client: " + numClient + " \n" );
        }


    }
}

