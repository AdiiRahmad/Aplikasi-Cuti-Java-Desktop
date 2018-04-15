/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CutiDAO;
import dao.DetailCutiDAO;
import dao.JabatanDAO;
import dao.KaryawanDAO;
import entities.Cuti;
import entities.DetailCuti;
import entities.Jabatan;
import entities.Karyawan;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Siti Khusnul Azifah
 */
public class DetailCutiController {

    private final KaryawanDAO kDAO;
    private final CutiDAO cDAO;
    private final DetailCutiDAO dcDAO;
    private final JabatanDAO jbDAO;

    public DetailCutiController() {
        this.kDAO = new KaryawanDAO();
        this.cDAO = new CutiDAO();
        this.dcDAO = new DetailCutiDAO();
        this.jbDAO = new JabatanDAO();
    }

    public boolean insertPengajuanCuti(
            String idDetailCuti,
            String nik,
            String idCuti,
            String keterangan,
            String tanggalMulai,
            String tanggalSelesai,
            Short lamaCuti) {
        DetailCuti decut = new DetailCuti();
        decut.setIdDetailCuti(idDetailCuti);
        String[] KarNik = nik.split(" ");
        decut.setNik((Karyawan) kDAO.getById(KarNik[0]));
        String[] CuIdCuti = idCuti.split(" ");
        decut.setIdCuti((Cuti) cDAO.getById(CuIdCuti[0]));
        decut.setKeterangan(keterangan);
        decut.setTanggalMulai(new java.sql.Date(new Long(tanggalMulai)));
        decut.setTanggalSelesai(new java.sql.Date(new Long(tanggalSelesai)));
        decut.setLamaCuti(lamaCuti);

        return dcDAO.insert(decut);
    }

    public boolean delete(String idDetailCuti) {
        return dcDAO.delete(idDetailCuti);
    }

    public void loadNik(JComboBox jComboBox) {
        kDAO.getAll().stream().map((object) -> (Karyawan) object).forEachOrdered((karyawan) -> {
            jComboBox.addItem(karyawan.getNik() + " - "
                    + karyawan.getNama());
        });
    }

    public void loadCuti(JComboBox jComboBox) {
        cDAO.getAll().stream().map((object) -> (Cuti) object).forEachOrdered((cuti) -> {
            jComboBox.addItem(cuti.getIdCuti() + " - "
                    + cuti.getJenisCuti());
        });
    }

    public void loadJabatan(JComboBox jComboBox) {
         jComboBox.addItem(" ");
        jbDAO.getAll().stream().map((object) -> (Jabatan) object).forEachOrdered((jabatan) -> {
            jComboBox.addItem(jabatan.getIdJabatan() + " - "
                    + jabatan.getJabatan());
        });
    }
    
}
