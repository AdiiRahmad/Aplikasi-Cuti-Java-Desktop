/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CutiDAO;
import dao.JabatanDAO;
import entities.Cuti;
import entities.Jabatan;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Siti Khusnul Azifah
 */
public class JabatanController {

    JabatanDAO jbDAO = new JabatanDAO();

//     public boolean insert(String idJabatan, String jabatan, Jabatan idPimpinan) {
//        Jabatan jb = new Jabatan(idJabatan, jabatan, idPimpinan);
//        return jbDAO.insert(jb);
//    }
    public boolean insert(String idJabatan,
            String jabatan,
            String idPimpinan,
             boolean issave) {
        Jabatan j = new Jabatan();
        j.setIdJabatan(idJabatan);
        j.setJabatan(jabatan);
        j.setIdPimpinan(new Jabatan(idPimpinan));
        return jbDAO.insert(j);
    }

    public boolean delete(String idJabatan) {
        return jbDAO.delete(idJabatan);
    }

    public boolean update(String idJabatan, String jabatan, Jabatan idPimpinan) {
        Jabatan jb = new Jabatan(idJabatan, jabatan, idPimpinan);
        return jbDAO.update(jb);
    }

    public void bindingAll(JTable table, String[] header) {
        bindingTable(table, header, jbDAO.getAll());
    }

    public void bindingSearch(JTable table, String[] header, String category, String cari) {
        bindingTable(table, header, jbDAO.search(category, cari));
    }

    public void bindingTable(JTable table, String[] header, List<Object> datas) {
        DefaultTableModel model = new DefaultTableModel(header, 0);
        for (Object data : datas) {
            Jabatan j = (Jabatan) data;
            Object[] data1 = {
                j.getIdJabatan(),
                j.getJabatan(),
                j.getIdPimpinan()
            };
            model.addRow(data1);
        }
        table.setModel(model);
    }
}
