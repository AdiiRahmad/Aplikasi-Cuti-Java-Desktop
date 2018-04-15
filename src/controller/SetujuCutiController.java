/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DetailCutiDAO;
import dao.JabatanDAO;
import dao.KaryawanDAO;
import dao.SetujuCutiDAO;
import entities.Cuti;
import entities.DetailCuti;
import entities.Jabatan;
import entities.Karyawan;
import entities.SetujuCuti;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AdiRahmad
 */
public class SetujuCutiController {

    private final SetujuCutiDAO scDAO;
    private final JabatanDAO jbDAO;
    private final DetailCutiDAO dcDAO;

    public SetujuCutiController() {
        this.scDAO = new SetujuCutiDAO();
        this.jbDAO = new JabatanDAO();
        this.dcDAO = new DetailCutiDAO();
    }

    public boolean insert(String id_setuju_cuti,
            String id_detail_cuti,
            String status,
            String id_jabatan, boolean issave) {
        SetujuCuti sc = new SetujuCuti();
        sc.setIdSetujuCuti(id_setuju_cuti);
        String[] idDetail = id_detail_cuti.split(" ");
        sc.setIdDetailCuti((DetailCuti) dcDAO.getById(idDetail[0]));
        sc.setStatus(status);
        String[] idJb = id_jabatan.split(" ");
        sc.setIdJabatan((Jabatan) jbDAO.getById(idJb[0]));

        return scDAO.insert(sc);
    }

    public boolean delete(String id_setuju_cuti) {
        return scDAO.delete(id_setuju_cuti);
    }

    public List<String> bindingAll(JTable table, String[] header) {
        return bindingTable(table, header, scDAO.getAll());
    }

    public List<String> bindingSearch(JTable table, String[] header, String category, String cari) {
        return bindingTable(table, header, scDAO.search(category, cari));
    }

    public void loadJabatan(JComboBox jComboBox) {
        jbDAO.getAll().stream().map((object) -> (Jabatan) object).forEachOrdered((jabatan) -> {
            jComboBox.addItem(jabatan.getIdJabatan() + " - "
                    + jabatan.getJabatan());
        });
    }

    public void loadDetailCuti(JComboBox jComboBox) {
        dcDAO.getAll().stream().map((object) -> (DetailCuti) object).forEachOrdered((detailcuti) -> {
            jComboBox.addItem(detailcuti.getIdDetailCuti());
        });
    }
    
    private List<String> bindingTable(JTable table, String[] header, List<Object> datas) {
        List<String> dataManager = new ArrayList<>();
        DefaultTableModel model = new DefaultTableModel(header, 0);
        int i = 1;
        for (Object data : datas) {
            SetujuCuti setujucuti = (SetujuCuti) data;
//            String jabatan = "";
            dataManager.add(" - ;" + setujucuti.getIdJabatan().getIdJabatan()
                    + " - " + setujucuti.getIdJabatan().getJabatan());
            Object[] data1 = {
                i++,
                setujucuti.getIdSetujuCuti(),
                setujucuti.getIdDetailCuti(),
                setujucuti.getStatus(),
                setujucuti.getIdJabatan().getJabatan()
            };
            model.addRow(data1);
        }
        table.setModel(model);
        return dataManager;
    }

}
