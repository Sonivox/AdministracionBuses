package clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static clases.conectar.con;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author artea
 */
public class paradas extends javax.swing.JPanel {
private ArrayList<JPanel> paneles = new ArrayList<JPanel>();
private ArrayList<Object> panele = new ArrayList<Object>();
JLabel label = new JLabel();
conec2 c2 = new conec2();
conectar cc = new conectar();
Connection cn = c2.conexion();
DefaultTableModel modelo1;
int contador =1;
    /**
     * Creates new form paradas
     */
    
    public paradas() {
        initComponents();
        boton.hide();
    try {
        mparadas();
    } catch (SQLException ex) {
        Logger.getLogger(paradas.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

//    public void agregar() throws SQLException{
//        JPanel panel = new JPanel();
//        label = new JLabel(txtparada.getText());
//        //c2.insertParada(txtparada.getText());
//        cc.insertParada(txtparada.getText());
//        jPanel2.add(panel);
//        paneles.add(panel);
//        panel.setBackground(Color.BLACK);
//        label.setForeground(Color.WHITE);
//        panel.add(label);
//        jPanel2.updateUI();       
//        txtparada.setText("");
//    }
        public  void mparadas() throws SQLException{
        String [] titulos={"N°","PARADAS"};
        String [] w = new String[2];
        String sql = "select * from paradas";
         modelo1 = new DefaultTableModel(null,titulos);
        
         try {
              Statement st = con.createStatement();
              ResultSet rs = st.executeQuery(sql);
              while (rs.next()){
                  contador++;
                  w[0]=String.valueOf(contador);
                  w[1]=rs.getString("nombre");
                  modelo1.addRow(w);
              }
              t_paradas.setModel(modelo1);
              
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e);
         } 
    }
        
        public  void agg_ultimaParada() throws SQLException{
        String [] titulos={"N°","PARADAS"};
        String [] w = new String[2];
         modelo1 = (DefaultTableModel) t_paradas.getModel();
                  w[0]="1";
                  w[1]=txtparada.getText();
                  modelo1.addRow(w);
                  t_paradas.setModel(modelo1);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        txtparada = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_paradas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        boton = new javax.swing.JButton();

        jPopupMenu1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setText("jLabel2");

        jButton1.setText("jButton1");

        setPreferredSize(new java.awt.Dimension(0, 418));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setComponentPopupMenu(jPopupMenu3);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtparada.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtparada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtparadaActionPerformed(evt);
            }
        });
        txtparada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtparadaKeyTyped(evt);
            }
        });
        jPanel1.add(txtparada, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 220, -1));

        t_paradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "PARADA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(t_paradas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 460, 230));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("NOMBRE DE PARADA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, -1));

        boton.setText("jButton1");
        boton.setComponentPopupMenu(jPopupMenu1);
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMouseClicked(evt);
            }
        });
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });
        jPanel1.add(boton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 740));
    }// </editor-fold>//GEN-END:initComponents

    private void txtparadaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtparadaKeyTyped
        char tecla  = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER) {
              boton.doClick();
          }
        
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad = (""+c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtparadaKeyTyped

    private void txtparadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtparadaActionPerformed

    }//GEN-LAST:event_txtparadaActionPerformed

    private void botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActionPerformed
    try {
        contador ++;
        cc.insertParada(txtparada.getText());
        agg_ultimaParada();
        txtparada.setText("");
        txtparada.requestFocus();
    } catch (SQLException ex) {
        Logger.getLogger(paradas.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_botonActionPerformed

    private void botonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMouseClicked
//        MouseEvent eventoMouse=new MouseEvent(boton, 0, evt.getWhen(), KeyEvent.VK_UNDEFINED, 0,jPanel1.getY()+boton.getY() , 1, true);
//        checkPopup(eventoMouse);
    }//GEN-LAST:event_botonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_paradas;
    public static javax.swing.JTextField txtparada;
    // End of variables declaration//GEN-END:variables
}
