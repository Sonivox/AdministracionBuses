package clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author artea
 */
public class Buses {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
//        try {
//            UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Kgada");
//        }
        registro r = new registro();
        registro.txtpass.requestFocus();
        r.show();
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new registro().txtpass.requestFocus();
//                new registro().setVisible(true);
//                
//            }
//        });
    }    
}
