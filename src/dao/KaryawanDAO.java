/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Karyawan;
import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;
import tools.HibernatelUtil;

/**
 *
 * @author Siti Khusnul Azifah
 */
public class KaryawanDAO implements InterfaceCutiDAO {

    public SessionFactory factory;

    public FunctionsDAO fdao;

    public KaryawanDAO() {
        this.fdao = new FunctionsDAO(HibernatelUtil.getSessionFactory());
    }

    @Override
    public boolean insert(Object object) {
        return fdao.insert(object);
    }

    @Override
    public boolean update(Object object) {
        return fdao.insert(object);
    }

    @Override
    public boolean delete(Object object) {
        return fdao.delete(Karyawan.class, (Serializable) object);
    }

    @Override
    public List<Object> getAll() {
        return fdao.getAll("FROM Karyawan");
    }

    @Override
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM Karyawan WHERE " + category + " LIKE '%" + search + "%'");
    }

    @Override
    public Object getById(String id) {
        return fdao.getById("from Karyawan where nik='" + id + "'");
    }

}
