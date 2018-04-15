/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author AdiRahmad
 */
public class Cuti extends javax.swing.JFrame {

    /**
     * Creates new form Cuti
     */
    public Cuti() {
        initComponents();
        setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        Desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mstrKaryawan = new javax.swing.JMenu();
        menuKaryawan = new javax.swing.JMenuItem();
        mstrJabatan = new javax.swing.JMenuItem();
        mstrCuti = new javax.swing.JMenuItem();
        PengCuti = new javax.swing.JMenu();
        pengajuanCuti = new javax.swing.JMenuItem();
        cetakPengajuanCuti = new javax.swing.JCheckBoxMenuItem();
        jMenu1 = new javax.swing.JMenu();
        persetujuanCuti = new javax.swing.JCheckBoxMenuItem();
        cetakPersetujuanCuti = new javax.swing.JCheckBoxMenuItem();
        mstrLaporan = new javax.swing.JMenu();
        cetakLaporanCuti = new javax.swing.JMenuItem();
        CetakLapPengajuanCuti = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Cuti");
        setSize(new java.awt.Dimension(800, 640));

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );

        mstrKaryawan.setText("Entry Master Data");

        menuKaryawan.setText("Master Karyawan");
        menuKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuKaryawanMouseClicked(evt);
            }
        });
        menuKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKaryawanActionPerformed(evt);
            }
        });
        mstrKaryawan.add(menuKaryawan);

        mstrJabatan.setText("Master Jabatan");
        mstrJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mstrJabatanActionPerformed(evt);
            }
        });
        mstrKaryawan.add(mstrJabatan);

        mstrCuti.setText("Master Cuti");
        mstrCuti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mstrCutiActionPerformed(evt);
            }
        });
        mstrKaryawan.add(mstrCuti);

        jMenuBar1.add(mstrKaryawan);

        PengCuti.setText(" Pengajuan Cuti ");

        pengajuanCuti.setText("Pengajuan Cuti");
        pengajuanCuti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pengajuanCutiActionPerformed(evt);
            }
        });
        PengCuti.add(pengajuanCuti);

        cetakPengajuanCuti.setSelected(true);
        cetakPengajuanCuti.setText("Cetak Pengajuan Cuti");
        cetakPengajuanCuti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakPengajuanCutiActionPerformed(evt);
            }
        });
        PengCuti.add(cetakPengajuanCuti);

        jMenuBar1.add(PengCuti);

        jMenu1.setText(" Persetujuan Cuti ");

        persetujuanCuti.setSelected(true);
        persetujuanCuti.setText("Persetujuan Cuti");
        persetujuanCuti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                persetujuanCutiActionPerformed(evt);
            }
        });
        jMenu1.add(persetujuanCuti);

        cetakPersetujuanCuti.setSelected(true);
        cetakPersetujuanCuti.setText("Cetak Persetujuan Cuti ");
        cetakPersetujuanCuti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakPersetujuanCutiActionPerformed(evt);
            }
        });
        jMenu1.add(cetakPersetujuanCuti);

        jMenuBar1.add(jMenu1);

        mstrLaporan.setText("Laporan");

        cetakLaporanCuti.setText("Cetak Laporan Keseluruhan Cuti");
        cetakLaporanCuti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakLaporanCutiActionPerformed(evt);
            }
        });
        mstrLaporan.add(cetakLaporanCuti);

        CetakLapPengajuanCuti.setText("Cetak Laporan Pengajuan Cuti");
        CetakLapPengajuanCuti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CetakLapPengajuanCutiActionPerformed(evt);
            }
        });
        mstrLaporan.add(CetakLapPengajuanCuti);

        jMenuBar1.add(mstrLaporan);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void menuKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKaryawanActionPerformed
        Karyawan k = new Karyawan();
        Jabatan j = new Jabatan();
        PengajuanCuti pc = new PengajuanCuti();
        k.show();
        j.dispose();
        pc.dispose();
        Desktop.add(k);
        Desktop.remove(j);
        Desktop.remove(pc);

        menuKaryawan.setEnabled(false);
        pengajuanCuti.setEnabled(true);
        mstrJabatan.setEnabled(true);

    }//GEN-LAST:event_menuKaryawanActionPerformed

    private void pengajuanCutiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pengajuanCutiActionPerformed
        PengajuanCuti pc = new PengajuanCuti();
        pc.show();
        Desktop.add(pc);
    }//GEN-LAST:event_pengajuanCutiActionPerformed

    private void mstrJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mstrJabatanActionPerformed
        Karyawan k = new Karyawan();
        Jabatan j = new Jabatan();
        PengajuanCuti pc = new PengajuanCuti();
        j.show();
        k.dispose();
        pc.dispose();
        Desktop.add(j);
        Desktop.remove(k);
        Desktop.remove(pc);

        mstrJabatan.setEnabled(false);
        mstrCuti.setEnabled(true);
        menuKaryawan.setEnabled(true);
    }//GEN-LAST:event_mstrJabatanActionPerformed

    private void mstrCutiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mstrCutiActionPerformed
        MasterCuti mc = new MasterCuti();
        mc.show();
        Desktop.add(mc);
        mstrCuti.setEnabled(false);
        mstrJabatan.setEnabled(true);
        menuKaryawan.setEnabled(true);

    }//GEN-LAST:event_mstrCutiActionPerformed

    private void menuKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuKaryawanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuKaryawanMouseClicked

    private void persetujuanCutiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_persetujuanCutiActionPerformed
        PersetujuanCuti psc = new PersetujuanCuti();
        psc.show();
        Desktop.add(psc);
    }//GEN-LAST:event_persetujuanCutiActionPerformed

    private void cetakLaporanCutiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakLaporanCutiActionPerformed
        CetakLaporanKeseluruhan cl = new CetakLaporanKeseluruhan();
        cl.show();
        Desktop.add(cl);
    }//GEN-LAST:event_cetakLaporanCutiActionPerformed

    private void cetakPengajuanCutiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakPengajuanCutiActionPerformed
        CetakPengajuan cp = new CetakPengajuan();
        cp.show();
        Desktop.add(cp);
    }//GEN-LAST:event_cetakPengajuanCutiActionPerformed

    private void cetakPersetujuanCutiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakPersetujuanCutiActionPerformed
        CetakPersetujuan cps = new CetakPersetujuan();
        cps.show();
        Desktop.add(cps);
    }//GEN-LAST:event_cetakPersetujuanCutiActionPerformed

    private void CetakLapPengajuanCutiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CetakLapPengajuanCutiActionPerformed
        CetakLaporanPengajuanCuti clpc = new CetakLaporanPengajuanCuti();
        clpc.show();
        Desktop.add(clpc);
    }//GEN-LAST:event_CetakLapPengajuanCutiActionPerformed
    
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
            java.util.logging.Logger.getLogger(Cuti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cuti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cuti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cuti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cuti().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CetakLapPengajuanCuti;
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenu PengCuti;
    private javax.swing.JMenuItem cetakLaporanCuti;
    private javax.swing.JCheckBoxMenuItem cetakPengajuanCuti;
    private javax.swing.JCheckBoxMenuItem cetakPersetujuanCuti;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem menuKaryawan;
    private javax.swing.JMenuItem mstrCuti;
    private javax.swing.JMenuItem mstrJabatan;
    private javax.swing.JMenu mstrKaryawan;
    private javax.swing.JMenu mstrLaporan;
    private javax.swing.JMenuItem pengajuanCuti;
    private javax.swing.JCheckBoxMenuItem persetujuanCuti;
    // End of variables declaration//GEN-END:variables
}