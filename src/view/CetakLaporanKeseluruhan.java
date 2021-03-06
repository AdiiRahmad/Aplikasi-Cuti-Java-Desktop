/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Siti Khusnul Azifah
 */
public class CetakLaporanKeseluruhan extends javax.swing.JInternalFrame {

    /**
     * Creates new form CetakLaporan
     */
    public CetakLaporanKeseluruhan() {
        initComponents();
        makeCenter();
    }
    
    private void makeCenter(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        if(frameSize.height > screenSize.height) {
        frameSize.height = screenSize.height;
        } if(frameSize.width > screenSize.width) {
        frameSize.width = screenSize.width;
        }
        this.setLocation((screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollCetakLaporan = new javax.swing.JScrollPane();
        btnCetak = new javax.swing.JButton();

        setTitle("Form Cetak Laporan Keseluruhan Cuti");

        scrollCetakLaporan.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                scrollCetakLaporanComponentAdded(evt);
            }
        });

        btnCetak.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCetak.setText("Cetak Laporan Keseluruhan Cuti");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollCetakLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnCetak)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnCetak, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(scrollCetakLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scrollCetakLaporanComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_scrollCetakLaporanComponentAdded

    }//GEN-LAST:event_scrollCetakLaporanComponentAdded

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        try {
            String path = "report/CetakLaporanKeseluruhanCuti.jasper";
            String driver="oracle.jdbc.OracleDriver";
            String konek="jdbc:oracle:thin:@localhost:1521:XE";
            String user="system";
            String password="admin";
            HashMap parameter = new HashMap();
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(konek,user,password);
            File reportFile=new File(path);
            InputStream jReport = this.getClass().getClassLoader().getResourceAsStream(reportFile.getPath());
//            JasperReport jReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
//            JasperViewer.viewReport(jPrint, true);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, parameter, conn);
            JRViewer viewer = new JRViewer(jPrint);
            viewer.setOpaque(true);
            viewer.setVisible(true);
            scrollCetakLaporan.add(viewer);
            scrollCetakLaporan.setViewportView(viewer);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Laporan Tidak Dapat Dicetak!\n" + e.getMessage()
            ,"Cetak Laporan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JScrollPane scrollCetakLaporan;
    // End of variables declaration//GEN-END:variables
}
