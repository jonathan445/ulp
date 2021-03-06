/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.vistas;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import universidad.data.*;
import universidad.entidades.*;

/**
 *
 * @author Eourist
 */
public class ListadoCursadasView extends javax.swing.JInternalFrame {
    CursadaData cd;
    MateriaData md;
    AlumnoData ad;
    DefaultTableModel dtf;
    /**
     * Creates new form CursadasView
     */
    public ListadoCursadasView() {
        initComponents();
        cd = new CursadaData();
        ad = new AlumnoData();
        md = new MateriaData();
        dtf = new DefaultTableModel();
        armarEncabezados();
        armarDesplegableMaterias();
        armarDesplegableAlumnos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBBuscar = new javax.swing.JButton();
        jCBMaterias = new javax.swing.JComboBox<>();
        jCBAlumnos = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Listado de cursadas");
        setName(""); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCBAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBBuscar)
                    .addComponent(jCBMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        List<Cursada> resultados = new ArrayList<>();
        
        int idAlumno = ((Alumno)jCBAlumnos.getSelectedItem()).getId();
        int idMateria = ((Materia)jCBMaterias.getSelectedItem()).getId();
        
        for (int i = dtf.getRowCount(); i > 0; i--){
            dtf.removeRow(i-1);
        }
        
            // Buscar todas las cursadas
        if (idMateria == -1 && idAlumno == -1){
            resultados = cd.obtenerCursadas();
        }
            // Buscar cursadas por alumno y por materia
        if (idMateria != -1 && idAlumno != -1){
            resultados = cd.obtenerCursadas(idAlumno, idMateria);
        } 
            // Buscar cursadas por materia
        if (idMateria != -1 && idAlumno == -1){
            resultados = cd.obtenerCursadasMateria(idMateria);
        }
            // Buscar cursadas por alumno
        if (idMateria == -1 && idAlumno != -1){
            resultados = cd.obtenerCursadasAlumno(idAlumno);
        }
        
        for (Cursada c : resultados){
            if (c.getNota() != 0)
                dtf.addRow(new Object[]{c.getAlumno().getNombre(), c.getMateria().getNombre(), c.getNota()});
            else 
                dtf.addRow(new Object[]{c.getAlumno().getNombre(), c.getMateria().getNombre(), ""});
        }
    }//GEN-LAST:event_jBBuscarActionPerformed
    private void armarDesplegableMaterias(){
        ArrayList<Materia> resultados = new ArrayList<>();
        resultados = md.obtenerMaterias();
        
        jCBMaterias.addItem(new Materia("Todas las materias"));
        for (Materia m : resultados){
            //System.out.println(m.getNombre());
            jCBMaterias.addItem(m);
        }
    }
    
    private void armarDesplegableAlumnos(){
        ArrayList<Alumno> resultados = new ArrayList<>();
        resultados = ad.obtenerAlumnos();
        
        jCBAlumnos.addItem(new Alumno("Todos los alumnos", LocalDate.of(1980, Month.MARCH, 1), false));
        for (Alumno a : resultados){
            jCBAlumnos.addItem(a);
        }
    }
    
    private void armarEncabezados(){
        ArrayList<Object> ob = new ArrayList<Object>();
        ob.add("Alumno");
        ob.add("Materia");
        ob.add("Nota");
        
        for(Object o : ob){
            dtf.addColumn(o);
        }
        jTable1.setModel(dtf);
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JComboBox<Alumno> jCBAlumnos;
    private javax.swing.JComboBox<Materia> jCBMaterias;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
