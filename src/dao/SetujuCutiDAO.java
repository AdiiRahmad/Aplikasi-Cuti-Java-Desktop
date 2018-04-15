/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Cuti;
import entities.SetujuCuti;
import java.util.List;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernatelUtil;

/**
 *
 * @author AdiRahmad
 */
public class SetujuCutiDAO implements InterfaceCutiDAO{
    
    public SessionFactory factory;

    public FunctionsDAO fdao;

    public SetujuCutiDAO() {
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
        return fdao.delete(SetujuCuti.class,object.toString());
    }


    public List<Object> getAll() {
        return fdao.getAll("From SetujuCuti");
    }

    @Override
    public List<Object> search(String category, String search) {
        return fdao.getAll("From SetujuCuti WHERE " + category + " LIKE '%" + search + "%'");
    }

    @Override
    public Object getById(String id) {
        return fdao.getById("" + id + "");
    }
}
