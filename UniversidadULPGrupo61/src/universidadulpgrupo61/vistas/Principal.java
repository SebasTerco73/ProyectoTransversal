/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadulpgrupo61.vistas;

import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Loa
 */
public class Principal extends javax.swing.JFrame {
    //AudioClip sound;
    //VER QUE LOS FRAME NO SE DUPLIQUEN Y SE PUEDAN MINIMIZAR.

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setTitle("Universidad de La Punta");
        //sound=java.applet.Applet.newAudioClip(getClass().getResource("/imagenes/Dale Dale Boca.wav"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/ulp.jpg"));
        Image imagen = icono.getImage();
        Escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        itmFormularioA = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        itmFormularioM = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        itmAdminInscripcion = new javax.swing.JMenuItem();
        itmManipulacionNotas = new javax.swing.JMenuItem();
        itmAlumnosXMateria = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenuItem1.setText("jMenuItem1");

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Escritorio.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 803, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );

        itmFormularioA.setText("Alumno");

        jMenuItem2.setText("Formulario de Alumno");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        itmFormularioA.add(jMenuItem2);

        jMenuBar1.add(itmFormularioA);

        itmFormularioM.setText("Materia");

        jMenuItem3.setText("Formulario de Materia");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        itmFormularioM.add(jMenuItem3);

        jMenuBar1.add(itmFormularioM);

        jMenu7.setText("Administración");

        itmAdminInscripcion.setText("Manejo de Inscripciones");
        itmAdminInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAdminInscripcionActionPerformed(evt);
            }
        });
        jMenu7.add(itmAdminInscripcion);

        itmManipulacionNotas.setText("Manipulación de Notas");
        itmManipulacionNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmManipulacionNotasActionPerformed(evt);
            }
        });
        jMenu7.add(itmManipulacionNotas);

        jMenuBar1.add(jMenu7);

        itmAlumnosXMateria.setText("Consultas");

        jMenuItem6.setText("Alumnos por Materia");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        itmAlumnosXMateria.add(jMenuItem6);

        jMenuBar1.add(itmAlumnosXMateria);

        jMenu9.setText("Salir");
        jMenu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu9MouseClicked(evt);
            }
        });
        jMenu9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu9ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        //sound.play();
        Escritorio.removeAll();
        Escritorio.repaint();
        FormularioAlumno fma = new FormularioAlumno();
        fma.setVisible(true);
        int x = (Escritorio.getWidth() / 2) - fma.getWidth() / 2;
        int y = (Escritorio.getHeight() / 2) - fma.getHeight() / 2;
        fma.setLocation(x, y);
        Escritorio.add(fma);


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Escritorio.removeAll();
        Escritorio.repaint();
        FormularioMateria fmm = new FormularioMateria();
        fmm.setVisible(true);
        int x = (Escritorio.getWidth() / 2) - fmm.getWidth() / 2;
        int y = (Escritorio.getHeight() / 2) - fmm.getHeight() / 2;
        fmm.setLocation(x, y);
        Escritorio.add(fmm);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void itmAdminInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAdminInscripcionActionPerformed
        Escritorio.removeAll();
        Escritorio.repaint();
        FormularioInscripcion fmi = new FormularioInscripcion();
        fmi.setVisible(true);
        int x = (Escritorio.getWidth() / 2) - fmi.getWidth() / 2;
        int y = (Escritorio.getHeight() / 2) - fmi.getHeight() / 2;
        fmi.setLocation(x, y);
        Escritorio.add(fmi);
    }//GEN-LAST:event_itmAdminInscripcionActionPerformed

    private void itmManipulacionNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmManipulacionNotasActionPerformed
        Escritorio.removeAll();
        Escritorio.repaint();
        FormularioNotas fmn = new FormularioNotas();
        fmn.setVisible(true);
        int x = (Escritorio.getWidth() / 2) - fmn.getWidth() / 2;
        int y = (Escritorio.getHeight() / 2) - fmn.getHeight() / 2;
        fmn.setLocation(x, y);
        Escritorio.add(fmn);
    }//GEN-LAST:event_itmManipulacionNotasActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Escritorio.removeAll();
        Escritorio.repaint();
        FormularioAlumnosPorMateria fmam = new FormularioAlumnosPorMateria();
        fmam.setVisible(true);
        int x = (Escritorio.getWidth() / 2) - fmam.getWidth() / 2;
        int y = (Escritorio.getHeight() / 2) - fmam.getHeight() / 2;
        fmam.setLocation(x, y);
        Escritorio.add(fmam);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenu9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu9ActionPerformed

    }//GEN-LAST:event_jMenu9ActionPerformed

    private void jMenu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenu9MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuItem itmAdminInscripcion;
    private javax.swing.JMenu itmAlumnosXMateria;
    private javax.swing.JMenu itmFormularioA;
    private javax.swing.JMenu itmFormularioM;
    private javax.swing.JMenuItem itmManipulacionNotas;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    // End of variables declaration//GEN-END:variables
}
