package db;

import models.Musician;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBMusician {

    private static Session session;
    private static Transaction transaction;

    public static void save(Musician musician){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.save(musician);
            transaction.commit();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Musician> getAll(){
        List<Musician> musicians = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Musician.class);
            musicians = cr.list();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally{
            session.close();
        }
        return musicians;
    }

    public static Musician findById(int id){
        Musician found = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Musician.class);
            cr.add(Restrictions.eq("id", id));
            found = (Musician) cr.uniqueResult();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally{
            session.close();
        }
        return found;
    }

    public static void update(Musician musician){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.update(musician);
            transaction.commit();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Musician musician){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.delete(musician);
            transaction.commit();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally{
            session.close();
        }
    }
}
