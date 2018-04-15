/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CutiDAO;
import entities.Cuti;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Siti Khusnul Azifah
 */
public class CutiController {
    
    CutiDAO cDAO = new CutiDAO();
    
    /**
     * Fungsi untuk menambahkan data ke tabel Cuti
     * @param idCuti, jenisCuti, durasi, keterangan
     * @return flag data berhasil atau gagal disimpan
     */
     public boolean insert(String idCuti,
             String jenisCuti, 
             Integer durasi,
             String keterangan) {
        Cuti c = new Cuti();
        c.setIdCuti(idCuti);
        c.setJenisCuti(jenisCuti);
        c.setDurasi(durasi);
        c.setKeterangan(keterangan);
        return cDAO.insert(c);
    }
      
    /**
     * Fungsi untuk menghapus data dari tabel Cuti
     * @param idCuti
     * @return flag data berhasil atau gagal dihapus
     */
    public boolean delete(String idCuti) {
        return cDAO.delete(idCuti);
    }
    
    /**
     * Fungsi untuk mengubah data di tabel Cuti
     * @param idCuti, jenisCuti, durasi, keterangan
     * @return flag data berhasil atau gagal diubah
     */
    public boolean update(String idCuti, String jenisCuti, Integer durasi, String keterangan) {
        Cuti cu = new Cuti(idCuti, jenisCuti, durasi, keterangan);
        return cDAO.update(cu);
    }
    
    /**
     * Fungsi untuk menampilkan data tabel Cuti di JTable
     * @param JTable, header
     * @return data dari tabel cuti sesuai header yang ditentukan
     */
    public void bindingAll(JTable table, String[] header) {
        bindingTable(table, header, cDAO.getAll());
    }
    
    /**
     * Fungsi untuk mencari data tabel Cuti di JTable
     * @param JTable, header, category, cari
     * @return data dari tabel cuti sesuai category yang dicari
     */
    public void bindingSearch(JTable table, String[] header, String category, String cari){
        bindingTable(table, header, cDAO.search(category, cari));        
    }  
    
    
    /**
     * Fungsi untuk menampilkan data tabel Cuti di JTable
     * @param JTable, header, list data
     * @return seluruh data dari tabel cuti sesuai category yang ditentukan
     */
    public void bindingTable(JTable table, String[] header, List<Object> datas) {       
        DefaultTableModel model = new DefaultTableModel(header,0);
        for (Object data : datas) {
            Cuti c = (Cuti)data;
            Object[] data1 = {
                c.getIdCuti(),
                c.getJenisCuti(),
                c.getDurasi(),
                c.getKeterangan()
            };
            model.addRow(data1);
        }
        table.setModel(model);
    }

}
