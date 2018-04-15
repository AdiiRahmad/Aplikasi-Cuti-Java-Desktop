/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KaryawanDAO;
import entities.Jabatan;
import entities.Karyawan;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Siti Khusnul Azifah
 */
public class KaryawanController {

    KaryawanDAO kDAO = new KaryawanDAO();

    public boolean insert(String nik,
            String nama,
            String alamat,
            String agama,
            String jenisKelamin,
            String tanggalLahir,
            String tglMulaiKerja,
            Short sisa, boolean issave) {
        Karyawan k = new Karyawan();
        k.setNik(nik);
        k.setNama(nama);
        k.setAlamat(alamat);
        k.setAgama(agama);
        k.setJenisKelamin(jenisKelamin);
        k.setTanggalLahir(new java.sql.Date(new Long(tanggalLahir)));
        k.setTglMulaiKerja(new java.sql.Date(new Long(tglMulaiKerja)));
        k.setSisa(sisa);
        return kDAO.insert(k);
    }

    public boolean delete(String nik) {
        return kDAO.delete(nik);
    }

    public boolean update(String nik, String nama, String alamat, String agama, String jenisKelamin, Date tanggalLahir, Date tglMulaiKerja, Short sisa) {
        Karyawan k = new Karyawan(nik, nama, alamat, agama, jenisKelamin, tanggalLahir, tglMulaiKerja, sisa);
        return kDAO.update(k);
    }

    public void bindingAll(JTable table, String[] header) {
        bindingTable(table, header, kDAO.getAll());
    }

    public void bindingSearch(JTable table, String[] header, String category, String cari) {
        bindingTable(table, header, kDAO.search(category, cari));
    }

    public void bindingTable(JTable table, String[] header, List<Object> datas) {
        DefaultTableModel model = new DefaultTableModel(header, 0);
        for (Object data : datas) {
            Karyawan k = (Karyawan) data;
            Object[] data1 = {
                k.getNik(),
                k.getNama(),
                k.getAlamat(),
                k.getAgama(),
                k.getJenisKelamin(),
                k.getTanggalLahir(),
                k.getTglMulaiKerja(),
                k.getSisa()
            };
            model.addRow(data1);
        }
        table.setModel(model);
    }
}
