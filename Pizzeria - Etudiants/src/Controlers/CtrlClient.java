package Controlers;

import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlClient
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlClient() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<String> getAllClients(int numClient)
    {
        ArrayList<String> lesClients = new ArrayList<>();

        try {
            ps = cnx.prepareStatement("SELECT nomCli FROM clients WHERE numcli= ?");
            ps.setInt(1, numClient);
            rs = ps.executeQuery();
            while (rs.next()) {

            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lesClients;
    }
    public int getIdClientByName(String nomCli)
    {
        int numCli = 0;

        try {
            ps = cnx.prepareStatement("SELECT numCli FROM clients WHERE nomcli= ?");
            ps.setString(1, nomCli);
            rs = ps.executeQuery();
            while (rs.next()) {

            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numCli;
    }
}
