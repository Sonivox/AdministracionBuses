package clases;

import static clases.conectar.con;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author artea
 */
public class registro extends javax.swing.JFrame {
menu mm = new menu();
conectar cc = new conectar();
    /**
     * Creates new form registro
     */
    public registro() {
        initComponents();
        Transparencia();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        pin();
        id();
        lblid.hide();
        jPanel4.hide();
    }
    public void id(){
        int i=0, cantidad=100, rango=10000; 
        int arreglo[] = new int[cantidad];
        arreglo[i]=(int)(Math.random()*rango);
        for(i=1; i<cantidad; i++){
            arreglo[i]=(int)(Math.random()*rango);
            for(int j=0; j<i; j++){
                if(arreglo[i]==arreglo[j]){
                    i--;
                }   
            }
        }
        for(int k=0; k<cantidad; k++){
            int numero = arreglo[k];
            String num = String.valueOf(numero);
            lblid.setText(num);
        }
    }
    public void pin(){
        int i=0, cantidad=100, rango=10000; 
        int arreglo[] = new int[cantidad];
        arreglo[i]=(int)(Math.random()*rango);
        for(i=1; i<cantidad; i++){
            arreglo[i]=(int)(Math.random()*rango);
            for(int j=0; j<i; j++){
                if(arreglo[i]==arreglo[j]){
                    i--;
                }   
            }
        }
        for(int k=0; k<cantidad; k++){
            int numero = arreglo[k];
            String num = String.valueOf(numero);
            lblpin.setText(num);
        }
    }
    public boolean login(String clave) throws SQLException{
        String pin, tipo, nombre;
        boolean resultado = false;
        try{
        ResultSet rs;
        Statement st = con.createStatement();
        //select u.nombre from login l inner join usuario u on u.id_usuario = l.id_usuario where l.clave = "7064"
        //rs = st.executeQuery("select * from login where clave = " + clave);
        rs = st.executeQuery("select u.nombre, l.clave, l.tipo from login l inner join usuario u on u.id_usuario = l.id_usuario where l.clave = '" + clave + "'");
        if(rs.next()){
            nombre = rs.getString("u.nombre");
            pin = rs.getString("l.clave");
            tipo = rs.getString("l.tipo");
            if(pin.equals(clave)){
                DesktopNotify.showDesktopMessage("BIENVENIDO","Bienvenido " + nombre + " al sistema", DesktopNotify.SUCCESS,4000L);
                this.hide();
                mm.setVisible(true);
                resultado = true;
            }
        }
        else{
            DesktopNotify.showDesktopMessage("ERROR","Su Pin es Incorrecto\nIngreselo de nuevo\n\n¿Olvidó su PIN? CLick Aqui", DesktopNotify.ERROR,5000L, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    try {
                        String nombre = JOptionPane.showInputDialog("Ingrese su Nombre para encontrar su PIN: ");
                        ResultSet rs;
                        Statement st = con.createStatement();
                        //select l.clave from login l inner join usuario u on u.id_usuario = l.id_usuario where u.nombre = "Albery Arteaga Martinez"
                        rs = st.executeQuery("select l.clave from login l inner join usuario u on u.id_usuario = l.id_usuario where u.nombre = '" + nombre + "'");
                        if(rs.next()){
                            JOptionPane.showMessageDialog(null, nombre + " su PIN es: " + rs.getString("l.clave"));
                            txtpass.setText("");
                        }
                        else if(rs.next() == false){
                            JOptionPane.showMessageDialog(null, "Ingrese un nombre");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Ingrese su nombre Correctamente");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            //JOptionPane.showMessageDialog(null, "Clave Incorrecta");
            resultado = false;
            }
        }catch(Exception e){
            System.out.println("Error en login " + e.getMessage());
        }
        return resultado;
    }
    public void Transparencia(){
        btnsesion.setOpaque(false);
        btnsesion.setContentAreaFilled(false);
        btnsesion.setBorderPainted(false);
        
        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        
    }
    public void limpiar(){
        txtpass.setText("");
        jTextField1.setText("");
        pin();
        id();
        txtpass.requestFocus();
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblid = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblpin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtpass = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        btnsesion = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buses/inten.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblid.setText("jLabel1");
        jPanel1.add(lblid, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(102, 0, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("REGISTRARSE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 220, 40));

        jTextField1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 19)); // NOI18N
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 380, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 20)); // NOI18N
        jLabel4.setText("NOMBRE");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 20)); // NOI18N
        jLabel5.setText("SU PIN:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

        lblpin.setFont(new java.awt.Font("Segoe UI Symbol", 1, 20)); // NOI18N
        jPanel4.add(lblpin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 180, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 640, 380));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 790, 490));

        jPanel2.setBackground(new java.awt.Color(102, 0, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtpass.setBackground(new java.awt.Color(102, 0, 102));
        txtpass.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtpass.setForeground(new java.awt.Color(255, 255, 255));
        txtpass.setBorder(null);
        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });
        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpassKeyTyped(evt);
            }
        });
        jPanel2.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 200, 30));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 240, 20));

        btnsesion.setBackground(new java.awt.Color(255, 51, 51));
        btnsesion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnsesion.setForeground(new java.awt.Color(255, 255, 255));
        btnsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buses/button(16).png"))); // NOI18N
        btnsesion.setBorder(null);
        btnsesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsesion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/buses/button(s16).png"))); // NOI18N
        btnsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsesionActionPerformed(evt);
            }
        });
        jPanel2.add(btnsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 210, 60));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buses/button(16)_1.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/buses/button(17).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 110, 50));

        jButton3.setBackground(new java.awt.Color(29, 206, 135));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Registrarse");
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 210, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 260, 490));

        jPanel3.setBackground(new java.awt.Color(102, 0, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(102, 0, 102));
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 160));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 160));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassActionPerformed

    private void txtpassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyTyped
        char tecla  = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER) {
             btnsesion.doClick();
        }
        char validacion = evt.getKeyChar();
        if(Character.isLetter(validacion)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "El pin solo contiene numeros");
        }
    }//GEN-LAST:event_txtpassKeyTyped

    private void btnsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsesionActionPerformed
    try {
        login(txtpass.getText());
    } catch (SQLException ex) {
        Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnsesionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int pin = Integer.parseInt(lblpin.getText());
        int id = Integer.parseInt(lblid.getText());
        try {
            cc.insertUsuario(id, jTextField1.getText());
            cc.insertLogin(id, pin, "Usuario");
            limpiar();
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jPanel4.show();
        jTextField1.requestFocus();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsesion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblpin;
    public static javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables
}
