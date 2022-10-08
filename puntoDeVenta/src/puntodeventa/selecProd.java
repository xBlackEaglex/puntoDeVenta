/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package puntodeventa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Iddot
 */
public class selecProd extends javax.swing.JInternalFrame {

    /**
     * Creates new form selecProv
     */
    public selecProd() {
        initComponents();

        cargarTabla1();

        
    }
    
    
    String idProd = "";
    String descrip = "";
    String cost = "";
    String prec = "";
    String exist = "";
    String idProv = "";
    public static int idProdN = 0;
    public static float costN = 0;
    public static float precN = 0;
    public static float existN = 0;
    public static int idProvN = 0;
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("SELECCIONA UN PRODUCTO");

        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Descripción", "Costo", "Precio", "Existencia", "Id Proveedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProducto);
        if (tablaProducto.getColumnModel().getColumnCount() > 0) {
            tablaProducto.getColumnModel().getColumn(0).setResizable(false);
            tablaProducto.getColumnModel().getColumn(1).setResizable(false);
            tablaProducto.getColumnModel().getColumn(2).setResizable(false);
            tablaProducto.getColumnModel().getColumn(3).setResizable(false);
            tablaProducto.getColumnModel().getColumn(4).setResizable(false);
            tablaProducto.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salidaText.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(152, 152, 152))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductoMouseClicked
        // TODO add your handling code here:
        
        
        idProd = tablaProducto.getValueAt(tablaProducto.getSelectedRow(), 0).toString();
        descrip = tablaProducto.getValueAt(tablaProducto.getSelectedRow(), 1).toString();
        cost = tablaProducto.getValueAt(tablaProducto.getSelectedRow(), 2).toString();
        prec = tablaProducto.getValueAt(tablaProducto.getSelectedRow(), 3).toString();
        exist = tablaProducto.getValueAt(tablaProducto.getSelectedRow(), 4).toString();
        idProv = tablaProducto.getValueAt(tablaProducto.getSelectedRow(), 5).toString();
        
        idProdN = Integer.parseInt(idProd);
        idProvN = Integer.parseInt(idProv);
        
        costN = Float.parseFloat(cost);
        precN = Float.parseFloat(prec);
        existN = Float.parseFloat(exist);
        
        
        compras venComp = new compras(); 

        
        enviar();
        
        int x = (principal.contenedor.getWidth()/2) - venComp.getWidth()/2;
        int y = (principal.contenedor.getHeight()/2) - venComp.getHeight()/2;        
        venComp.setLocation(x, y);  
        
        principal.contenedor.add(venComp);
        venComp.toFront();
        venComp.setVisible(true);
        
        
 
        
        this.dispose();
        
        
        
    }//GEN-LAST:event_tablaProductoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        compras venComp = new compras();
        
        int x = (principal.contenedor.getWidth()/2) - venComp.getWidth()/2;
        int y = (principal.contenedor.getHeight()/2) - venComp.getHeight()/2;        
        venComp.setLocation(x, y);  
        
        principal.contenedor.add(venComp);
        venComp.toFront();
        venComp.setVisible(true);
        
 
        this.dispose();

        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    public void cargarTabla1(){
        try {
            
            DefaultTableModel modelo = new DefaultTableModel();
            tablaProducto.setModel(modelo);
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            conexion conn = new conexion();
            Connection con = conn.conect();
            
            String sql = "SELECT idProductos, Descripcion, Costo, Precio, Existencia, Proveedor_idProveedor FROM productos";
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadColumnas = rsMD.getColumnCount();
            
            
            modelo.addColumn("Id");
            modelo.addColumn("Descripción");
            modelo.addColumn("Costo");
            modelo.addColumn("Precio");
            modelo.addColumn("Existencia");
            modelo.addColumn("IdProveedor");
            
            tablaProducto.getColumnModel().getColumn(0).setPreferredWidth(33);
            tablaProducto.getColumnModel().getColumn(0).setResizable(false);
            tablaProducto.getColumnModel().getColumn(1).setPreferredWidth(120);
            tablaProducto.getColumnModel().getColumn(1).setResizable(false);
            tablaProducto.getColumnModel().getColumn(2).setPreferredWidth(40);
            tablaProducto.getColumnModel().getColumn(2).setResizable(false);
            tablaProducto.getColumnModel().getColumn(3).setPreferredWidth(40);
            tablaProducto.getColumnModel().getColumn(3).setResizable(false);
            tablaProducto.getColumnModel().getColumn(4).setPreferredWidth(40);
            tablaProducto.getColumnModel().getColumn(4).setResizable(false);
            tablaProducto.getColumnModel().getColumn(5).setPreferredWidth(33);
            tablaProducto.getColumnModel().getColumn(5).setResizable(false);
            
            
            

            while(rs.next()){
                
                Object[] filas = new Object[cantidadColumnas];
                
                for(int i = 0; i < cantidadColumnas; i++){
                    
                    filas[i] = rs.getObject(i + 1);
                    
                }
                
                modelo.addRow(filas);
                
            }
            
        } catch (SQLException ex) {
            
            System.err.println(ex.toString());
            
        }
    }
    
    
    
    
    public void enviar(){
        

        
        System.out.println(idProdN + descrip + costN + precN + existN + idProvN);
        
        
        compras.prod.setText(descrip);
        compras.cost.setText(cost);
        
        
        
        this.dispose();
        
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaProducto;
    // End of variables declaration//GEN-END:variables
}
