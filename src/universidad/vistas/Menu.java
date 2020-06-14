/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.vistas;

import universidad.Conexion;
import java.awt.*;

/**
 *
 * @author Eourist
 */
public class Menu extends javax.swing.JFrame {
    AlumnosView vAlumnos;
    MateriasView vMaterias;
    CursadasView vCursadas;
    ListadoCursadasView vListaCursadas;
    
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        new Conexion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jDesktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMAlumnos = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMIAlumnosABM = new javax.swing.JMenuItem();
        jMMaterias = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMIMateriasABM = new javax.swing.JMenuItem();
        jMCursadas = new javax.swing.JMenu();
        jMIListaCursadas = new javax.swing.JMenuItem();
        jMICursadasABM = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopLayout = new javax.swing.GroupLayout(jDesktop);
        jDesktop.setLayout(jDesktopLayout);
        jDesktopLayout.setHorizontalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDesktopLayout.setVerticalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        jMAlumnos.setText("Alumnos");

        jMenuItem1.setText("Listado");
        jMAlumnos.add(jMenuItem1);

        jMIAlumnosABM.setText("Administrar");
        jMIAlumnosABM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAlumnosABMActionPerformed(evt);
            }
        });
        jMAlumnos.add(jMIAlumnosABM);

        jMenuBar1.add(jMAlumnos);

        jMMaterias.setText("Materias");

        jMenuItem2.setText("Listado");
        jMMaterias.add(jMenuItem2);

        jMIMateriasABM.setText("Administrar");
        jMIMateriasABM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIMateriasABMActionPerformed(evt);
            }
        });
        jMMaterias.add(jMIMateriasABM);

        jMenuBar1.add(jMMaterias);

        jMCursadas.setText("Cursadas");

        jMIListaCursadas.setText("Listado");
        jMIListaCursadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIListaCursadasActionPerformed(evt);
            }
        });
        jMCursadas.add(jMIListaCursadas);

        jMICursadasABM.setText("Administrar");
        jMICursadasABM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICursadasABMActionPerformed(evt);
            }
        });
        jMCursadas.add(jMICursadasABM);

        jMenuBar1.add(jMCursadas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIMateriasABMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIMateriasABMActionPerformed
        vMaterias = new MateriasView();
        mostrarVentana(vMaterias);
    }//GEN-LAST:event_jMIMateriasABMActionPerformed

    private void jMIListaCursadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIListaCursadasActionPerformed
        vListaCursadas = new ListadoCursadasView();
        mostrarVentana(vListaCursadas);
    }//GEN-LAST:event_jMIListaCursadasActionPerformed

    private void jMIAlumnosABMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAlumnosABMActionPerformed
        vAlumnos = new AlumnosView();
        mostrarVentana(vAlumnos);
    }//GEN-LAST:event_jMIAlumnosABMActionPerformed

    private void jMICursadasABMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICursadasABMActionPerformed
        vCursadas = new CursadasView();
        mostrarVentana(vCursadas);
    }//GEN-LAST:event_jMICursadasABMActionPerformed
    
    private void mostrarVentana(Component c){
        jDesktop.repaint();
        jDesktop.add(c);
        c.setVisible(true);
        jDesktop.moveToFront(c);
    }
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktop;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMAlumnos;
    private javax.swing.JMenu jMCursadas;
    private javax.swing.JMenuItem jMIAlumnosABM;
    private javax.swing.JMenuItem jMICursadasABM;
    private javax.swing.JMenuItem jMIListaCursadas;
    private javax.swing.JMenuItem jMIMateriasABM;
    private javax.swing.JMenu jMMaterias;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
