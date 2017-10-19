/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package txtapdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jaime
 */
public class JFrame extends javax.swing.JFrame {

//{P}  -> ayuda a producir un parrafo. Esta etiqueta sólo puede contener etiquetas que le den forma
//	al texto
//{I}  -> nos sirve para agregar una imagen al documento. El nombre del archivo de la imagen debe ser
//	el que esta entre la etiqueta y su cierre
//{n}  -> nos sirve para indicar un salto de línea, no lleva etiqueta de cierre

   String contenido = null;
   private static final Font iCap = new Font(Font.FontFamily.TIMES_ROMAN, 18);
   private static final Font subTitulo = new Font(Font.FontFamily.TIMES_ROMAN, 16);
   private static final Font negritas = new Font(Font.FontFamily.TIMES_ROMAN,14,Font.BOLD);
   private static final Font cursiva = new Font(Font.FontFamily.TIMES_ROMAN,14,Font.ITALIC);
   private static final Font subrayado = new Font(Font.FontFamily.TIMES_ROMAN,14,Font.UNDERLINE);
   
    /**
     * Creates new form JFrame
     */
    public JFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TxtRuta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtContenido = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        guardarTxt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TxtContenido.setColumns(20);
        TxtContenido.setRows(5);
        jScrollPane1.setViewportView(TxtContenido);

        jButton2.setText("Guardar en PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        guardarTxt.setText("Guardar en txt");
        guardarTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(guardarTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TxtRuta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(guardarTxt))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         JFileChooser dlg = new JFileChooser();
         int option = dlg.showSaveDialog(this);
         if(option == JFileChooser.APPROVE_OPTION){
             File f = dlg.getSelectedFile();
             TxtRuta.setText(f.toString());
         }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         
        String ruta = TxtRuta.getText();
        contenido = TxtContenido.getText();
        try{
            FileOutputStream archivo = new FileOutputStream(ruta+".pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            if (contenido.equals("{b}%{/b}")) {
                doc.add(new Paragraph(contenido, negritas));
            }//else if (contenido.equals("{i}%{/i}")) {
               // doc.add(new Paragraph(contenido, cursiva));
            //}
//            if(contenido.startsWith("{b}") && contenido.endsWith("{/b}")){
//                doc.add(new Paragraph(contenido, negritas));
//            }else if(contenido.startsWith("{i}") && contenido.endsWith("{/i}")){
//                doc.add(new Paragraph(contenido, cursiva));
//            }

            //contenido.indexOf("{i}", FRAMEBITS);
           // doc.add(new Paragraph(contenido, iCap));
            doc.add(new Paragraph("Te odio", negritas));
            doc.add(new Paragraph("y te desprecio", cursiva));
            
            //AGREGAR IMAGENES
//             try
//        {
//                Image foto = Image.getInstance(contenido);
//                foto.scaleToFit(300, 300);
//                foto.setAlignment(Chunk.ALIGN_RIGHT);
//                doc.add(foto);
//        }
//        catch ( Exception e )
//        {
//                e.printStackTrace();
//        }
             
             //AGREGAR IMAGENES
            doc.close();
            
            JOptionPane.showMessageDialog(null, "Pdf guardado");
            
        }catch(Exception e){
            System.out.println("Error: " + e);
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void guardarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarTxtActionPerformed
       String ruta = TxtRuta.getText();
        String contenido = TxtContenido.getText();
       try{
          File archivo = new File(ruta+".txt");  
          FileWriter escribir = new FileWriter(archivo,true);
          escribir.write(contenido);
          escribir.close();
          JOptionPane.showMessageDialog(null, "Txt guardado");
       }catch(Exception e){
          System.out.println("Error: " + e);
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_guardarTxtActionPerformed

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
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TxtContenido;
    private javax.swing.JTextField TxtRuta;
    private javax.swing.JButton guardarTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
