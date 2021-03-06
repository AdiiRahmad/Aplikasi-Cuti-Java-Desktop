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
public class CetakPersetujuan extends javax.swing.JInternalFrame {

    /**
     * Creates new form CetakLaporan
     */
    public CetakPersetujuan() {
        initComponents();
        makeCenter();
    }

    private void makeCenter() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
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

        scrollCetakPengajuan = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtSetujuCuti = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Form Cetak Persetujuan Cuti");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cetak Persetujuan Cuti");

        jLabel1.setText("Masukkan ID Persetujuan  : ");

        txtSetujuCuti.setToolTipText("id Setuju Cuti : \"PC01\"");
        txtSetujuCuti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtSetujuCutiMouseEntered(evt);
            }
        });
        txtSetujuCuti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSetujuCutiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSetujuCuti, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSetujuCuti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollCetakPengajuan, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollCetakPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSetujuCutiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSetujuCutiMouseEntered
   
    }//GEN-LAST:event_txtSetujuCutiMouseEntered

    private void txtSetujuCutiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSetujuCutiActionPerformed
             try {
            String path = "report/CetakPersetujuanCuti.jasper";
            String driver="oracle.jdbc.OracleDriver";
            String konek="jdbc:oracle:thin:@localhost:1521:XE";
            String user="system";
            String password="admin";
            HashMap parameter = new HashMap();
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(konek,user,password);
            File reportFile=new File(path);
            InputStream jReport = this.getClass().getClassLoader().getResourceAsStream(reportFile.getPath());
            parameter.put("IDSETUJU", txtSetujuCuti.getText());
//            JasperReport jReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
//            JasperViewer.viewReport(jPrint, true);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, parameter, conn);
            JRViewer viewer = new JRViewer(jPrint);
            viewer.setOpaque(true);
            viewer.setVisible(true);
            scrollCetakPengajuan.add(viewer);
            scrollCetakPengajuan.setViewportView(viewer);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Laporan Tidak Dapat Dicetak!\n" + e.getMessage()
            ,"Cetak Laporan", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_txtSetujuCutiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollCetakPengajuan;
    private javax.swing.JTextField txtSetujuCuti;
    // End of variables declaration//GEN-END:variables
}
