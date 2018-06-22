/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author artea
 */
public class tablabuses {
    
    public void mostrar_t(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class, new render());
        JButton btn1 = new JButton("Editar");
        btn1.setName("ed");
        JButton btn2 = new JButton("Horarios");
        btn1.setName("h");
        DefaultTableModel d = new DefaultTableModel(
            new Object[][] {{"Bus","90 F",btn1,btn2},{"Bus","90 F",btn1,btn2},{"Bus","90 FA",btn1,btn2},{"Bus","90 B",btn1,btn2},{"MicroBus","Ruta 2",btn1,btn2}},
            new Object[] {"TIPO","BUS","VIAJES","ACTUALIZACION","ACCIONES"}
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tabla.setModel(d);
        tabla.setRowHeight(23);
    }
}
