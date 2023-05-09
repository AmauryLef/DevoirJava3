package Controlers;

import Tools.ConnexionBDD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlLigneCommande
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlLigneCommande() {
        cnx = ConnexionBDD.getCnx();
    }

    public void InsertLigneCommande(int numCommande, String numPizza,int quantite)
    {
        numCommande=0;
        //ps = cnx.prepareStatement("")
        //if (.getSelectedRow()==0){
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ou plusieurs pizzas");
        }

    }

