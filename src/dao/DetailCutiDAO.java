/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.DetailCuti;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernatelUtil;


/**
 *
 * @author Siti Khusnul Azifah
 */
public class DetailCutiDAO implements InterfaceCutiDAO {

    public SessionFactory factory;
    public FunctionsDAO fdao;

    public DetailCutiDAO() {
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
         return fdao.delete(DetailCuti.class, Integer.parseInt(object.toString()));
    }

    @Override
    public List<Object> getAll() {
        return fdao.getAll("FROM DetailCuti");
    }

    @Override
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM DetailCuti WHERE " + category + " LIKE '%" + search + "%'");
    }

    @Override
    public Object getById(String id) {
        return fdao.getById("from DetailCuti where id_Detail_Cuti='" + id + "'");
    }

}
