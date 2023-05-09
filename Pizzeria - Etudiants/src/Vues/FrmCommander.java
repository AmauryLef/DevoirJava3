package Vues;

import Controlers.*;
import Entities.Pizza;
import Tools.ConnexionBDD;
import Tools.ModelJTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class FrmCommander extends JFrame{
    private JPanel pnlRoot;
    private JLabel lblTitre;
    private JLabel lblNumCommande;
    private JTextField txtNumCommande;
    private JLabel lblClients;
    private JComboBox cboClients;
    private JLabel lblLivreurs;
    private JTable tblPizzas;
    private JComboBox cboLivreurs;
    private JButton btnCommander;
    private CtrlPizza ctrlPizza;

    ModelJTable mdl;


    public FrmCommander() throws SQLException, ClassNotFoundException {
        this.setTitle("Commander");
        this.setContentPane(pnlRoot);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ConnexionBDD maCnx = new ConnexionBDD();

        // A vous de jouer

        ctrlPizza = new CtrlPizza();

        mdl = new ModelJTable();
        mdl.loadDatasPizzas(ctrlPizza.getAllPizzas());
        tblPizzas.setModel(mdl);

        cboClients.setModel();

        btnCommander.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(cboClients.toString().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un client");
                }
                else if(cboLivreurs.toString().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un livreur");
                }
                else {

                    if (tblPizzas.getSelectedRow()==0){
                        JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ou plusieurs pizzas");
                    } else if (tblPizzas.editCellAt(tblPizzas.getSelectedRow(),4)==false) {
                        JOptionPane.showMessageDialog(null, "Veuillez sélectionner une quantité");
                    }
                }
            }
        });
    }
}
