package db;

import models.Guitar;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBGuitar {

    private static Session session;
    private static Transaction transaction;

    public static void save(Guitar guitar){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(guitar);
            transaction.commit();
        } catch(HibernateException ex){
            transaction.rollback();
            ex.printStackTrace();
        } finally{
            session.close();
        }
    }

    public static List<Guitar> getAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Guitar> guitars = null;
        try{
            Criteria cr = session.createCriteria(Guitar.class);
            guitars = cr.list();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally{
            session.close();
        }
        return guitars;
    }

    public static Guitar findById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Guitar guitar = null;
        try{
            Criteria cr = session.createCriteria(Guitar.class);
            cr.add(Restrictions.eq("id", id));
            guitar = (Guitar) cr.uniqueResult();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally{
            session.close();
        }
        return guitar;
    }

    public static void update(Guitar guitar){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.update(guitar);
            transaction.commit();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally{
            session.close();
        }
    }

    public static void delete(Guitar guitar){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.delete(guitar);
            transaction.commit();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
}
